package junxiao.leetcode.min_stack;

import java.util.*;

class MinStack {
	private Deque<Integer> stack;
	private Deque<Integer> stackMin; 
    public void push(int x) {
        if (stack==null){
        	stack = new ArrayDeque<>();
        	stackMin = new ArrayDeque<>();
        }
        stack.addFirst(x);
        if (stackMin.size()==0 || x <= stackMin.peekFirst()){
        	stackMin.addFirst(x);
        }
    }

    public void pop() {
       int num = stack.removeFirst();
       if (num == stackMin.peekFirst()){
    	   stackMin.removeFirst();
       }
    }

    public int top() {
       return stack.peekFirst(); 
    }

    public int getMin() {
       return stackMin.peekFirst(); 
    }
}