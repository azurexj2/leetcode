package junxiao.leetcode.kth_smallest_element_in_a_bst;

import java.util.*;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode ptr = root;
        while(ptr!=null){
            stack.addFirst(ptr);
            ptr = ptr.left;
        }
        while  (!stack.isEmpty()){
            ptr = stack.removeFirst();
            if (--k == 0){
                return ptr.val;
            }
            ptr = ptr.right;
            while (ptr!=null){
                stack.addFirst(ptr);
                ptr = ptr.left;
            }
        }
        return 0;//dummy
    }
}
public class Solution2 {
    private int _k;
    private int kth;
    private boolean done;
    public int kthSmallest(TreeNode root, int k) {
        _k = k;
        travel(root);
        return kth;
    }
    private void travel(TreeNode root){
        if (root==null) return;
        if (root.left!=null)
            travel(root.left);
        if (--_k == 0){
            kth = root.val;
            done = true;
            return;
        }
        if (!done && root.right!=null)
            travel(root.right);
    }
}
