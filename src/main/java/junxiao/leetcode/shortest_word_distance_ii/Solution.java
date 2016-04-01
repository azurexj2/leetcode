package junxiao.leetcode.shortest_word_distance_ii;

import java.util.*;
public class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; ++i){
            String s = words[i];
            List<Integer> pos;
            if (map.containsKey(s)){
                pos = map.get(s);
            }
            else {
                pos = new ArrayList<>();
            }
            pos.add(i);
            map.put(s,pos);
        }

    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int d = Integer.MAX_VALUE;
        for (int ind1 = 0, ind2 = 0; ind1<l1.size() && ind2<l2.size();){
            int p1 = l1.get(ind1), p2 = l2.get(ind2);
            if (p1 < p2){
                d = Math.min(d,p2-p1);
                ++ind1;
            }
            else {
                d = Math.min(d, p1 - p2);
                ++ind2;
            }
            
        }
        return d;
}
}
public class WordDistance1 {
    private Map<String, Integer> map;
    private int[][] table;
    public WordDistance(String[] words) {
        map = new HashMap<String, Integer>();
        int count = 0;
        for (String s : words){
            if (!map.containsKey(s)){
                map.put(s,count);
                ++count;
            }
        }
        table = new int[count][count];
        for (int i = 0; i < count; ++i){
            Arrays.fill(table[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < words.length-1; ++i){
            String s1 = words[i];
            int ind1 = map.get(s1);
            int begin = i;
            for (int j = i+1; j <words.length;++j){
                String s2 = words[j];
                if (s2.equals(s1)){
                    begin = j;
                    continue;
                }
                int ind2 = map.get(s2);
                int tmpD = j - begin;
                table[ind1][ind2] = Math.min(table[ind1][ind2],tmpD);
                table[ind2][ind1] = table[ind1][ind2];
            }
        }
    }

    public int shortest(String word1, String word2) {
        int ind1 = map.get(word1);
        int ind2 = map.get(word2);
        return table[ind1][ind2];
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");