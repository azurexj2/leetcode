package junxiao.leetcode.contains_duplicate_iii;

import java.util.*;

public class Solution1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //matain a size k tree, to find out whether thre is number between nums[i]-t and nums[i]+t 
        if (k==0) return false;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i=0; i < nums.length;++i){
            //first compare, then remove the oldes one and insert the new one
            Integer e = tree.ceiling(nums[i]-t);
            if (e!=null){
                //exist one that e>=nums[i]-t
                if (e-t <= nums[i])
                    return true;
            }
            tree.add(nums[i]);
            if (tree.size()>k){
                tree.remove(nums[i-k]);
            }

        }
        return false;
    }
}

public class Solution {
    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the neighbor buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in neighbor buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
}