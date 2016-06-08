package junxiao.leetcode.russian_doll_envelopes;

import java.util.*;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2)->{
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int len = envelopes.length;
        int[] count = new int[len];
        if (len<=1) return len;
        count[0] = envelopes[0][1];
        int ind = 0;
        //longest increaing sequence
        for (int[] env : envelopes){
            //only care env[1]
            if (env[1] <= count[0]){
                count[0] = env[1];
            }
            else if (env[1]>count[ind]){
                count[++ind] = env[1];
            }
            else {
                //pos is the least number that >= env[1]
                int pos = search(count,0,ind,env[1]);
                count[pos] = env[1];
            }
        }
        return ind+1;
    }
    private int search(int[] count, int L, int H, int target){
        while(L<=H){
            int M = L +(H-L)/2;
            if (count[M] == target)
                return M;
            else if (count[M] < target)
                L = M +1;
            else 
                H = M-1;
        }
        return  L;
    }
}