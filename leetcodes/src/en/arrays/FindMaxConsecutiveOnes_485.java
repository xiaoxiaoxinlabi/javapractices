package en;

public class FindMaxConsecutiveOnes_485 {

//  给定一个二进制数组，请找到此数组中连续1的最大数目
//  Example 1:
//  Input: [1,1,0,1,1,1]
//  Output: 3
//  Explanation: The first two digits or the last three digits are consecutive 1s.
//  The maximum number of consecutive 1s is 3.

  public int findMaxConsecutiveOnes1(int [] nums){

    int f = 0, max = 0;
    for(int i = 0; i < nums.length; i ++){
      if(nums[i] == 1){
        f++;
        max = Math.max(f, max);
      }else{
        f = 0;
      }
    }

    return max;

  }

  public int findMaxConsecutiveOnes2(int [] nums){
    int count = 0, max = 0;
    for(int num: nums){
      if(num == 1){
        count++;
        if(count > max){
          max = count;
        }
      }else{
        count=0;
      }
    }
    return max;

  }




}
