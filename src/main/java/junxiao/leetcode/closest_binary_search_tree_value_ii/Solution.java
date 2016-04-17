package junxiao.leetcode.closest_binary_search_tree_value_ii;

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root,target,k,res);
        return res;
    }
    private void inorder(TreeNode root, double target, int k, List<Integer> res){
        if (root==null) return;
        inorder(root.left,target,k,res);
        if (res.size()==k){
            if (Math.abs(root.val - target) < Math.abs(res.get(0) - target)){
                res.remove(0);
            }
            else 
                return;
        }
        res.add(root.val);
        inorder(root.right,target,k,res);
    }
}
public class Solution {
    private Deque<TreeNode> nextStack = new ArrayDeque<>();;
    private Deque<TreeNode> preStack = new ArrayDeque<>();;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //1. find out the node that the closest to target
        //2. get to function, predecessor, successor
        TreeNode ptr = closest(root, target);
        List<Integer> res = new ArrayList<>();
        res.add(ptr.val);
        inOrder(root, ptr);
        TreeNode pre = predecessor(ptr);
        TreeNode next = successor(ptr);
        while(res.size()<k){
            if (next==null){
                res.add(pre.val);
                pre = predecessor(pre);
            }
            else if (pre==null){
                res.add(next.val);
                next = successor(next);
            }
            else {
                if (Math.abs(pre.val-target) < Math.abs(next.val-target)){
                    res.add(pre.val);
                    pre = predecessor(pre);
                }
                else {
                    res.add(next.val);
                    next = successor(next);
                }
            }
        }
        return res;
        
    }
    private TreeNode closest(TreeNode root, double target){
        TreeNode child = root.val<target? root.right : root.left;
        if (child == null) return root;
        TreeNode candidate = closest(child, target);
        return Math.abs(candidate.val - target)<Math.abs(root.val-target) ? candidate : root;
    }
    private TreeNode predecessor(TreeNode root){
        if (preStack.isEmpty()) return null;
        return preStack.pollFirst();
    }
    private TreeNode successor(TreeNode root){
        if (nextStack.isEmpty()) return null;
        TreeNode res = nextStack.pollFirst();
        TreeNode ptr = res.right;
        while (ptr!=null){
            nextStack.offerFirst(ptr);
            ptr = ptr.left;
        }
        return res;
    }
    private void inOrder(TreeNode root, TreeNode ptr){
        while(root!=null){
            nextStack.offerFirst(root);
            root = root.left;
        }
        while (!nextStack.isEmpty()){
            TreeNode node = nextStack.pollFirst();
            
            TreeNode p = node.right;
            while(p!=null){
                nextStack.offerFirst(p);
                p = p.left;
            }
            if (node == ptr)
                return;
            preStack.offerFirst(node);
        }
    }
}