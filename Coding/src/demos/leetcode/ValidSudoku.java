/*
https://leetcode.com/problems/valid-sudoku/description/
 */

package demos.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku1(board));
    }
    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char c = board[i][j];
                if (c != '.')
                    if (!set.add(c + " row " + i) ||
                            !set.add(c + " column " + j) ||
                            !set.add(c + " block " + i/3 + "," + j/3))
                        return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (int i=0;i<9;i++) {
            Set<Character> row = map.computeIfAbsent("row-" + i, k->new HashSet<>());
            for (int j=0;j<9;j++) {
                char num = board[i][j];
                if (num == '.') continue;
                Set<Character> col = map.computeIfAbsent("col-" + j, k->new HashSet<>());
                Set<Character> block = map.computeIfAbsent("block-" + i/3 + "-" + j/3, k->new HashSet<>());
                if (row.contains(num) || col.contains(num) || block.contains(num))
                    return false;
                row.add(num);
                col.add(num);
                block.add(num);
            }
        }

        return true;
    }

}
