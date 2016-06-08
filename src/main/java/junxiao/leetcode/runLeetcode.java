package junxiao.leetcode;
import java.util.*;
import junxiao.leetcode.russian_doll_envelopes.*;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
    	Solution s = new Solution();
    	int[][] input = new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
    	int res = s.maxEnvelopes(input);
    	System.out.println(res);
    }
}


