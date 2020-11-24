package en.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate_219 {
//    给定一个整数数组和一个整数k，找出数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且i和j之间的绝对差最大为k。

    public boolean containsNearbyDuplicate(int[] nums, int k) {

//        map中存储：当前值，当前索引
       Map<Integer, Integer> map = new HashMap();
//       循环判断数组，如果map包含当前值，并且当前值对应的索引减去 现在的索引 两者相差小于等于 k 则返回true
       for(int j = 0; j < nums.length; j ++){
           if(map.containsKey(nums[j]) && Math.abs(map.get(nums[j]) - j) <= k){
               return true;
           }else{
               map.put(nums[j],j);
           }
       }
//       否则返回false
       return false;
    }

    public boolean containsNearbyDuplicate1(int [] nums, int k){
        Map<Integer, Integer> idxs = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(idxs.containsKey(nums[i]) && i - idxs.get(nums[i]) <= k){
                return true;
            }
            idxs.put(nums[i],i);
        }
        return false;
    }


}
