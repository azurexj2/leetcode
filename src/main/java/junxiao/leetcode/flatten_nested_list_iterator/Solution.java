package junxiao.leetcode.flatten_nested_list_iterator;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<NestedInteger>();
        for (NestedInteger l : nestedList){
            stack.offerLast(l);
        }
        moveToNext();
    }

    @Override
    public Integer next() {
        int res = stack.pollFirst().getInteger();
        moveToNext();
        return res;
    }

    @Override
    public boolean hasNext() {
        return stack.isEmpty()?false:true;
    }
    private void moveToNext(){
        while(!stack.isEmpty() && !stack.peekFirst().isInteger()){
            // until we get a integer, other wise go in to the list
            // now the stack.peek is list
            List<NestedInteger> list = stack.pollFirst().getList();
            for(int i = list.size()-1; i>=0;--i){
                stack.offerFirst(list.get(i));
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */