package en;

import java.util.HashSet;
import java.util.Set;

public class FindMaxAverage_643 {

//  给定一个包含n个整数的数组，请找到具有最大平均值的给定长度k的连续子数组。并且您需要输出最大平均值
//  Example 1:
//
//  Input: [1,12,-5,-6,50,3], k = 4
//  Output: 12.75
//  Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75


  public double findMaxAverage1(int [] nums, int k){

    int [] sum = new int[nums.length];
    sum[0] = nums[0];
//    首先计算数组的和，sum数组中，每个索引对应前i个值的和
    for(int i = 1; i < nums.length; i ++){
      sum[i] = sum[i-1]+nums[i];
    }

//    计算k-1个数组的平均值
    double res = sum[k-1] * 1.0 / k;

//    从k开始遍历数组
    for(int i = k; i < nums.length; i ++){
//      比较每个k长度的数组的和大小
      res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 /k);
    }

    return res;

  }

  public double findMaxAverage2(int [] nums, int k){
    double sum = 0;

//    先求出k个子长度数组的和
    for(int i = 0; i < k; i++){
      sum+=nums[i];
    }
    double res = sum;


    for(int i = k; i < nums.length; i ++){
      sum=nums[i] - nums[i-k]+sum;
      res = Math.max(res, sum);
    }

    return res/k;
  }

}
