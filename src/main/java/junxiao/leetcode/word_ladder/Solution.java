package junxiao.leetcode.word_ladder;

import java.util.*;

public class Solution {
	private int minCount = 0;
	public int ladderLength(String beginWord, String endWord, Set<String> wordList){
		Map<String, Boolean> visited = new HashMap<>();
		visited.put(beginWord, true);
		dfs(beginWord, endWord, wordList, visited,0);
		return minCount;
	}
	private void dfs(String beginWord,String endWord, 
			    Set<String> wordList, Map<String,Boolean> visited,
			    int count){
		if (beginWord.equals(endWord)){
			if (minCount==0) minCount = count;
			else {
     		   minCount = Math.min(minCount, count);	
			}
		   return;
		}
		int len = beginWord.length();
		for (int i =0;i<len;++i){
			for(char c='a';c<='z';++c){
				if (c==beginWord.charAt(i)) continue;
				StringBuilder newStr = new StringBuilder(beginWord);
				newStr.setCharAt(i, c);
				String ss = newStr.toString();
				if (!wordList.contains(ss))
					continue;
				if (visited.get(ss)==null){
					// not visited
					visited.put(ss, true);
					dfs(ss,endWord,wordList,visited,count+1);
					visited.put(ss,false);
				}
			}
		}
	}
	public int ladderLength2(String beginWord, String endWord, Set<String> wordList){
		int level = 1;
		Deque<String> queue = new ArrayDeque<>();
		int len = beginWord.length();
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		queue.add(beginWord);
		while(!queue.isEmpty()){
			int count = queue.size();
			for(int i=1;i<=count;++i){
				char[] str = queue.remove().toCharArray();
				for (int j=0;j<len;++j){
					for (char c ='a';c<='z';++c){
        				if (c==str[j]) continue;
        				char old = str[j];
        				str[j] = c;
        				String ss = String.valueOf(str);
        				str[j] = old;
				        if (ss.equals(endWord)) return level+1;
        				if (!wordList.contains(ss))
        					continue;
        				if (!visited.contains(ss)){
        					// not visited
        					queue.add(ss);
        					visited.add(ss);
        				}
					}
				}
			}
			++level;
		}
		return 0;
	}
	public int ladderLength3(String beginWord, String endWord, Set<String> wordList){
		Set<String> forward = new HashSet<>();
		Set<String> backward = new HashSet<>();
		Set<String> visited = new HashSet<>();
		forward.add(beginWord);
		backward.add(endWord);
		visited.add(beginWord);
		visited.add(endWord);
		return bfs(forward, backward, visited,wordList, 1);
		
	}
	private int bfs(Set<String> set1, Set<String> set2, 
			       Set<String> visited, 
			       Set<String> wordList, int level ){
		if (set1.isEmpty()) return 0;
		if (set1.size()>set2.size())
			return bfs(set2, set1, visited,wordList, level);
		
		Set<String> next = new HashSet<>(); 
		for (String str: set1){
			//for each str in set1,
			//look for whether distance 1 word 
			// is in set2.
			char[] ss = str.toCharArray();
			for (int i = 0;i<str.length();++i){
				for (char c='a';c<='z';++c){
					char old = ss[i];
					if (c==ss[i]){
						continue;
					}
					ss[i] = c;
					String newStr = String.valueOf(ss);
					ss[i] = old;
					if (!wordList.contains(newStr))
						continue;
					if (set2.contains(newStr)){
						return level+1;
					}
					if (visited.contains(newStr)){
						continue;
					}
					//we need put it in next level set
					next.add(newStr);
					visited.add(newStr);
				}
			}
			
		}
		return bfs(next, set2, visited, wordList, level+1);
		
	}
}
