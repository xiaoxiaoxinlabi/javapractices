package en;

public class PivotIndex_724 {

//  给定一个数组，找出数组中的索引，是的索引左边的元素之和等于索引右边元素之和
//  Input: nums = [1,7,3,6,5,6]
//  Output: 3
//

  public int pivotIndex1(int [] nums){

//    定义两个变量，总和，左边的和
    int sum = 0, leftsum = 0;

//    首先遍历计算所有的和
    for(int x : nums ){
      sum+=x;
    }


//    假设我们知道S是数字的总和，并且我们位于索引i。如果我们知道索引i左侧的leftsum的总数，那么索引右侧的另一个总和就是S-nums [i]-leftsum
    for(int i = 0; i < nums.length; i ++){
//      如果左边的和等于总和减去左边的和再减去当前索引所对应的值，则说明当前值为分界点
      if(leftsum == sum - leftsum - nums[i]){
        return i;
      }
//      计算左边的和
      leftsum+=nums[i];
    }

    return -1;

  }

  public int pivotIndex2(int [] nums){
    if(nums.length == 0){
      return -1;
    }
    int n = nums.length;
    int totalSum = 0, leftSum = 0;
    for(int x: nums){
      totalSum+=x;
    }


    for(int i = 0; i <n; i ++){
      if(leftSum == (totalSum - nums[i])){
        return i;
      }else{

        leftSum+=nums[i];
        totalSum -=nums[i];
      }
    }

    return -1;
  }
}
