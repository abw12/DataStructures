package LeetCode.Array;

public class RemoveDuplicateFromSortedArrayTwo {
    //[1,1,1,2,2,3]

    private static int anotherApproach(int[] arr) {
        int count=0;
        int k=1;
        for(int i=0; i < arr.length-1;i++){
            if(arr[i] == arr[i+1] && k > 0){
                k--;
                arr[++count]=arr[i+1];

            }
            if(arr[i] != arr[i+1]) {
                arr[++count] = arr[i + 1];
                if (k == 0)
                    k = 1;
            }
        }
        return count+1;
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

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3};
        System.out.println(removeDuplicate(arr));
        System.out.println(anotherApproach(arr));
    }


}
