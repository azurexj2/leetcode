package junxiao.leetcode.basic_calculator;

import java.util.*;

public class Solution {
    public int calculate(String s) {
        if (s.length()==0) return 0;
        int sum = 0;
        int num = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i =0; i < s.length();++i){
            char c = s.charAt(i);
            if (c==' ')
                continue;
            else if (c=='+'){
                    // calcluate 
                    sum += (sign*num);
                    sign = 1;
                    num = 0;
                }
            else if (c=='-'){
                    sum += (sign*num);
                    sign = -1;
                    num = 0;
                }
            else if (c=='('){
                    //put previous num and sign in stack
                    //reset sum
                    stack.addFirst(sum);
                    stack.addFirst(sign);
                    sum = 0;
                    sign = 1;
                }
             else if (c==')'){
                    sum += (sign*num);
                    sign = stack.removeFirst();
                    int tmp = stack.removeFirst();
                    sum = tmp + sign*sum;
                    num = 0;
                    sign = 1;
                }
             else {
                        num = num*10 + c -'0';
                    }
            }
        sum += (sign*num);
        return sum;

    }
}
