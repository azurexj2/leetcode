package junxiao.leetcode.binary_tree_paths;

import java.util.*;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null) return res;
        String path = new String();
        dfs(root, res, path);
        return res;
    }
    private void dfs(TreeNode root, List<String> res, String path){
        if (root.left==null && root.right==null){
            String tmp = new String(path+root.val);
            res.add(tmp);
            return;
        }
        path += (root.val + "->");
        if (root.left!=null){
            dfs(root.left, res, path);
        }
        if (root.right!=null){
            dfs(root.right,res,path);
        }
        
    }
}
