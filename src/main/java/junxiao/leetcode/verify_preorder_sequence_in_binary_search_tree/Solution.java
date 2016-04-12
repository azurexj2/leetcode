package junxiao.leetcode.verify_preorder_sequence_in_binary_search_tree;

import java.util.*;

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        Integer low = null;
        
        //low is like the root,
        // if n is less than root, push to stack
        // else, then we are in the right tree, pop until the root is poped out
        // keep track the low as every element need larger than the low
        for (Integer n : preorder){
            if (low!=null && n<low) return false;
            while(!stack.isEmpty()  && n > stack.peekFirst()){
                low = stack.poll();
            }
            
            stack.offerFirst(n);
        }
        return true;
    }
}