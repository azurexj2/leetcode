package junxiao.leetcode.strobogrammatic_number_ii;

import java.util.*;

public class Solution {
    public List<String> findStrobogrammatic(int n){
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