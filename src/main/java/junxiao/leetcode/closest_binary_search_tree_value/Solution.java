package junxiao.leetcode.closest_binary_search_tree_value;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        double d = Double.MAX_VALUE;
        int res = root.val;
        while (root!=null){
            if (root.val >= target){
                //go left
                double tmp = root.val - target;
                if (tmp < d){
                    d = tmp;
                    res = root.val;
                }
                root = root.left;
            }
            else {
                double tmp = target - root.val;
                if (tmp < d){
                    d = tmp;
                    res = root.val;
                }
                root = root.right;
            }
            if (d <=0.5)
                return res;
        }
        return res;
    }
}