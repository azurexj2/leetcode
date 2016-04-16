package junxiao.leetcode.additive_number;

import java.util.*;

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int len1 =1; len1 <= len/2; ++len1){
            if (len1>1 && num.charAt(0)=='0') continue;
            for (int len2 = 1; Math.max(len1,len2) <= (len-len1-len2); ++len2){
                if (len2>1 && num.charAt(len1)=='0') continue;
                BigInteger num1 = new BigInteger(num.substring(0,len1));
                BigInteger num2 = new BigInteger(num.substring(len1, len1+len2));
                if (isValid(num1,num2,num.substring(len1+len2)))
                    return true;
            }
        }
        return false;
    }
    private boolean isValid(BigInteger num1, BigInteger num2, String num){
        if (num.length()==0) return true;
        BigInteger sum = num2.add(num1);
        String str = sum.toString();
        if (num.equals(str))
            return true;
        if (str.length()>=num.length())
            return false;
        if (!num.startsWith(str))
            return false;
        return isValid(num2, sum, num.substring(str.length()));
    }
}