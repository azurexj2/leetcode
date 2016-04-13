package junxiao.leetcode.super_ugly_number;

import java.util.*;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] ind = new int[primes.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (e1,e2)->(ugly[ind[e1]]*primes[e1] - ugly[ind[e2]]*primes[e2]));
        ugly[0] = 1;
        for (int i =0; i<primes.length;++i){
            heap.offer(i);
        }
        
        int count = 1;
        while (count<n){
            int minInd = heap.poll();
            int candidate = ugly[ind[minInd]]*primes[minInd];
            //need remove dupicate
            if (candidate!=ugly[count-1]){
                //we have new value
                ++count;
                ugly[count-1] = candidate;
            }
            ind[minInd]++;
            heap.offer(minInd);
        }
        
        return ugly[n-1];
    }
}
public class Solution1 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        nums[0] = 1;
        int[] ind = new int[primes.length];
        for (int i=1;i<n;++i){
            int minOfCandidate = Integer.MAX_VALUE;
            for (int j=0;j<primes.length;++j){
                minOfCandidate = Math.min(minOfCandidate,nums[ind[j]]*primes[j]);
            }
            nums[i] = minOfCandidate;
            for (int j=0;j<primes.length;++j){
                if (minOfCandidate%primes[j]==0)
                    ind[j]++;
            }
        }
        return nums[n-1];
    }
}