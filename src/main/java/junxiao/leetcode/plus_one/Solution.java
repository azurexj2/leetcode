package junxiao.leetcode.plus_one;

import java.util.*;

public class Solution {
    public int[] plusOne(int[] digits) {
       int carry = 1;
       int n = digits.length;
       List<Integer> res = new ArrayList<>();
       for (int i = n-1; i>=0;--i){
    	   int tmp = digits[i]+carry;
    	   carry = tmp/10;
    	   res.add(tmp%10);
       }
       if (carry>0)
    	   res.add(1);
       Collections.reverse(res);
       int[] num = res.stream().mapToInt(i -> i).toArray();
       return num;
    }
}
