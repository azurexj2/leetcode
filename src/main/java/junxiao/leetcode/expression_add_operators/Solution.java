package junxiao.leetcode.expression_add_operators;

import java.util.*;

public class Solution {
    public List<String> addOperators(String num, int target) {
       /*
       dfs, insert "+-*" between all possible number
       for multiply: 2-3*4, we need pass previous number to next dfs
       then val - added + added*cur, and pass added*cur to next
       */
       List<String> res = new ArrayList<>();
       dfs(num,target,0,0,0,"",res);
       return res;
    }
    private void dfs(String num, int target, int pos, long val,long pre, String path, List<String> res){
        if (pos == num.length()){
            if (val==target){
                res.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length();++i){
            if (i!=pos && num.charAt(pos)=='0')
                continue;
            //becaurful, need bypass num as "012", this is not valid number
            long cur = Long.valueOf(num.substring(pos,i+1));
            //also need handle the first number case
            if (pos==0){
                dfs(num,target,i+1, cur, cur, path+cur,res);
                continue;
            }
            dfs(num,target,i+1, val + cur, cur,  path+"+"+cur,res);
            dfs(num,target,i+1, val - cur, -cur,  path+"-"+cur,res);
            dfs(num,target,i+1, val - pre + pre*cur, pre*cur,  path+"*"+cur,res);
        }
    }
}