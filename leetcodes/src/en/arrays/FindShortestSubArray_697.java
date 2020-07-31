package en;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray_697 {

//  给定一个非负整数nums的非空数组，此数组的度数定义为其元素中任何一个元素的最大频率。
//  您的任务是找到（连续的）nums子数组的最小长度，该子数组与nums具有相同的度数。

  public int findShortestSubArray1(int [] nums){

//    定义左，右边界，以及元素出现的次数

    Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();


    for(int i = 0; i < nums.length; i ++){
      int x = nums[i];
      //    分别将元素放入,left,中，如果没有存放的情况下
      if(left.get(x) == null){
        left.put(x, i);
      }
      right.put(x, i);
//      计算每个元素出现的次数
      count.put(x, count.getOrDefault(x, 0)+1);
    }

    int ans = nums.length;
//    计算count中最大的值
    int degree = Collections.max(count.values());

    for(int x: count.keySet()){
//      遍历其key ，如果遇到出现次数最多的元素
      if(count.get(x) == degree){
//        则分别得到左，右，元素的差
        ans = Math.min(ans, right.get(x) - left.get(x)+1);
      }
    }

    return ans;

  }

}
