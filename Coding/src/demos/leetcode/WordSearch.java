/*
https://leetcode.com/problems/word-search/description/
 */

package demos.leetcode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0;i<m;i++) {
            boolean[][] visited = new boolean[m][n];
            for (int j=0;j<n;j++) {
                char[] seq = word.toCharArray();
                if (findWord(board, i, j, visited, seq, 0)) return true;
            }
        }
        return false;
    }

    private boolean findWord(char[][] b, int i, int j, boolean[][] visited, char[] seq, int idx) {
        if (idx > seq.length-1) return true;
        if (i<0 || j<0 || i>=b.length || j>=b[0].length) return false;
        if (visited[i][j]) return false;
        if (seq[idx] != b[i][j]) return false;

        visited[i][j] = true;
        if (findWord(b, i-1,j,visited, seq,idx+1)) return true;
        if (findWord(b, i,j-1,visited, seq,idx+1)) return true;
        if (findWord(b, i+1,j,visited, seq,idx+1)) return true;
        if (findWord(b, i,j+1,visited, seq,idx+1)) return true;
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board,word));
    }
}
