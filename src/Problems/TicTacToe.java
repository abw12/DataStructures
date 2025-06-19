package Problems;

/*
Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

        Players take turns placing characters into empty squares ' '.
        The first player A always places 'X' characters, while the second player B always places 'O' characters.
        'X' and 'O' characters are always placed into empty squares, never on filled ones.
        The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
        The game also ends if all squares are non-empty.
        No more moves can be played if the game is over.
        Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli].
        return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw".
         If there are still movements to play return "Pending".

        You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
*/

public class TicTacToe {

    static int n = 3;

    public static void main(String[] args) {

        //player1 = X and player2 = O
        //matrix is filler alternately ,player1 plays first
        int[][] matrix = {{0,0},{2,0},{1,1},{2,1},{2,2}};

        System.out.println(tictactoe(matrix));

    }
    public static String tictactoe(int[][] moves) {
        char[][]board = new char[n][n];
        for(int i=0 ; i < moves.length ; i++){
            int row = moves[i][0];
            int col = moves[i][1];
            //to check which player is playing bitwise operator is used to find odd and even player (even = player A)
            if((i & 1) == 0){
                //even player ie player A = 'X'
                board[row][col] = 'X';
                if(didWin(board,row,col,'X')) return "A"; //player A won
            }else{
                //odd player ie player B = 'O'
                board[row][col] = 'O';
                if(didWin(board,row,col,'O')) return "B"; //player B won
            }
        }
        return moves.length == n * n ? "Draw" : "Pending";
    }

    public static boolean didWin(char[][]board,int row,int col,char player){
        //flag to check if player won
        boolean didPlayerWin = true;

        //check current row
        for(int i=0 ; i < n ; i++){
            if(board[row][i] != player)
                didPlayerWin=false;
        }
        if(didPlayerWin) return true; //player win

        //check current column
        didPlayerWin =true;
        for(int i=0 ; i < n ; i++){
            if(board[i][col] != player)
                didPlayerWin=false;
        }
        if(didPlayerWin) return true; //player win

        //check diagonal
        if(row == col){
            didPlayerWin =true;
            for(int i=0 ; i < n ; i++){
                if(board[i][i] != player)
                    didPlayerWin=false;
            }
            if(didPlayerWin) return true; //player win
        }

        //check reverse diagonal (skew diagonal)
        if(col == n - row -1){  // here col =2 and 3 - 2 -1 = 2 become true ,only statify this condition
            didPlayerWin =true;
            for(int i=0 ; i < n ; i++){
                if(board[i][n - i -1] != player)
                    didPlayerWin=false;
            }
            if(didPlayerWin) return true; //player win
        }
        return false; //player did not win
    }
}
