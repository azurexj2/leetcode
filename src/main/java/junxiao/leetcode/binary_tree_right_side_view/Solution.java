package junxiao.leetcode.binary_tree_right_side_view;

import java.util.*;

import com.sun.corba.se.impl.orbutil.graph.Node;

import junxiao.leetcode.TreeNode;

public class Solution {
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root==null) return res;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int count = queue.size();
			res.add(queue.peekLast().val);
			TreeNode node;
			for(int i = 1; i<=count;++i){
				node = queue.remove();
				if (node.left!=null){
					queue.add(node.left);
				}
				if (node.right!=null)
					queue.add(node.right);
			}
		}
		return res;
		
	}
	public List<Integer> rightSideView2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root==null) return res;
		dfs(root, 0, res);
		return res;
		
	}
	private void dfs(TreeNode root, int layer, List<Integer> res){
		if (root==null) return;
		if (layer > res.size())
			res.add(root.val);
		dfs(root.right, layer+1, res);
		dfs(root.left, layer+1, res);
	}
}
