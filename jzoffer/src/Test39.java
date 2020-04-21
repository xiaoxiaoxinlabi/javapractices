import java.util.Arrays;

public class Test39 {


//  数组中出现次数超过一半的数字
//  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

//  输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//  输出: 2

//  初始化： 票数统计 votes = 0， 众数 x；
//  循环抵消： 遍历数组 nums 中的每个数字 num
//票数 votes等于 0 ，则假设 当前数字 num 为 众数 x
//  num = x时，票数 votes 自增 1 ；否则，票数 votes 自减 11。

  public int majorityElement(int [] nums){
    int x = 0, votes =0;
    for(int num: nums){
      if(votes == 0){
        x = num;
      }
      votes+=num == x?1:-1;
    }
    return x;
  }

//  方法二，取中值

  public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
  }




}
