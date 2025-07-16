package LeetCode.Array;

public class RemoveDuplicateFromSortedArrayTwo {
    //[1,1,1,2,2,3]

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3};
        System.out.println(removeDuplicate(arr));
    }

    //allow only one duplicate in the
    private static int removeDuplicate(int[] input){
        int k=2; //final length of array which containing at most twice duplicate element
        for(int i=2;i < input.length; i++){
            if(input[i] != input[k-2]){
                input[k]=input[i];
                k++;
            }
        }
        return k;
    }
}
