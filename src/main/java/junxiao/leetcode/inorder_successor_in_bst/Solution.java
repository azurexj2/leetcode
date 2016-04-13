package junxiao.leetcode.inorder_successor_in_bst;

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
    Deque<TreeNode> stack = new ArrayDeque<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //case 1, if p.val == root.val, in the right, the smallest
        //case 2, if p.val < root.val, in the left or root
        //case 3, if p.val > root.val, in the right
        /*  
            then in this case, if root==val, no need push left, find min(root.right), if root.right==null,
            then stack.pop(), stack empty, return null
            
        */
        if (root==p){
            TreeNode right = findMinNode(root.right);
            if (right!=null)
                return right;
            else if (!stack.isEmpty()){
                return stack.pollFirst();
            }
            else 
                return null;
        }
        if (root.val < p.val){
            return inorderSuccessor(root.right,p);
        }
        if (root.val > p.val){
            stack.offerFirst(root);
            return inorderSuccessor(root.left,p);
        }
        return root;
    }
    private TreeNode findMinNode(TreeNode root){
        if (root==null) return null;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}