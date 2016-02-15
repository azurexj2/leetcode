package junxiao.leetcode.lru_cache;

import java.util.*;

import javax.swing.text.ChangedCharSetException;

class DoubleListNode {
	int key, val;
	DoubleListNode prev, next;
	public DoubleListNode(int key, int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
		this.key = key;
	}
}

public class LRUCache {
    private final int capacity; 
    private Map<Integer, DoubleListNode> cache;
    DoubleListNode head;//most recently used in tail
    DoubleListNode tail;//least recently used in head
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, DoubleListNode>();
        head = new DoubleListNode(-1,-1); //dummy
        tail = new DoubleListNode(-1,-1); //dummy
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
    	DoubleListNode node = cache.get(key);
    	if(node==null){
    		return -1;
    	}
    	else {
    		//hit
    		//1. move node to tail
    		moveToTail(node);
    		return node.val;
    	}
        
    }
    
    public void set(int key, int value) {
    	DoubleListNode node = cache.get(key);
    	if (node==null){
    		// 0. if hit capacity, need remvoe head
    		// 1. need insert to tail
    		// 2. need update map
    		if (cache.size()==capacity){
    			cache.remove(head.next.key);
    			//or use cache.values().remove(head.next.val);
    			removeHead();
    		}
   			DoubleListNode newNode = new DoubleListNode(key,value);
  			addToTail(newNode);
   			cache.put(key, newNode);
    	}
    	else {
    		// need reset val
    		// and move to tail
    		node.val = value;
    		moveToTail(node);
    	}
        
    }
    private void moveToTail(DoubleListNode node){
    	// head -> [] -> tail, dummy head and tail
    		node.prev.next = node.next;
    		node.next.prev = node.prev;
    		tail.prev.next = node;
    		node.prev = tail.prev;
    		tail.prev = node;
    		node.next = tail;
    	
    }
    private void addToTail(DoubleListNode node){
    		tail.prev.next = node;
    		node.prev = tail.prev;
    		tail.prev = node;
    		node.next = tail;
    }
    private void removeHead(){
    	head.next = head.next.next;
    	head.next.prev = head;
    }
}