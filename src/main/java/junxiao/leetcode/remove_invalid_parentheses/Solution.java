package junxiao.leetcode.remove_invalid_parentheses;

import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //bfs
        
        int indL = 0;
        while(indL<s.length() && s.charAt(indL)==')'){
            ++indL;
        }
        int indR = s.length()-1;
        while (indR>=0 && s.charAt(indR)=='('){
            --indR;
        }
        String input = s.substring(indL,indR+1);
        int leftCount = 0, rightCount=0;
        for (int i = 0; i < input.length();++i){
            if (input.charAt(i)=='('){
                ++leftCount;
            }
            else if (input.charAt(i)==')'){
                if (leftCount<=0){
                    ++rightCount;
                }
                else {
                    --leftCount;
                }
            }
        }
        // leftCount and rightCount is the number we need remove
        Set<String> visited = new HashSet<>();
        dfs(visited,input,leftCount,rightCount,0,"");
        List<String> res = new ArrayList<>(visited);
        
        return res;
        
    }
    private void dfs(Set<String> res, String s, int leftCount, int rightCount, int pos,String path){
        if (pos==s.length()){
            if (leftCount==0 && rightCount==0 && valid(path)){
                res.add(path);
            }
            return;
        }
        char c = s.charAt(pos);
        if (c=='('){
            // with or without (
                dfs(res,s,leftCount,rightCount,pos+1,path+c);
            if (leftCount>0)
                dfs(res,s,leftCount-1,rightCount,pos+1,path);
        }
        else if (c==')'){
            dfs(res,s,leftCount,rightCount,pos+1,path+c);
            if (rightCount>0)
                dfs(res,s,leftCount,rightCount-1,pos+1,path);
        }
        else {
            dfs(res,s,leftCount, rightCount, pos+1, path+c);
        }
    }
    private boolean valid(String s){
        int left =0;
        for (int i =0; i <s.length();++i){
            if (s.charAt(i)=='('){
                left++;
            }
            else if (s.charAt(i)==')'){
                --left;
                if (left<0) return false;
            }
        }
        return left==0?true:false;
    }
}
public class Solution2 {
    public List<String> removeInvalidParentheses(String s) {
        //bfs
        
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        int indL = 0;
        while(indL<s.length() && s.charAt(indL)==')'){
            ++indL;
        }
        int indR = s.length()-1;
        while (indR>=0 && s.charAt(indR)=='('){
            --indR;
        }
        String input = s.substring(indL,indR+1);
        queue.offer(input);
        visited.add(input);
        boolean found = false;
        while(!queue.isEmpty()  && !found){
            int count = queue.size();
            for (int i =1; i <=count; ++i){
                String str = queue.poll();
                if (valid(str)){
                    found = true;
                    res.add(str);
                    continue;
                }
                for (int j =0; j <str.length();++j){
                    if (str.charAt(j)=='(' || str.charAt(j)==')'){
                        String ss = str.substring(0,j) + str.substring(j+1);
                        if (visited.contains(ss))
                            continue;
                        visited.add(ss);
                        queue.offer(ss);
                    }
                }
            }
        }
        return res;
        
    }
    private boolean valid(String s){
        int left =0;
        for (int i =0; i <s.length();++i){
            if (s.charAt(i)=='('){
                left++;
            }
            else if (s.charAt(i)==')'){
                --left;
                if (left<0) return false;
            }
        }
        return left==0?true:false;
    }
}