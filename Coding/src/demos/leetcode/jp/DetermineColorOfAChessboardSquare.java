/*
https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/
 */
package demos.leetcode.jp;

public class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {

        int x = coordinates.charAt(0) - 'a' + 1;
        int y = Integer.parseInt(coordinates.substring(1));

        if ((x+y)%2==0) return false;
        else return true;
    }
}
