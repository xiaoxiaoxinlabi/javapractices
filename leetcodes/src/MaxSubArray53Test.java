public class MaxSubArray53Test {

  //    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    输入: [-2,1,-3,4,-1,2,1,-5,4],
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

  public static int maxSubArray(int [] nums){

    int sum = nums[0];
    int max = 0;

    for(int i = 0; i < nums.length; i ++){

      max = Math.max(nums[i], max + nums[i]);
      sum = Math.max(sum, max);

    }
    return sum;

  }


  public static int maxsubarry1(int [] nums){
    int ans = nums[0];
    int sum = 0;
    for(int i = 0; i < nums.length; i ++){
      if(sum > 0){
        sum+=nums[i];
      }else{
        sum = nums[i];
      }
      ans = Math.max(ans, sum);
    }
    return ans;
  }

}
