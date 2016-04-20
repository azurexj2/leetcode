package junxiao.leetcode.alien_dictionary;

import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[256];
        Arrays.fill(inDegree, -1);
        if (words.length==0) return "";
        if (words.length==1) return words[0];
        String pre = words[0];
        for (int i =1; i <words.length; ++i){
            String cur = words[i];
            for (int k =0;k<pre.length();++k){
                inDegree[pre.charAt(k)] = Math.max(0,inDegree[pre.charAt(k)]);
            }
            for (int k =0;k<cur.length();++k){
                inDegree[cur.charAt(k)] = Math.max(0,inDegree[cur.charAt(k)]);
            }
            for (int j=0; j<pre.length()&&j<cur.length();++j){
                char c1 = pre.charAt(j);
                char c2 = cur.charAt(j);
                if (c1!=c2){
                    // c1==>c2
                    if (!graph.containsKey(c1)){
                        Set<Character> neibor = new HashSet<>();
                        graph.put(c1,neibor);
                    }
                    if (graph.get(c1).add(c2))
                        inDegree[c2] +=1;
                    break;
                }
            }
            pre = cur;
        }
        // now we have indegree and graph
        // topolog sort
        StringBuilder res = new StringBuilder();
        Deque<Character> queue = new ArrayDeque<>();
        for (char c='a'; c<='z';++c){
            if(inDegree[c]==0){
                queue.offer(c);
            }
        }
        while(!queue.isEmpty()){
            char c = queue.poll();
            // c is degree zero node
            res.append(c);
            if (!graph.containsKey(c)){
            	continue;
            }
            for (Character neibor : graph.get(c)){
                inDegree[neibor]--;
                if (inDegree[neibor] == 0){
                    queue.offer(neibor);
                }
            }
        }
        //check wheter we have left
        for (char c ='a'; c<='z';++c){
            if (inDegree[c]>0)
                return "";
        }
        return res.toString();
    }
}