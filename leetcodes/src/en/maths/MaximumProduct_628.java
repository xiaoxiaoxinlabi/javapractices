package en.maths;

import java.util.Arrays;

public class MaximumProduct_628 {

//    给定一个整数数组，找到三个乘积最大的数字并输出最大乘积。

//    Example 1:
//    Input: [1,2,3]
//    Output: 6
//
//    Example 2:
//    Input: [1,2,3,4]
//    Output: 24

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int w = nums[n-1]*nums[n-2]*nums[n-3], x = nums[n-1] * nums[n-2] * nums[0];
        int y = nums[0]*nums[1]*nums[2], z = nums[0]*nums[1]*nums[n-1];
        int max = (int) Math.max(Math.max(w,x),Math.max(y,z));
        return max;


    }

    public int maximumProduct1(int [] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1]*nums[n-2]*nums[n-3];
        max = Math.max(max, nums[n-1]*nums[0]*nums[1]);
        return max;
    }

    public int maximumProduct2(int [] nums) {
        int[] max = new int[3];
        int[] min = new int[2];
        max[0] = max[1] = max[2] = Integer.MIN_VALUE;
        min[0] = min[1] = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int k = nums[i];
            if (k > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = k;
            } else if (k > max[1]) {
                max[2] = max[1];
                max[1] = k;
            } else if (k > max[2]) {
                max[2] = k;
            }
            if (k < min[0]) {
                min[1] = min[0];
                min[0] = k;
            } else if (k < min[1]) {
                min[1] = k;

            }
        }

        int m1 = max[0]*max[1]*max[2];
        int m2 = min[0]*min[1]*max[0];
        return Math.max(m1, m2);

    }
}
