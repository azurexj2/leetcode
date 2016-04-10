:C:XZ"E
XZ"vvccvcvcvcvcvvcvcc-00-0- n0-0-=ppp[[p[;[wr/;]vkphk[a]]]]package junxiao.leetcode.generalized_abbreviation;

import java.util.*;
public class Solution {
    public List<String> generateAbbreviations(String word) {
        //every position char or 1
        // in the end combine numbers that are together
        List<String> res = new ArrayList<>();
        dfs(word,res,0,"",0);
        return res;
    }
    // count the number in previse level
    // by using count we can avoid the case when cuont>=10, string is difficult to handle
    private void dfs(String word, List<String> res, int level, String pattern, int count){
        if (level==word.length()){
            if (count>0)
                res.add(pattern+String.valueOf(count));
            else 
                res.add(pattern);
            return;
        }
            //char and number
            if (count>0){
                dfs(word,res,level+1,pattern+String.valueOf(count)+word.charAt(level),0);
            }
            else 
                dfs(word,res,level+1,pattern+word.charAt(level),0);

            dfs(word,res,level+1,pattern, count+1);
    }
}
public class Solution1 {
    public List<String> generateAbbreviations(String word) {
        //every position char or 1
        // in the end combine numbers that are together
        List<String> res = new ArrayList<>();
        dfs(word,res,0,new char[word.length()]);
        return res;
    }
    private void dfs(String word, List<String> res, int level, char[] pattern){
        if (level==word.length()){
            String str = encode(pattern);
            res.add(str);
            return;
        }
            //char and number
            pattern[level] = word.charAt(level);
            dfs(word,res,level+1,pattern);
            pattern[level] = '1';
            dfs(word,res,level+1,pattern);
    }
    private String encode(char[] pattern){
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i =0; i < pattern.length;++i){
            if (!Character.isDigit(pattern[i])){
                if (count>0){
                    res.append(count);
                    count=0;
                }
                res.append(pattern[i]);
            }
            else {
                ++count;
            }
        }
        if (count>0)
            res.append(count);
        return res.toString();
    }
}