package junxiao.leetcode.binary_tree_vertical_order_traversal;

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
    private TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        levelOrder(root);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer n : map.keySet()){
            res.add(map.get(n));
        }
        return res;
    }
    private void levelOrder(TreeNode root){
        if (root==null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> level = new ArrayDeque<>();
        level.offer(1);
        queue.offer(root);
        while(!queue.isEmpty()){
            int count  = queue.size();
            for (int i =1; i <=count;++i){
                TreeNode node = queue.poll();
                int lel = level.poll();
                if (!map.containsKey(lel)){
                    List<Integer> l = new ArrayList<>();
                    map.put(lel,l);
                }
                map.get(lel).add(node.val);
                
                if (node.left!=null){
                    queue.offer(node.left);
                    level.offer(lel-1);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    level.offer(lel+1);
                }
            }
        }
    }
}