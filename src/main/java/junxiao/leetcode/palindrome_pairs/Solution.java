package junxiao.leetcode.palindrome_pairs;

import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        /*
        str1: ba
        str2: cc-ab //left palindrom, str1+str2
        str3: ab-cc //right palindom, str3+str1
        
        becareful duplication case:
        str1:abc // left empty, right =abc, look for cba. ==> 2,1
                 // right empty, left = abc, ==> 1,2
        str2:cba,// same as above, ==>1,2  
        
        but it will fail at ["a", ""]case
        workaround, // left empty, to right empty
         
        */
        List<List<Integer>> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int ind = 0;
        for (String s:words){
            map.put(s,ind++);
        }
        // a "", missing 1,0
        for (int i =0; i<words.length;++i){
            String str = words[i];
            for (int j =0; j <=str.length();++j){
                String str1 = str.substring(0,j);
                String str2 = str.substring(j);
                if (isPal(str1)){
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    Integer pos = map.get(str2rev);
                    if (pos!=null && pos!=i){
                        List<Integer> pair = new ArrayList<>();
                        pair.add(pos);
                        pair.add(i);
                        res.add(pair);
                    }
                }
                if (isPal(str2)){
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    Integer pos = map.get(str1rev);
                    if(pos!=null && pos!=i){
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(pos);
                        res.add(pair);
                    }
                }
            }
        }
        Set<List<Integer>> nodup = new HashSet<>();
        nodup.addAll(res);
        res = new ArrayList<List<Integer>>(nodup);
        return res;
    }
    private boolean isPal(String s){
        int l = 0, r = s.length()-1;
        while(l<r){
            if (s.charAt(l++)!=s.charAt(r--))
                return false;
        }
        return true;
    }
}