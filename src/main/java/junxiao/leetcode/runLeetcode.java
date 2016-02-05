package junxiao.leetcode;
import junxiao.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal.*;
import java.util.*;
import junxiao.leetcode.TreeNode;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
        Solution s = new Solution();
        int[] num1 = {1,2};
        int[] num2 = {2,1};
        System.out.println("in leet code main:");
        TreeNode res = s.buildTree(num1, num2);
        }
}


