package LeetCode.Two_Pointer;


/*You are given an integer array height of length n.
        There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

        Find two lines that together with the x-axis form a container, such that the container contains the most water.

        Return the maximum amount of water a container can store.

        Notice that you may not slant the container.*/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left =0;
        int right = height.length - 1 ;
        int water =0;
        while(left < right){
            water = Math.max(water, (right - left) * Math.min(height[left],height[right])); //basically we are doing width * height
            //since we can't have a container which is slanted eliminate the smaller height line
            //(since The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration. )
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return water;
    }
}
