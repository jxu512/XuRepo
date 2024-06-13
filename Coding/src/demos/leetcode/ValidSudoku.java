/*
https://leetcode.com/problems/valid-sudoku/description/
 */

package demos.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
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
    }}
