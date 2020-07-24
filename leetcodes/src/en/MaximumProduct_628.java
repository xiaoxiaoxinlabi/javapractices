package en;

import java.util.Arrays;

public class MaximumProduct_628 {

//  给定一个整数数组，找到三个乘积最大的数字并输出最大乘积。
//  Example 1:
//
//  Input: [1,2,3]
//  Output: 6

//  Example 2:
//
//  Input: [1,2,3,4]
//  Output: 24

  public int maximumProduct1(int [] nums){

    Arrays.sort(nums);

    return Math.max(nums[0] * nums[1]* nums[nums.length-1], nums[nums.length-1]* nums[nums.length-2] * nums[nums.length -3]);


  }

  public int maximumProduct2(int [] nums){
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i ++){

      if(nums[i] <= min1){
        min2 = min1;
        min1 = nums[i];
      }else if(nums[i] < min2){
        min2 = nums[i];
      }
      if(nums[i] > max1){
        max3 = max2;
        max2 = max1;
        max1 = nums[i];
      }else if(nums[i] >=max2){
        max3 = max2;
        max2 = nums[i];
      }else if(nums[i] > max3){
        max3 = nums[i];
      }
    }

    return Math.max(min1 * min2 * max1, max1 * max2 * max3);


  }

}
