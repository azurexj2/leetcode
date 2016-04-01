package junxiao.leetcode.shortest_word_distance;

import java.util.*;

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        String canditate = null;
        int d = Integer.MAX_VALUE;
        int begin = 0;
        for (int i = 0; i < words.length; ++i){
            if (words[i].equals(word1) || words[i].equals(word2)){
                if (canditate==null){
                    canditate = words[i];
                    begin = i;
                }
                else if (words[i].equals(canditate)){
                    // same, move begin
                    begin = i;
                }
                else {
                    //match
                    int tmpD = i - begin;
                    d = Math.min(d,tmpD);
                    canditate = words[i];
                    begin = i;
                }
            }
        }
        return d;
    }
}
public class Solution2 {
    public int shortestDistance(String[] words, String word1, String word2) {
        String canditate = null;
        int d = Integer.MAX_VALUE;
        int begin = -1;
        for (int i = 0; i < words.length; ++i){
            if (words[i].equals(word1) || words[i].equals(word2)){
                if (begin!=-1 && !words[i].equals(words[begin]) ){
                    d = Math.min(d,i-begin);
                }
                begin = i;
            }
        }
        return d;
    }
}