package junxiao.leetcode;
import java.util.*;
import junxiao.leetcode.repeated_dna_sequences.*;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
    	Solution s = new Solution();
    	//int[][] input = new int[][]{{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
    	//char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
    	int[][] input = new int[][]{{0,1}};
    	String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	//Set<String> wordList = new HashSet<>();
    	//wordList.add("hot");
    	//wordList.add("dog");
    	//wordList.add("dot");
    	//List<List<String>> res = s.findLadders("hot", "dog", wordList);
    	List<String> res = s.findRepeatedDnaSequences(str);
    	System.out.println(res);
    }
}


