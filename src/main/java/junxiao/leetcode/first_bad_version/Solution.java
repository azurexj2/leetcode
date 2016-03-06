package junxiao.leetcode.first_bad_version;

import java.util.*;

public class Solution {
    public int firstBadVersion(int n) {
        int L = 1, H = n;
        while (L<H){
            int M = L + (H-L)/2;
            if (isBadVersion(M)){
                H = M;
            }
            else {
                L = M+1;
            }
        }
        
        return L;
    }
}
