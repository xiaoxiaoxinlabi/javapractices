package en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class FindPairs_532 {

//  给定一个整数数组和一个整数k，您需要找到数组中唯一的k-diff对的数量。在这里，k-diff对定义为整数对（i，j），其中i和j均为数组中的数字，并且它们的绝对差为k。

//  Input: [3, 1, 4, 1, 5], k = 2
//  Output: 2
//  Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).


  public static int findPairs1(int [] nums, int k){

    if(k < 0){
      return 0;
    }

    int count = 0;
    Map<Integer, Integer> map = new HashMap();
    int res = 0;
    for(int i = 0; i < nums.length; i ++){
      if(map.containsKey(nums[i])){
        if(k == 0 && map.get(nums[i]) == 1){
          map.put(nums[i], map.get(nums[i])+1);
          res++;
        }
        continue;
      }
      res+=map.getOrDefault(nums[i]+k, 0);
      res+=map.getOrDefault(nums[i]-k, 0);
      map.put(nums[i], 1);



    }
    System.out.println(res);
    return res;


  }


  public static int findPairs2(int [] nums, int k){

    if(k < 0){
      return 0;
    }
    int count = 0;
    Hashtable<Integer, Integer> ht = new Hashtable<>();
    for(int i = 0; i < nums.length; i ++){
//      意思就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
      ht.put(nums[i], ht.getOrDefault(nums[i], 0)+1);
    }

//    如果差为0 ，则找到相同的数字有多少个
    if(k == 0){
      for(int key: ht.keySet()){
        count = ht.get(key) >1 ? count+1: count;
      }
    }else{
//      否则，查找 当前 key + k 是否在 hashtable中存在
      for(int key: ht.keySet()){
        if(ht.containsKey(key+k)){
          count = count+1;
        }
      }
    }

    return count;


  }

  public static int findPairs4(int [] nums, int k){
    if(k < 0){
      return 0;
    }
    Set<Integer> comSet = new HashSet<>();
    Set<Integer> numSet = new HashSet<>();
    for(int i = 0; i < nums.length; i ++){
      if(numSet.contains(nums[i] - k)){
        comSet.add(nums[i] - k);
      }
      if(numSet.contains(nums[i] + k)){
        comSet.add(nums[i]);
      }
      numSet.add(nums[i]);
    }


      for(int re: numSet){
        System.out.println(re);
      }


    return comSet.size();
  }


  public static int findPairs3(int [] nums, int k){
    if(k < 0){
      return 0;
    }

    Set<Integer> numSet = new HashSet<>();
    Map<Integer, Set<String>> difMap = new HashMap<>();
    difMap.put(k, new HashSet<String>());

    for(int num: nums){
      int minus_res = num - k;
      int plus_res = num+k;
      if(numSet.contains(minus_res)){
        Set<String> set = difMap.get(k);
        String pair = "["+minus_res+","+num+"]";

        set.add(pair);
        difMap.put(k, set);
      }

      if(numSet.contains(plus_res)){
        Set<String> set = difMap.get(k);
        String pair = "["+num+","+plus_res+"]";
        set.add(pair);
        difMap.put(k, set);
      }
      numSet.add(num);
    }

    for(Map.Entry re:difMap.entrySet()){
      System.out.println(re.getValue());

    }

    return difMap.get(k).size();


  }




  public static void main(String [] args){
    int [] arr = {3,1,4,1,5};
    System.out.println(findPairs4(arr, 2));
  }
}
