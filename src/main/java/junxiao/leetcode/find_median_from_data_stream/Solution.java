package junxiao.leetcode.find_median_from_data_stream;

import java.util.*;

class MedianFinder {
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        //alwasy make maxHeap one more element
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size()>minHeap.size()) return 1.0*maxHeap.peek();
        else 
            return (maxHeap.peek() + minHeap.peek())/2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();