package junxiao.leetcode.lowest_common_ancestor_of_a_binary_search_tree;

import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p==root || q==root) return root;
        if (p.val < root.val && q.val > root.val) return root;
        if (p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
