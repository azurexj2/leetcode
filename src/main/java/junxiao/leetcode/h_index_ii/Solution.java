package junxiao.leetcode.h_index_ii;

import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        //let's sort the citations
 // for ind, there are (len -ind +1) paper reminding
 //for first citations[ind] >= (len-ind), we have h = len-ind;
 int len = citations.length;
 if (len==0) return  len;
 int L = 0, H = len -1;
 // use idea that find insertion place
 while(L<=H){
     int M = L + (H-L)/2;
     if (citations[M] >= len -M){
         // M >=h
         H = M -1;
     }
     else {
         // M < h
         L = M + 1;
     }
 }
 return len - L;
}
}
