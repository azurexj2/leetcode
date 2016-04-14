package junxiao.leetcode.find_the_duplicate_number;

import java.util.*;
public class Solution {
    public int findDuplicate(int[] nums) {
        /*
        think about circle linked list
        slow = x + a;
        fast = x + a + c*n;
        2(x+a) = x+a+c*n
        ==> x = (c-1)*n + (n-a)
        which means when they meet, one start from begin, one from the meet point,
        one step each time, the next meet point is the begin of circle
        then the one before meeting point is the duplicate one
        */
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow!=fast){
            slow=nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

public class Solution1 {
    public int findDuplicate(int[] nums) {
        // for a M, two part
        // [1,M-1], M, [M+1,n]
        /*
            count number<=M, if count>M, then duplicate in [1,M], otherwise in [M+1,n]
            each iteration O(n), totle nlogn
        */
        int n = nums.length - 1;
        int L = 1; 
        int H = n;
        while(L<H){
            int M = L + (H-L)/2;
            //count how many number less than M
            int count = 0;
            for (int m: nums){
                if (m<=M)
                    ++count;
            }
            if (count>M){
                H = M;
            }
            else 
                L = M+1;
        }
        return L;
    }
}