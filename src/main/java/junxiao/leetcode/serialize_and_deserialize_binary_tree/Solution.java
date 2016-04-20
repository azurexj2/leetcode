package junxiao.leetcode.serialize_and_deserialize_binary_tree;

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
public class Codec {
    private static final String spliter = ",";
    private static final String end = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        preOrder(root,str);
        return str.toString();
    }
    private void preOrder(TreeNode root, StringBuilder str){
        if (root==null){
            str.append(end).append(spliter);
            return;
        }
        str.append(root.val).append(spliter);
        preOrder(root.left,str);
        preOrder(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(spliter)));
        return buildTree(queue);
    }
    private TreeNode buildTree(Deque<String> queue){
        if (queue.isEmpty()) return null;
        String val = queue.poll();
        if (val.equals(end)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        TreeNode left = buildTree(queue);
        TreeNode right = buildTree(queue);
        node.left = left;
        node.right = right;
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));