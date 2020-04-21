public class Test42 {

//  连续子数组的最大和
//  输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

//  要求时间复杂度为O(n)

  public int getLargestSum1(int [] nums){

    int sum = nums[0];

    for(int i = 0; i < nums.length; i ++){
      nums[i]+=Math.max(nums[i-1], 0);
      sum = Math.max(sum, nums[i]);
    }
    return sum;
  }

  public int getLargestSum2(int [] nums){
    int max = 0, sum = nums[0];
    for(int i = 0; i < nums.length; i ++){
      max = Math.max(nums[i], max+nums[i]);
      sum = Math.max(max, sum);
    }
    return sum;
  }

}
