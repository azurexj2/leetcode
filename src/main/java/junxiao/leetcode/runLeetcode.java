package junxiao.leetcode;
import junxiao.leetcode.word_break_ii.*;
import java.util.*;
import junxiao.leetcode.TreeNode;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
        Solution s = new Solution();
        System.out.println("in leet code main:");
        String str = "catsanddog";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> res = s.wordBreak(str, wordDict);
        }
}


