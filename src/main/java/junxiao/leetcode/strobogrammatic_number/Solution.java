package junxiao.leetcode.strobogrammatic_number;

import java.util.*;

public class Solution {
public boolean isStrobogrammatic(String num) {
    for (int i=0, j=num.length()-1; i <= j; i++, j--)
        if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
            return false;
    return true;
}
}
public class Solution1 {
    public boolean isStrobogrammatic(String num) {
        //reverse, 6<=>9
        //0,1,8
        char[] arr = num.toCharArray();
        int left = 0, right = arr.length-1;
        while (left < right){
            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;
            if (!flip(arr,left) || !flip(arr,right))
                return false;
            ++left;
            --right;
        }
        if (left==right && !flip(arr,left))
            return false;
        return String.valueOf(arr).equals(num);
        
    }
    private boolean flip(char[] arr, int ind){
        if (arr[ind]=='6'){
                        arr[ind] = '9'; 
                        return true;

        }
        else if (arr[ind]=='9'){
                        arr[ind] = '6'; 
                        return true;

        }
        else if (arr[ind]=='0' || arr[ind]=='1' || arr[ind]=='8'){
            return true;
        }
        else
            return false;
    }
}