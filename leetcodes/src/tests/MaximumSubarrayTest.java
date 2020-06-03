package tests;

public class MaximumSubarrayTest {

    public  int maxSubArray(int [] nums){

        int max = 0;
        int sum = nums[0];

        for (int i = 0; i < nums.length; i ++){

            max = Math.max(nums[i], max + nums[i]);
            sum = Math.max(max,sum);
        }

        return sum;

    }

    public static int maxSubsum1(int [] a){

        int maxSum = 0, thisSum = 0;
        for(int j = 0; j < a.length; j ++){
            thisSum+=a[j];
            if(thisSum > maxSum){
                maxSum = thisSum;
            }else if(thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }

//    利用分治思想

    public static int maxSum2(int [] a, int left, int right){

        if(left == right){
            if(a[left] > 0){
                return a[left];
            }else{
                return 0;
            }
        }

        int center = (left + right)/2;
        int maxLeftSum = maxSum2(a, left, center);
        int maxRightSum = maxSum2(a, center+1, right);
        int maxLeftBorderSum = 0, leftBordeSum = 0;
        for(int i = center; i >=left; i--){
            leftBordeSum+=a[i];
            if(leftBordeSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBordeSum;
            }
        }
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for(int i = center + 1; i <= right; i++){
            rightBorderSum+=a[i];
            if(rightBorderSum >  maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }
        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum +maxRightBorderSum);
    }
    public static void main(String [] args){

        MaximumSubarrayTest m = new MaximumSubarrayTest();
        int nums [] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum2(nums, 0 , nums.length - 1));

    }
}
