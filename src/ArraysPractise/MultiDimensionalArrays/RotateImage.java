package ArraysPractise.MultiDimensionalArrays;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
        };
        System.out.println(Arrays.deepToString(rotateImage(matrix)));
    }

    private static int[][] rotateImage(int[][] matrix){

        int len = matrix.length;

        System.out.println(len);
        //first transpose the matrix , eg: matrix[i][j]=matrix[j][i];
        //in transpose the right diagonal remain as it is we swap all other elements with each other
        for(int i=0 ; i < len ; i++){
            for(int j=i ; j < len ; j++){ //iterating from the ith index till the number of col in the matrix
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //now flip the matrix vertically using the below formula
        //eg: swapping the 0th col with the 2nd col in 3 x 3 matrix hence inner loop is iterating only once on j pointer
        //basically row is incrementing and the col is remaining the same (ie the last col in nxn matrix)
        for(int i=0 ; i < len ; i++){
            for(int j=0 ; j < len/2 ;j ++){ //going until second last index of the total length of the rows
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][len-1-j];
                matrix[i][len-1-j]=temp;
            }
        }
        return matrix;

    }
}
