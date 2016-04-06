package junxiao.leetcode.number_of_connected_components_in_an_undirected_graph;

import java.util.*;
//https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
public class Solution {
    private int[] father;
    private int[] size;
    public int countComponents(int n, int[][] edges) {
        //union, bfs or dfs
        father  = new int[n];
        for (int i =0;i <n; ++i){
            father[i] = i;
            size[i] = 1;
        }
        for (int[] e : edges){
            if (!sameUnion(e[0],e[1])){
                 union(e[0],e[1]);
                 --n;
            }
        }
        return n;
    }
    private boolean sameUnion(int i, int j){
        if (findFather(i)==findFather(j))
            return true;
        return false;
    }
    public int countComponents2(int n, int[][] edges) {
        //union, bfs or dfs
        father  = new int[n];
        for (int i =0;i <n; ++i){
            father[i] = i;
        }
        for (int[] e : edges){
            union(e[0],e[1]);
        }
        Set<Integer> set  = new HashSet<>();
        for (int i =0; i < n; ++i){
            set.add(findFather(i));
        }
        return set.size();
    }
    private void union(int p, int q){
        int i = findFather(p);
        int j = findFather(q);
        if (size[i]<size[j]){
            father[i] = j;
            size[j] += size[i];
        }
        else {
            father[j] = i;
            size[i] += size[j];
        }
    }
    private int findFather(int i){
        while (father[i]!=i)
            i = father[i];
        return i;
    }
}