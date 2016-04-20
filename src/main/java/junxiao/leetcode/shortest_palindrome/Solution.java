package junxiao.leetcode.shortest_palindrome;

import java.util.*;

public class Solution {
    public String shortestPalindrome(String s) {
        int len =s.length();
        if (len<=1) return s;
        char[] arr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        if (isPal(arr,0,len-1)) return s;
        for (int i=len-2; i>=0; --i){
            if (isPal(arr,0,i)){
                str.append(arr,i+1,len-i-1);
            }
        }
        return str.reverse() + s;
        
        
    }
    private boolean isPal(char[] arr, int start, int end){
        while(start<end){
            if (arr[start++]!=arr[end--])
                return false;
        }
        return true;
    }
    private boolean isPalindrom(char[] str1, int s1,int e1,
                                char[] str2, int s2, int e2){
         for (int i=0; i <= e1-s1; ++i){
             if(str1[s1+i]!=str2[e2-i])
                return false;
         }                   
         return true;
    }
}