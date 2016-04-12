package junxiao.leetcode.maximum_product_of_word_lengths;

import java.util.*;

public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] bitMap = new int[len];
        for(int i =0; i <len;++i){
            for (int j =0; j<words[i].length();++j){
                bitMap[i] |= 1<< (words[i].charAt(j)-'a');
            }
        }
        int res = 0;
        for (int i=0;i<len-1;++i){
            for (int j =i+1;j<len;++j){
                if ((bitMap[i] & bitMap[j]) ==0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}