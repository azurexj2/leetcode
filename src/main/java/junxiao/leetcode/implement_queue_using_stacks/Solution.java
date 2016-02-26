package junxiao.leetcode.implement_queue_using_stacks;

import java.util.*;

class MyQueue {
    // Push element x to the back of queue.
	private Deque<Integer> pushQ;
	private Deque<Integer> popQ;
	
	public MyQueue(){
   	   pushQ = new ArrayDeque<Integer>();
   	   popQ = new ArrayDeque<Integer>();
	}
	
    public void push(int x) {
    	while(!popQ.isEmpty()){
    		pushQ.addFirst(popQ.removeFirst());
    	}
    	pushQ.addFirst(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!pushQ.isEmpty()){
        	popQ.addFirst(pushQ.removeFirst());
        }
        popQ.removeFirst();
    }

    // Get the front element.
    public int peek() {
        while(!pushQ.isEmpty()){
        	popQ.addFirst(pushQ.removeFirst());
        }
        return popQ.peekFirst();
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return pushQ.isEmpty() && popQ.isEmpty();
        
    }
}
