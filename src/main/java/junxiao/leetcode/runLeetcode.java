package junxiao.leetcode;
import junxiao.leetcode.two_sum.Solution;
import java.util.*;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
        Solution s = new Solution();
        int[] num = {1, 2, 3};
        int target = 4;
        int[] res = s.twoSum(num, target);
        System.out.println(res[0]);
        System.out.println(res[1]);}
}


