package junxiao.leetcode.palindrome_permutation_ii;

import java.util.*;

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] count = new int[256];
        int oddCount = 0;
        for (char c : s.toCharArray()){
            count[c]++;
        }
        StringBuilder str = new StringBuilder();
        String oddC = "";
        for (char c =0; c <256;++c){
            if (count[c]%2 ==1){
                ++oddCount;
                oddC += c;
                if (oddCount>=2) return res;
            }
            //even case
            for (int j = 1; j<= count[c]/2; ++j){
                str.append(c);    
            }
        }
        
        // now str store the first half of palindorm str
        // do permutation with it, + oddC +reverse
        dfs(str,res,new StringBuilder(),new boolean[str.length()],oddC);
        return res;
        
    }
    private void dfs(StringBuilder s, List<String> res, StringBuilder pattern, boolean[] visited, String oddC){
        if (pattern.length()==s.length()){
            String tmp = pattern.toString() + oddC + pattern.reverse().toString();
            pattern.reverse();
            res.add(tmp);
            return;
        }
        for (int i=0; i<s.length();++i){
            char c = s.charAt(i);
            if (visited[i] || 
                (i>0 && c==s.charAt(i-1) && !visited[i-1])) 
                continue;
            pattern.append(c);
            visited[i] = true;
            dfs(s,res,pattern,visited,oddC);
            pattern.deleteCharAt(pattern.length()-1);
            visited[i] = false;
        }
    }
}