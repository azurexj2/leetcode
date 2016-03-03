package junxiao.leetcode;
import junxiao.leetcode.course_schedule.*;
import java.util.*;
import junxiao.leetcode.TreeNode;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
        Solution s = new Solution();
        int[][] arr = {{1,0},{2,0}};
        boolean res = s.canFinish(3, arr);
        if (res){
        	System.out.println("yes");
        }
        }
}


