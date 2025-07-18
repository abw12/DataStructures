package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;


/*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        Note:

        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.*/
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board ={{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2={{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
//        Same as Example 1, except with the 5 in the top left corner being modified to 8.
//        Since there are two 8's in the top left 3x3 sub-box, it is invalid.

        System.out.println("Board is valid: " + isValidSudoku(board2));
    }

    private static boolean isValidSudoku(char[][] board){

       /* Collect the set of things we see, encoded as strings. For example:

        '6' in row 2 is encoded as "'6' in row 2".
        '6' in column 7 is encoded as "'6' in column 7".
        '6' in the block 0-2 is encoded as "'6' in block 0-2".
        Scream false if we ever fail to add something because it was already added (i.e., seen before) in the set.*/

        Set<String> seen = new HashSet<>();
        for(int i=0 ; i < board.length;i++){
            for(int j=0 ; j < board.length;j++){
                char number = board[i][j];
                if(number != '.'){
                    if(!seen.add(number + " in row " + i)||
                            !seen.add(number + " in column "+j)||
                            !seen.add(number + " in block " + i/3 + "-" + j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
