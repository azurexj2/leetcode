package junxiao.leetcode.different_ways_to_add_parentheses;

import java.util.*;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return helper(input, map);
    }
    private List<Integer> helper(String input, Map<String, List<Integer>> map){
        if (map.containsKey(input))
            return map.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i =0; i <input.length();++i){
            if ("+-*".indexOf(input.charAt(i))!=-1){
                List<Integer> l1 = helper(input.substring(0,i),map);
                List<Integer> l2 = helper(input.substring(i+1),map);
                for (Integer n1 : l1){
                    for (Integer n2 : l2){
                        int e = compute(n1,n2,input.charAt(i));
                        res.add(e);
                    }
                }
            }
        }
        //deal with all digital case
        if (res.isEmpty()){
            int e = Integer.valueOf(input);
            res.add(e);
        }
        map.put(input,res);
        return res;
    }
    private int compute(int n1, int n2, char c){
        int res = 0;
        switch(c){
            case '+': res = n1+n2;
                      break;
            case '-': res = n1-n2;
                      break;
            case '*': res = n1*n2;
        }
        return res;
    }
}