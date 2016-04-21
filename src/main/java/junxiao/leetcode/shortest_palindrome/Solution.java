package junxiao.leetcode.shortest_palindrome;

import java.util.*;
public class Solution {
    public String shortestPalindrome(String s) {
        /*
        for a string, e.g. abacd, add"#" and append reverse of it
        ==>  abacd#dcaba@
        then the problem become find out the max prefix match suffix
        ==> KMP next table
        */
        StringBuilder rev = new StringBuilder(s);
        String str = s +"#" + rev.reverse().toString() + "@";
        int len = str.length();
        int[] next = new int[len];
        int prefix=0, suffix=2;
        while(suffix<len){
            if (str.charAt(prefix)==str.charAt(suffix-1)){
                ++prefix;
                next[suffix] = prefix;
                ++suffix;
            }
            else if (prefix>0){
                prefix=next[prefix];
            }
            else {
                //prefix==0
                next[suffix]=0;
                ++suffix;
            }
        }
        
        int d = next[len-1];
        StringBuilder target = new StringBuilder(s.substring(d));
        return target.reverse().toString() + s;
        
    }
}
public class Solution2 {
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