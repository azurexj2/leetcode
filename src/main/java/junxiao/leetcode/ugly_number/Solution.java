package junxiao.leetcode.ugly_number;

import java.util.*;

public class Solution {
    public boolean isUgly(int num) {
        if (num<=0) return false;
        if (num==1) return true;
        //2,3,5
        while (num >1 && num%2 ==0){
            num /= 2;
        }
        while (num >1 && num%3 ==0){
            num /= 3;
        }
        while (num >1 && num%5 ==0){
            num /= 5;
        }
        return num==1? true : false;
    }
}
