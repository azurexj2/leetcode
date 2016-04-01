package junxiao.leetcode.flip_game;

import java.util.*;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s.length()<=1) return res;
        char[] arr = s.toCharArray();
        for (int i = 1; i<arr.length;++i){
            if (arr[i]=='+' && arr[i-1]=='+'){
                arr[i]='-';
                arr[i-1]='-';
                res.add(String.valueOf(arr));
                arr[i]='+';
                arr[i-1]='+';
            }
        }
        return res;
    }
}