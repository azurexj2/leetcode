package junxiao.leetcode.strobogrammatic_number_ii;

import java.util.*;

public class Solution {
    public List<String> findStrobogrammatic(int n){
        List<String> res = new ArrayList<>();
        String pattern = "";
        dfs(res,pattern,0,n);
        return res;
    }
    private void dfs(List<String> res, String pattern, int level, int n){
        if (n==level){
            res.add(pattern);
            return;
        }
        if (n%2 == 1 && level==0){
            for (char c : new char[]{'0','1','8'}){
                pattern += c;
                dfs(res,pattern, level+1, n);
                pattern="";
            }
        }
        else {
            char[] left = new char[]{'0','1','6','8','9'};
            char[] right = new char[]{'0','1','9','8','6'};
            for (int i=0; i <5; ++i ){
                if (level==n-2 && i==0) continue;
                pattern = left[i] + pattern + right[i];
                dfs(res,pattern,level+2,n);
                pattern = pattern.substring(1,pattern.length()-1);
            }
        }
    }
    public List<String> findStrobogrammatic2(int n){
        return helper(n, n);
    }
    public List<String> helper(int n, int m) {
        List<String> res = new ArrayList<>();
        if (n==0){
            res.add("");
            return res;
        }
        if (n==1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> subList = helper(n-2,m);

        for (String s : subList){
            if (n!=m){
                res.add(0 + s + 0);
            }
            res.add(1 + s + 1);
            res.add(6 + s + 9);
            res.add(8 + s + 8);
            res.add(9 + s + 6);
        }
        return res;
    }
}