package junxiao.leetcode.word_search_ii;

import java.util.*;

public class Solution {
    private static final int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res= new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i){
            for (int j =0; j <n; ++j){
                dfs(board,root.next[board[i][j]-'a'],i,j,visited,res);
            }
        }
        return res;
    }
    private void dfs(char[][] board, TrieNode root, int i, int j, boolean[][] visited, List<String> res){
        if (root==null)
            return;
        if (root.wordEnd){
            res.add(root.word);
            root.wordEnd = false;
        }
        visited[i][j] = true;
        for (int[] d: dir){
            int x = i + d[0];
            int y = j + d[1];
            if (x>=0 && x<board.length && y>=0 && y <board[0].length && !visited[x][y]){
                dfs(board,root.next[board[x][y]-'a'],x,y,visited,res);
            }
        }
        visited[i][j] = false;
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String s: words){
            addWord(root,s,0);
        }
        return root;
    }
    private TrieNode addWord(TrieNode root, String word, int level){
        if (root==null){
            root = new TrieNode();
        }
        if (level==word.length()){
            //hit the end
            root.wordEnd = true;
            root.word = word;
            return root;
        }
        int ind = word.charAt(level) - 'a';
        root.next[ind] = addWord(root.next[ind], word, level+1);
        return root;
    }
    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean wordEnd;
        String word;
    }
}