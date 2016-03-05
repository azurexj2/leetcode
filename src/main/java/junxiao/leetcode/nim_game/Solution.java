package junxiao.leetcode.nim_game;

import java.util.*;

public class Solution {
	public boolean canWinNim(int n) {
        if (n<=3) return true;
        return n%4==0? false : true;
    }
}
