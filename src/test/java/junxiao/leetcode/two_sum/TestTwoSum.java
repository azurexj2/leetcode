package junxiao.leetcode.two_sum;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTwoSum {
    private Solution sol = new Solution();
    private int[] arr = {1,2,3};
    private int[] res = {1,3};
    private int target = 4;
    @Test
    public void testStart() {
        assertArrayEquals("test 1, 2, 3, target 4",res,sol.twoSum(arr,target));
    }
}
