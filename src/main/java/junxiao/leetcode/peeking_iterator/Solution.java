package junxiao.leetcode.peeking_iterator;

import java.util.*;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
 private Integer peekedElement;
 private boolean peeked;
 private Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     if (!peeked){
         peekedElement = iterator.next();
         peeked = true;
     }
     return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peeked){
	        Integer res = peekedElement;
	        peeked = false;
	        peekedElement = null;
	        return res;
	    }
	    else {
	        
	        return iterator.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    return peeked || iterator.hasNext(); //caution here for peeked!!!!!!!
	}
}