package ArraysPractise.LeetCode_Array;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,3,3};
        System.out.println(findMajority(arr));
    }

    private static int findMajority(int[] arr){
        int res=0;int majority=0;
        for(Integer n : arr){
            if(majority == 0)
                res = n;
            if ( res == n)
                majority++;
            else
                majority--;
        }
        return res;
    }
}
