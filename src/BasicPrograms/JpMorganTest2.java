package BasicPrograms;


/*2. Given an array of integers. You take an integer k, and go on adding the elements of the array consecutively.
        After each addition, the sum must be at least +1. Find least possible value of k satisfying this condition.
        Example -
        take this array A = [2, -4, 3, 1]
        Suppose k = 3
        3 + A[0] = 3 + 2 = 5
        5 + A[1] = 5 +(-4) = 1
        1 + A[2] = 1 + 3 = 4
        4 + A[3] = 4 + 1 = 5
         For k = 3, each sum is at least +1. No value of k smaller than 3 will satisfy this condition.
        So, answer is k = 3
============================================================================================================
        if A = {2, -5, 3, 1}
        Suppose k = 3
        3 + A[0] = 3 + 2 = 5
        5 + A[1] = 5 +(-5) = 0 // since its less than the +1 value k=3 for above given array does not satisfy the condition . hence k=3 is not the answer here
        1 + A[2] = 1 + 3 = 4
        4 + A[3] = 4 + 1 = 5

        Suppose k = 4
        4 + A[0] = 4 + 2 = 6
        6 + A[1] = 6 +(-5) = 1
        1 + A[2] = 1 + 3 = 4
        4 + A[3] = 4 + 1 = 5

        For k = 4, each sum is at least +1. No value of k smaller than 4 will satisfy this condition.
        So, answer is k = 4
       */
public class JpMorganTest2 {
    public static void main(String[] args) {
        int[] A = {2, -5, 3, 1};
    int min = Integer.MAX_VALUE;
    int sum=0;
    for (int i=0 ;i < A.length ; i++){
        sum=sum+A[i];
        min=Math.min(sum,min);
    }
        System.out.println("Answer is " + (1-min));
    }
}
