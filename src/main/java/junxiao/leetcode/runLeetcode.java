package junxiao.leetcode;
import junxiao.leetcode.combination_sum.Solution;
import java.util.*;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
        Solution s = new Solution();
        int[] num = {1};
        int target = 1;
        System.out.println("in leet code main:");
        List<List<Integer>> res = s.combinationSum(num, target);
        for (List<Integer> l : res){
        	l.forEach(System.out::println);
        }
        }
}


