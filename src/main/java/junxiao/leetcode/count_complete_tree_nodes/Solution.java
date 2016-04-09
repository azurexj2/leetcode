package junxiao.leetcode.count_complete_tree_nodes;

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
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        TreeNode lptr = root;
        TreeNode rptr = root;
        int lc=0, rc = 0;
        while(lptr!=null){
            lptr = lptr.left;
            ++lc;
        }
        while(rptr!=null){
            rptr = rptr.right;
            ++rc;
        }
        if (lc==rc){
            //full tree
            return (1<<lc) -1;
        }
        else {
            //if must be rc-lc ==1
            //note T(n) = T(n/2) + logn ==> logn * logn
            // only one tree is not complete
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }
}