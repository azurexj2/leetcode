package junxiao.leetcode.count_univalue_subtrees;

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
    private int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        sameNode(root);
        return count;
    }
    private boolean sameNode(TreeNode root){
        if (root==null) return false;
        boolean leftSame = false;
        if (root.left!=null){
            if (sameNode(root.left) && root.val==root.left.val)
                leftSame = true;
        }
        else 
            leftSame = true;
        boolean rightSame = false;
        if (root.right!=null){
            if (sameNode(root.right) && root.val==root.right.val)
                rightSame = true;
        }
        else 
            rightSame = true;
        if (leftSame && rightSame){
            ++count;
            return true;
        }
        return false;
        
    }
}