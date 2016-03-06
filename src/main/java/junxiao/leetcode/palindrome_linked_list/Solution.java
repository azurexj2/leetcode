package junxiao.leetcode.palindrome_linked_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        int count = 0; 
        ListNode ptr = head;
        while(ptr!=null){
            ++count;
            ptr = ptr.next;
        }
        if (count==1) return true;
        //if count is even, we need move count/2
        //if count is odd, we need move count/2, skip count/2 + 1,
        ptr = head;
        ListNode newHead = null;
        for (int i = 1; i <=count/2; ++i){
            //reverse those count/2 nodes
            ListNode tmpHead = newHead;
            newHead = ptr;
            ptr = ptr.next;
            newHead.next = tmpHead;
        }
        if (count%2==1)
            ptr = ptr.next;
        while (ptr!=null){
            if (ptr.val!=newHead.val)
                return false;
            ptr=ptr.next;
            newHead=newHead.next;
        }
        return true;
        
    }
}
