/*
* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
* Each row must contain the digits 1-9 without repetition.
* Each column must contain the digits 1-9 without repetition.
* Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*
* Note:
* A Sudoku board (partially filled) could be valid but is not necessarily solvable.
* Only the filled cells need to be validated according to the mentioned rules.
*
* Example 1:
* Input: board = [["5","3",".",".","7",".",".",".","."]
*                ,["6",".",".","1","9","5",".",".","."]
*                ,[".","9","8",".",".",".",".","6","."]
*                ,["8",".",".",".","6",".",".",".","3"]
*                ,["4",".",".","8",".","3",".",".","1"]
*                ,["7",".",".",".","2",".",".",".","6"]
*                ,[".","6",".",".",".",".","2","8","."]
*                ,[".",".",".","4","1","9",".",".","5"]
*                ,[".",".",".",".","8",".",".","7","9"]]
* Output: true
*
* Example 2:
* Input: board = [["8","3",".",".","7",".",".",".","."]
*                ,["6",".",".","1","9","5",".",".","."]
*                ,[".","9","8",".",".",".",".","6","."]
*                ,["8",".",".",".","6",".",".",".","3"]
*                ,["4",".",".","8",".","3",".",".","1"]
*                ,["7",".",".",".","2",".",".",".","6"]
*                ,[".","6",".",".",".",".","2","8","."]
*                ,[".",".",".","4","1","9",".",".","5"]
*                ,[".",".",".",".","8",".",".","7","9"]]
* Output: false
* Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
*
* Constraints:
* board.length == 9
* board[i].length == 9
* board[i][j] is a digit 1-9 or '.'.
*
*/
package com.leetcode.practice1;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(isValid && board[i][j] != '.'){
                    isValid = checkHorizontal(board, i , j) && checkVertical(board, i ,j) && checkSubBox(board, i, j);
                }
            }
            if(!isValid){
                break;
            }
        }
        return isValid;
    }
    public static boolean checkVertical(char[][] board, int i, int j){
        boolean isValid = true;
        for(int y = 0; y<9; y++){
            isValid = !(y != i && board[y][j] == board[i][j]);
            if(!isValid){
                break;
            }
        }
        return isValid;
    }

    public static boolean checkHorizontal(char[][] board, int i, int j){
        boolean isValid = true;
        for(int x = 0; x<9; x++){
            isValid = !(x != j && board[i][x] == board[i][j]);
            if(!isValid){
                break;
            }
        }
        return isValid;
    }

    public static boolean checkSubBox(char[][] board, int i, int j){
        boolean isValid = true;
        int xStart = 3*(i/3), xEnd = xStart+3;
        int yStart = 3*(j/3), yEnd = yStart+3;
        outer:
        for(int x = xStart; x<xEnd; x++){
            for(int y = yStart; y<yEnd; y++) {
                isValid = !(x!=i && y!=j && board[x][y] == board[i][j]);
                if (!isValid) {
                    break outer;
                }
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                 {'8' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'}
                ,{'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'}
                ,{'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'}
                ,{'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'}
                ,{'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'}
                ,{'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'}
                ,{'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'}
                ,{'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'}
                ,{'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}};
        System.out.println(isValidSudoku(board1));


        char[][] board2 = new char[][]{
                 {'5' , '3', '.' , '.' , '7' , '.' , '.' , '.' , '.'}
                ,{'6' , '.', '.' , '1' , '9' , '5' , '.' , '.' , '.'}
                ,{'.' , '9', '8' , '.' , '.' , '.' , '.' , '6' , '.'}
                ,{'8' , '.', '.' , '.' , '6' , '.' , '.' , '.' , '3'}
                ,{'4' , '.', '.' , '8' , '.' , '3' , '.' , '.' , '1'}
                ,{'7' , '.', '.' , '.' , '2' , '.' , '.' , '.' , '6'}
                ,{'.' , '6', '.' , '.' , '.' , '.' , '2' , '8' , '.'}
                ,{'.' , '.', '.' , '4' , '1' , '9' , '.' , '.' , '5'}
                ,{'.' , '.', '.' , '.' , '8' , '.' , '.' , '7' , '9'}};
        System.out.println(isValidSudoku(board2));

        char[][] board3 = new char[][]{
                 {'.' , '4' , '.' , '.' ,'.' , '.' , '.' , '.' , '.'}
                ,{'.' , '.' , '4' , '.' ,'.' , '.' , '.' , '.' , '.'}
                ,{'.' , '.' , '.' , '1' ,'.' , '.' , '7' , '.' , '.'}
                ,{'.' , '.' , '.' , '.' ,'.' , '.' , '.' , '.' , '.'}
                ,{'.' , '.' , '.' , '3' ,'.' , '.' , '.' , '6' , '.'}
                ,{'.' , '.' , '.' , '.' ,'.' , '6' , '.' , '9' , '.'}
                ,{'.' , '.' , '.' , '.' ,'1' , '.' , '.' , '.' , '.'}
                ,{'.' , '.' , '.' , '.' ,'.' , '.' , '2' , '.' , '.'}
                ,{'.' , '.' , '.' , '8' ,'.' , '.' , '.' , '.' , '.'}};
        System.out.println(isValidSudoku(board3));
    }
}
