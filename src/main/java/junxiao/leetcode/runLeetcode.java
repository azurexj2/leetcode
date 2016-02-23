package junxiao.leetcode;
import junxiao.leetcode.substring_with_concatenation_of_all_words.*;
import java.util.*;
import junxiao.leetcode.TreeNode;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
        Solution s = new Solution();
        String str = "wordgoodgoodgoodbestword";
        String[] words = {"word","good", "best","good"};
        System.out.println("in leet code main:");
        s.findSubstring2(str, words);
        }
}


