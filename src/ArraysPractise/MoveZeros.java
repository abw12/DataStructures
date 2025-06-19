package ArraysPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {
    //in this method first we move all the non- zero element to the front tof the array
    //then fill the remaining indices with 0 . so we have to keep track of how many non-zero element are there in an array
    public static void moveZeros(int[] nums){
        int j=0; //keep track of non-zero elements
        for(int i=0; i < nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }

        }
        for(int i=j; i < nums.length ; i++){
            nums[i]=0;
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] arr={0,3,40,0,9,10,0};
        moveZeros(arr);

        int[] arr1 ={4,6,0,7,9,0,1,3,0};

        int [] result = new int[arr1.length];
        int j=0;

        for(int i=0 ; i< arr1.length ; i++){
            if(arr1[i] > 0){
                result[j++]=arr1[i];
            }
        }

        System.out.println(result);


        //this is the example of failFast where if we try to modify the ArrayList(add,remove,etc) during iterating over list then we get
        //ConcurrentModificationException . Collection hashmap & hasset are also fastFast
        //in failSafe it clone the original array and then we iterate over the copy of OG array hence it does not throws this error
        //example of failSafe is currentHashMap
        List<Integer> failFast =new ArrayList<Integer>();
        failFast.add(10);
        failFast.add(20);
        failFast.add(30);
        failFast.add(40);

//        Iterator it =failFast.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//            failFast.add(14);
//        }

    }
}
