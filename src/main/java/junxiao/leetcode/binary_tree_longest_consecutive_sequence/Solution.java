package junxiao.leetcode.binary_tree_longest_consecutive_sequence;

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
    private int longest;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }
    public int helper(TreeNode root) {
        // return the sequence len start at root
        // store the longest in global variable
        if (root==null) return 0;
        int leftL = 1;
        int rightL = 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if (root.left!=null && root.left.val-root.val==1){
            leftL += left;
        }
        if (root.right!=null && root.right.val-root.val==1){
            rightL += right;
        }
        int len = Math.max(rightL,leftL);
        longest = Math.max(longest,len);
        return len;
    }
}
public class Solution1 {
    public int longestConsecutive(TreeNode root) {
        int[] res = helper(root);
        return res[1];
    }
    public int[] helper(TreeNode root) {
        // return the sequence len start at root
        // and the longest sequence in this sub tree
        if (root==null) return new int[2];
        int leftL = 1;
        int rightL = 1;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (root.left!=null){
            if (root.left.val-root.val==1){
                leftL += left[0];
            }
        }
        if (root.right!=null){
            if (root.right.val-root.val==1){
                rightL += right[0];
            }
        }
        int[] res = new int[2];
        int tmp = Math.max(left[1],right[1]);
        res[0] = Math.max(leftL,rightL);
        res[1] = Math.max(res[0],tmp);
        return res;
    }
}