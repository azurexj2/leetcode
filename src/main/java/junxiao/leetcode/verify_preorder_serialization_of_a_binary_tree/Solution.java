package junxiao.leetcode.verify_preorder_serialization_of_a_binary_tree;

import java.util.*;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        // one node will consume one (out going) edge,
        // if it is not leaf, it will add two (out going edge)
        //when we construct tree, edge should never less than 0, 
        // in the end edge == 0;
        int edge =1;
        for (String s : arr){
            --edge;
            if (edge<0) return false;
            if (!s.equals("#"))
                edge +=2;
        }
        return edge == 0;
        
    }
}