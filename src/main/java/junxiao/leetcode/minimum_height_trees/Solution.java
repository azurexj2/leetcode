package junxiao.leetcode.minimum_height_trees;

import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n==1){
            res.add(0);
            return res;
        }
        if (n==2){
            res.add(0);
            res.add(1);
            return res;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<n;++i){
            graph.add(new HashSet<Integer>());
        }
        for (int[] e :edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        //get all leaf
        Deque<Integer> leaves = new ArrayDeque<>();
        for (int i =0;i<n;++i){
            if (graph.get(i).size()==1)
                leaves.offer(i);
        }
        int count = n;
        while(count>2){
            int size = leaves.size();
            for (int i = 1; i<=size; ++i){
                int node = leaves.poll();
                --count;
                for (int neighbor : graph.get(node)){
                    graph.get(neighbor).remove(node);
                    if (graph.get(neighbor).size()==1)
                        leaves.offer(neighbor);
                }
            }
        }
        for (int m : leaves){
            res.add(m);
        }
        return res;
    }
}