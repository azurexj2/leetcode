package junxiao.leetcode.sliding_window_maximum;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len==0) return new int[0];
        int lenR = len - k +1;
        int[] res = new int[lenR];
        Deque<Integer> queue = new ArrayDeque<>();
        //we mentain a deque,
        // all numbers are in order, largest is at the qurueFirst
        // with new value come in the window, we put it in the queue, remove all vaule less than it
        //which means those removed value are irrevlent to the result
        
        //when number pop out from the window, we compare it with peekFirst,
        //if nums[popOut] != peekFirst, we don't care this number, move on
        // if nums[popOut]==peekFirst, we removeFirst, 
        for (int i = 0; i < k && i < len; ++i){
            while(!queue.isEmpty() && (queue.peekLast() < nums[i])){
                    queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        //need update res[out+1];
        for (int in = k, out =0; in <len;++in,++out){
            if(nums[out]==queue.peekFirst()){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && (queue.peekLast() < nums[in])){
                queue.removeLast();
            }
            queue.addLast(nums[in]);
            res[out+1] = queue.peekFirst();
        }
        return res;
    }
}
