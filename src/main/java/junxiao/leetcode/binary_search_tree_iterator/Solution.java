package junxiao.leetcode.binary_search_tree_iterator;

import java.util.*;
import junxiao.leetcode.TreeNode;
public class BSTIterator {
    private Deque<TreeNode> stack;
    private TreeNode next;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        next = root;
        while(next!=null){
        	stack.addFirst(next);
        	next = next.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty()? false : true;
    }

    /** @return the next smallest number */
    public int next() {
        next = stack.removeFirst();
        int res = next.val;
        if (next.right!=null){
        	next = next.right;
        	while(next!=null){
        		stack.addFirst(next);
        		next = next.left;
        	}
        }
        return res;
    }
}