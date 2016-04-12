package junxiao.leetcode.bulb_switcher;

import java.util.*;

public class Solution {
    public int bulbSwitch(int n) {
        if (n==0) return 0;
        return (int) Math.sqrt(n);
    }
}