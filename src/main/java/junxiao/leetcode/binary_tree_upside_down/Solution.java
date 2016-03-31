package junxiao.leetcode.binary_tree_upside_down;

import java.util.*;

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root==null || root.left==null) return root;
        TreeNode cur = root;
        TreeNode next=null;
        TreeNode pre=null, tmp=null;
        while (cur!=null){
            next = cur.left;
            cur.left = tmp;
            tmp=cur.right;
            cur.right = pre;
            pre = cur;
            cur =next;
        }
        return pre;

    }
}