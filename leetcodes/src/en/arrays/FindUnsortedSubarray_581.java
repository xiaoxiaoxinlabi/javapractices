package en;

import java.util.Arrays;

public class FindUnsortedSubarray_581 {

//  给定一个整数数组，您需要找到一个连续的子数组，如果仅以升序对该子数组进行排序，那么整个数组也将以升序进行排序。
//  您需要找到最短的此类子数组并输出其长度

//  Input: [2, 6, 4, 8, 10, 9, 15]
//  Output: 5
//  Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

  public int findUnsortedSubarray1(int [] nums){

    int [] snums = nums.clone();
//    将复制的数组进行升序排列
    Arrays.sort(snums);
    int start = snums.length, end = 0;
//    遍历复制的数组
    for(int i = 0; i < snums.length; i ++){
//      依次和原始数组进行对比，如果当前值不等于原始值
      if(snums[i]!=nums[i]){
//        则start 为最小的i, end 为最大的
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }

    return (end -start >=0 ? end - start+1: 0);

  }

  public int findUnsortedSubarray2(int [] nums){
    int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
    boolean flag = false;
//    找到最小的元素
    for(int i = 1; i < nums.length; i++){
      if(nums[i] < nums[i-1]){
        flag = true;
      }
      if(flag){
        min = Math.min(min, nums[i]);
      }
    }
//    找到最大的元素
    flag = false;
    for(int i = nums.length-2; i >=0; i--){
      if(nums[i] > nums[i+1]){
        flag = true;
      }
      if(flag){
        max = Math.max(max, nums[i]);
      }
    }

//    如果最小元素小于所有的元素则停止
    int l ,r;
    for(l = 0; l < nums.length; l ++){
      if(min < nums[l]){
        break;
      }
    }

//    如果最大元素大于整个元素，则停止
    for(r = nums.length-1; r >=0; r--){
      if(max > nums[r]){
        break;
      }
    }

//    计算 最大元素的索引与最小元素的索引之差是否大于0
    return r - l < 0? 0: r-l+1;
  }

//  双层循环遍历
  public int findUnsortedSubarray3(int [] nums){

//    定义最小值索引，最大值索引
    int l = nums.length, r = 0;
    for(int i = 0; i < nums.length-1; i ++){
      for(int j = i +1; j < nums.length; j ++){
        if(nums[j] < nums[i]){

          r = Math.max(r, j);
          l = Math.min(l,i);
        }
      }
    }

    return r - l > 0? r - l + 1 : 0;

  }

}
