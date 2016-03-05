package junxiao.leetcode.odd_even_linked_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;
        boolean isOdd = true;
        while(head!=null){
            if (isOdd){
                oddTail.next = head;
                head = head.next;
                oddTail = oddTail.next;
            }
            else {
                evenTail.next = head;
                head = head.next;
                evenTail = evenTail.next; 
            }
            isOdd = !isOdd;
        }
        oddTail.next = evenDummy.next;
        evenTail.next = null;
        return oddDummy.next;
    }
}
