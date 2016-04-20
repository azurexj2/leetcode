package junxiao.leetcode.strobogrammatic_number_iii;

import java.util.*;

public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> res = new ArrayList<>();
        for(int n = low.length(); n <= high.length(); n++){
            res.addAll(helper(n, n));
        }
        for(String num : res){

            if((num.length() == low.length()&&num.compareTo(low) < 0 ) ||(num.length() == high.length() && num.compareTo(high) > 0)) 
                continue;
            count++;
        }
        return count;
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