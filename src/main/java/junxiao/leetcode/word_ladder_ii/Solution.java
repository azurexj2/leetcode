package junxiao.leetcode.word_ladder_ii;

import java.util.*;

import com.sun.corba.se.spi.activation._ActivatorImplBase;
import com.sun.security.auth.NTDomainPrincipal;

import sun.util.resources.hr.CalendarData_hr;
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> forward = new HashSet<>();
        Set<String> backward = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Map<String,List<String>> path = new HashMap<>();
        forward.add(beginWord);
        backward.add(endWord);
        boolean found = false;
        boolean swaped = false;
        while(!forward.isEmpty() && !backward.isEmpty() && !found){
            if (forward.size() > backward.size()){
                Set<String> tmp = forward;
                forward = backward;
                backward = tmp;
                swaped = !swaped;
            }
            
            Set<String> cur = new HashSet<>();
            for(String s : forward){
                char[] sArr = s.toCharArray();
                for (int i =0; i <beginWord.length();++i){
                    for (char c='a';c<='z';++c){
                        if (sArr[i]==c) continue;
                        char old = sArr[i];
                        sArr[i] = c;
                        String newStr = String.valueOf(sArr);
                        sArr[i] = old;
                        if (backward.contains(newStr)){
                            found = true;
                        }
                        // we need consider the new string added in current level 
                        if (wordList.contains(newStr) && (!visited.contains(newStr) || cur.contains(newStr))){
                            cur.add(newStr);
                            visited.add(newStr);
                            String key = s;
                            String value = newStr;
                            if (swaped){
                                key = newStr;
                                value = s;
                            }
                            
                            if (!path.containsKey(key)){
                                path.put(key, new ArrayList<String>());
                            }
                            path.get(key).add(value);
                        }
                        
                    }
                }
            }
            
            forward = cur;
            
        }
        
        // now path contains the rout from end word to begin word
        List<List<String>> res = new ArrayList<>();
        dfs(res,path,new ArrayList<String>(), beginWord, endWord);
        return res;
        
    }
    private void dfs(List<List<String>> res, Map<String,List<String>> path, List<String> route, String curWord, String endWord){
        if (curWord.equals(endWord)){
            List<String> tmp = new ArrayList<>(route);
            res.add(tmp);
            return;
        }
        if (!path.containsKey(curWord))
            return;
        for (String s : path.get(curWord)){
            route.add(s);
            dfs(res,path,route,s,endWord);
            route.remove(route.size()-1);
        }
    }
}
public class Solution2 {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList){
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> father = new HashMap<>();
		Deque<String> queue = new ArrayDeque<>();
		queue.addLast(beginWord);
		List<String> root = new ArrayList<>();
		root.add("");
		father.put(beginWord, root);
		boolean found=false;
		while(!queue.isEmpty() && found==false){
			int count = queue.size();
			//for one level
			Set<String> curLevel = new HashSet<>();
			for (int k = 1; k<=count;++k){
    			String orinalStr = queue.removeFirst();
    			char[] str = orinalStr.toCharArray();
    			for (int i=0;i<str.length;++i){
    				for (char c = 'a';c<='z';++c){
    					if (c==str[i]) continue;
    					char old = str[i];
    					str[i] = c;
    					//to check whether new str in set or visited
    					String newStr = String.valueOf(str);
    					if (wordList.contains(newStr) && 
    							(!father.containsKey(newStr) || curLevel.contains(newStr))){
    						// we have a new one
    						if (curLevel.contains(newStr)){
    							father.get(newStr).add(orinalStr);
    						}
    						else {
    							List<String> tmpList = new ArrayList<>();
    							tmpList.add(orinalStr);
    							father.put(newStr,tmpList);
    							curLevel.add(newStr);
    							queue.addLast(newStr);
    						}
    						if(newStr.equals(endWord))
    							found = true;
    					}
    					str[i] = old;
    				}
    			}
			}
		}
		if (found==false)
			return res;
	List<String> path = new ArrayList<>();
	dfs(father, res, path, endWord);
	return res;
	}
	private void dfs(Map<String, List<String>> father, List<List<String>> res, 
			   List<String> path, String child){
		if (child.length()==0){
			List<String> tmp = new ArrayList<>(path);
			Collections.reverse(tmp);
			res.add(tmp);
			return;
		}
		List<String> list = father.get(child);
		path.add(child);
		for (String s: list){
			dfs(father, res, path, s);
		}
		path.remove(path.size()-1);
	}
}
