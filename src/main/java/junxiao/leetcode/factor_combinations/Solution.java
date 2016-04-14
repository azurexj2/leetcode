package junxiao.leetcode.factor_combinations;

import java.util.*;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<Integer>(),n,2);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> pattern, int n, int begin){
        
        for (int i =begin;  i <=Math.sqrt(n); ++i){
            if (n%i == 0){
                pattern.add(i);
                pattern.add(n/i);
                List<Integer> tmp = new ArrayList<>(pattern);
                res.add(tmp);
                pattern.remove(pattern.size()-1);
                dfs(res,pattern,n/i,i);
                pattern.remove(pattern.size()-1);
            }
        }
        
    }
}