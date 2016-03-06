package junxiao.leetcode.bulls_and_cows;

import java.util.*;

public class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int bull = 0;
        int cow = 0;
        int[] count = new int[10];
        for (int i=0;i<len;++i){
            if (secret.charAt(i)==guess.charAt(i)){
                ++bull;
            }
            else{
                if (++count[secret.charAt(i)-'0']<=0)
                    ++cow;
                if (--count[guess.charAt(i)-'0']>=0)
                    ++cow;
            }
        }
        String res = bull + "A" + cow + "B";
        return res;
    }
}
