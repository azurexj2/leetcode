package junxiao.leetcode;
import java.util.*;
import junxiao.leetcode.count_of_smaller_numbers_after_self.*;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
    	Solution s = new Solution();
    	//String[] input = {"za","zb","ca","cb"};
    	int[] nums = new int[]{5,2,6,1};
    	List<Integer> res = s.countSmaller(nums);
    	System.out.println(res);
        }
}


