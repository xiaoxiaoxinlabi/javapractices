package en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsNearbyDuplicate_219 {


//  给定一个整数数组和一个整数k，找出数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，且i和j之间的绝对差最大为k

  public boolean containsNearbyDuplicate1(int [] nums, int k){

    Map<Integer, Integer> map = new HashMap();
    for(int   i = 0; i < nums.length; i ++){
      if(map.containsKey(nums[i])){
        if(Math.abs(i - map.get(nums[i])) <= k){
          return true;
        }
      }

      map.put(nums[i],i);
    }
    return false;
  }


  public boolean containsNearbyDuplicate2(int [] nums, int k){
    for(int i = 0; i < nums.length-1; i ++){
      for(int j = i +1; j <=i+k && j < nums.length; j ++){
        if(nums[i] ==nums[j]){
          return true;
        }
      }
    }
    return false;
  }
}
