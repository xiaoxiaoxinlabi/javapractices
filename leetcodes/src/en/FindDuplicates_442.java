package en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates_442 {
//  给定一个整数数组，即1≤a [i]≤n（n =数组大小），某些元素出现两次，而另一些元素出现一次。
////  查找在此数组中出现两次的所有元素。 要按照顺序输出

  public List<Integer> findDuplicates1(int [] nums){
    Arrays.sort(nums);
    Map<Integer, Integer> map = new HashMap();
    List<Integer> list = new ArrayList();

    for(int i = 0; i < nums.length; i++){
      if(map.containsKey(nums[i])){
        map.put(nums[i], map.get(nums[i]) + 1);
      }else{
        map.put(nums[i], 1);
      }
    }

    for(int i = 0; i < nums.length; i ++){
      if(map.get(nums[i]) == 2 && !list.contains(nums[i])){
        list.add(nums[i]);

      }
    }
    return list;

  }

  public List<Integer> findDuplicates2(int [] nums){

    List<Integer> list = new ArrayList<>();
    int n = nums.length;
    for(int i = 0; i < n; i ++){
      int index = Math.abs(nums[i])-1;
      if(nums[index]<0){
        list.add(Math.abs(nums[i]));
      }else{
        nums[index]=-1*nums[index];
      }
    }
    return list;

  }

  public List<Integer> findDuplicates3(int [] nums){
    List<Integer> list = new ArrayList();
    Arrays.sort(nums);
    for(int i = 0, j = 1; j < nums.length && j < nums.length; i ++){
      if(nums[i] == nums[j++]){
        list.add(nums[i]);
      }
    }
    return list;
  }

}
