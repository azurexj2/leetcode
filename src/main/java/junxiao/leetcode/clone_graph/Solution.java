package junxiao.leetcode.clone_graph;

import java.util.*;

import com.sun.activation.registries.MailcapParseException;
 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 }
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if (node==null) return null;
		UndirectedGraphNode G = new UndirectedGraphNode(node.label);
		Map<Integer, UndirectedGraphNode> map = 
				new HashMap<>();
		map.put(node.label, G);
		Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
		queue.add(node);
		while(!queue.isEmpty()){
			UndirectedGraphNode n = queue.remove();
			UndirectedGraphNode cloned = map.get(n.label);
			//then copy the neighbors
			for (UndirectedGraphNode neighbor: n.neighbors){
				UndirectedGraphNode cur = map.get(neighbor.label);
				if (cur==null){
					//not created, new node we need clone
					cur = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor.label,cur);
					queue.add(neighbor);
				}
				cloned.neighbors.add(cur);
			}
		}
		return G;
	}
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node){
		if (node==null) return null;
		UndirectedGraphNode G = new UndirectedGraphNode(node.label);
		Map<Integer, UndirectedGraphNode> map = 
				new HashMap<>();
		map.put(node.label, G);
		dfs(node, map);
		return G;
	}
	private void dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
		if (node==null) return;
		UndirectedGraphNode cloned = map.get(node.label);
		for(UndirectedGraphNode neighbor: node.neighbors){
			UndirectedGraphNode cur = map.get(neighbor.label);
			if (cur==null){
				cur = new UndirectedGraphNode(neighbor.label);
				map.put(neighbor.label, cur);
				dfs(neighbor, map);
			}
			cloned.neighbors.add(cur);
		}
	}
}
