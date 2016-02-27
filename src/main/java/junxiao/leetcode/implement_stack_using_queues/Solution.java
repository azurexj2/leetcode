package junxiao.leetcode.implement_stack_using_queues;

import java.util.*;

class MyStack {
    // Push element x onto stack.
	private Deque<Integer> queue;
    private int peekLast;
	public MyStack(){
		queue = new ArrayDeque<Integer>();
	}
    public void push(int x) {
    	queue.addLast(x);
    	peekLast = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
    	int len = queue.size();
    	for (int i =1; i < len; ++i){
    		int tmp = queue.removeFirst();
    	    queue.addLast(tmp);	
    	    if (i==len-1)
    	    	peekLast = tmp;
    	}
    	queue.removeFirst();
    }

    // Get the top element.
    public int top() {
    	return peekLast;
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return queue.isEmpty();
    }
}
