package en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmallerNumbersThanCurrent_1365 {

//  给定一个数组，遍历数组并判断找出数组中的每个值比自己更小的值的数量，按照数组格式输出

//  Example 1:
//
//  Input: nums = [8,1,2,2,3]
//  Output: [4,0,1,1,3]
//  Explanation:
//  For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
//  For nums[1]=1 does not exist any smaller number than it.
//  For nums[2]=2 there exist one smaller number than it (1).
//  For nums[3]=2 there exist one smaller number than it (1).
//  For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

  public static int [] smallerNumbersThanCurrent1(int [] nums){

//    将数组的值，当做计数数组的索引，然后计算每个值出现的次数，并且按照索引顺序排序
    int [] count = new int [102];
    for(int num:nums){
      count[num+1] ++;
    }

//    遍历计数组，并计算当前值前面出现元素的数量
    for(int i = 1; i < count.length; i ++){
      count[i] = count[i] + count[i-1];
    }

//    再次遍历原数组，原数组中每个元素比它小的元素，就是对应的count中的值
    for(int i = 0; i < nums.length; i ++){
      nums[i] = count[nums[i]];
    }

    return nums;

  }

  public static int [] smallerNumbersThanCurrent2(int [] nums){
    Map<Integer, Integer> map = new TreeMap<>();

    int unsort [] = nums.clone();

//    用map计算每个值出现的次数
    for(int num: nums){
      map.put(num, map.getOrDefault(num, 0)+1);
    }

//    对数组排序
    Arrays.sort(nums);
    int i = 0;
    while(i < nums.length){
      int temp = map.get(nums[i]);
      for(int j = 0; j < nums.length; j ++){
        int num = nums[j+1];
        map.put(num,i);
      }
      i+=temp;
    }

    nums= unsort;

    for(int w = 0; w < nums.length; w++){
      int num = nums[w];
      nums[w] = map.get(num);
    }

    return nums;

  }

}
