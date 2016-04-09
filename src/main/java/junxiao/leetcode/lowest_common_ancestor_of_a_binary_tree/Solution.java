package junxiao.leetcode.lowest_common_ancestor_of_a_binary_tree;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // three case, 1(p,q both in left), 2(p,q in each side), 3(p,q both in right) 
        // build the table,call lowestCommonAncestor twice, assume like they are in it
        //                  both left,   left and right,  both right
        //root.left(p,q)=>   LCA             p or q         null
        //root.right(p,q)=>  null            p or q         LCA
        if (root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left==null){
            return right;
        }
        else if (right==null)
            return left;
        else
            return root;
    }
}