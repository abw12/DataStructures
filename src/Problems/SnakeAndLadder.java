package Problems;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    public static void main(String[] args) {
        int[][] board =
                {
        {-1,-1,-1,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,35,-1,-1,13,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,15,-1,-1,-1,-1}
                };


        System.out.println(minStepToWin(board));
    }

    private static int minStepToWin(int[][] board){

        int n = board.length;
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(1); //adding the starting square(label in matrix) value into the queue
        //main loop until we tried all the combination from all squares in matrix to reach nxn position
        while(!q.isEmpty()){
            int size=q.size();
            //this loop is for squares that can be added from a particular current square in matrix into the queue for one step
            //basically all possible square that we can reach in one step(one die roll) from a current square
            for(int i=0 ; i < size ; i++){
                int x = q.poll();//current element (label from matrix)
                if(x == n * n) return steps;
                //this for loop is to find the exact coordinate(position in n x n matrix) ie [row][col] of the squares in matrix
                //to identify if that particular[row][col] is having -1 or some positive value (in case of snake/ladder)
                //and we put that [row][col] value(label in matrix) into the queue
                for(int k=1 ; k <=6 ;k++){
                    if(k+x > n * n) break; //checking only until n*n (ie for 6x6 till only 36th square in matrix)
                    //function to find the matrix position [row][col] of the next square which can be reached from current square
                    int[] pos = findCoordinates(k+x,n);
                    int r = pos[0];
                    int c =pos[1];
//                    if(visited[r][c]) continue; //if return true
//                    visited[r][c]=true;
                    if(board[r][c] != -1){ //means there is snake of ladder
                        q.add(board[r][c]); //add the value at the current square(label),will be some positive number
                    }else{
                        q.add(k+x); //add the next square into the queue (next label in board)
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static int[] findCoordinates(int curr,int n){
        int row = n - (curr - 1)/n - 1 ; //since the label are starting from 1 and array is 0th base index we are doing (curr -1)
        int col = (curr - 1) % n;  // to find the col position of current square (label in matrix)
        //to find if borad is even or odd , since the board is in Boustrophedon style ,like alternate rows will be labelled
        // in reversed order.so its like a zigzag numbering . hence to identify this even row will be reversed and odd will be in normal order
        //for example :
        // 12 11 10 9 8 7
        // 1  2  3  4 5 6
        if(row % 2 == n % 2){
            return new int[]{row,n-1-col }; //this is for corner cases example 6th square(label) which will have [4,5] [row,col]
        }else{
            return new int[]{row,col};
        }
    }
}
