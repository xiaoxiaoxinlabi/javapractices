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

    public static void main(String [] args){

        MaximumSubarrayTest m = new MaximumSubarrayTest();
        int nums [] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray(nums));

    }
}
