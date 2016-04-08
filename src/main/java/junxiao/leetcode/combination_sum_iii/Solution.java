package junxiao.leetcode.combination_sum_iii;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pattern = new ArrayList<>();
        dfs(k,n,res,pattern, 0, 0,1);
        return res;
    }
    public void dfs(int k, int n, List<List<Integer>> res, 
                List<Integer> pattern, int level, int sum, int used){
        if (level==k){
            if (sum==n){
                List<Integer> tmp = new ArrayList<>(pattern);
                res.add(tmp);
            }
            return;
        }
        
        for (int i =used; i <=9 && (sum+i)<=n; ++i){
                pattern.add(i);
                dfs(k,n,res,pattern,level+1,sum+i,i+1);
                pattern.remove(pattern.size()-1);
        }
    }
}