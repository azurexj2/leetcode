package junxiao.leetcode.basic_calculator_ii;

import java.util.*;

public class Solution {
    public int calculate(String s) {
        int len = s.length();
        int sum = 0;
        int sign = 1;
        int num = 0;
        for (int i =0; i <len; ++i){
            char c = s.charAt(i);
            if (c==' ') continue;
            if (c=='+'){
                sum += (sign*num);
                num = 0; 
                sign = 1;
            }
            else if (c=='-'){
                sum += (sign*num);
                num = 0;
                sign = -1;
            }
            else if (c=='*' || c=='/'){
                // need read one more num
                int num2 = 0;
                ++i;
                while(i<len && s.charAt(i)==' '){
                    ++i;
                }
                
                while(i< len && Character.isDigit(s.charAt(i))){
                    num2 = num2*10 + s.charAt(i) - '0';
                    ++i;
                }
                --i;
                if (c=='*'){
                    num = num*num2;
                }
                else {
                    num = num/num2;
                }
            }
            else {
                num = num*10 + c - '0';
            }
            
        }
        return sum + sign*num;
    }
}
