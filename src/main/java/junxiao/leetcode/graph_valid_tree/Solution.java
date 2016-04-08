package junxiao.leetcode.graph_valid_tree;

import java.util.*;

public class Solution {
    private int[] father;
    public boolean validTree(int n, int[][] edges) {
        // 1. count (p,q) to see whether they belone to the same union
        //    if they belone to the same, then circle, return false 
        // 2. at the last, need only one union left
        father = new int[n];
        for (int i =0; i <n; ++i){
            father[i] = i;
        }
        for (int[] e : edges){
            int p = e[0];
            int q = e[1];
            if (root(p)==root(q))
                return false;
            combine(p,q);
            --n;
        }
        return n==1? true: false;
    }
    private void combine(int p, int q){
        int i = root(p);
        int j = root(q);
        if (i!=j){
            father[i] = j;
        }
    }
    private int root(int p){
        while(father[p]!=p){
            father[p] = father[father[p]];
            p = father[p];
        }
        return p;
    }
}