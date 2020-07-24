package en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

//  Given an array of integers, find if the array contains any duplicates.（判断数组是否包含重复的元素）

//  Example 1:
//
//  Input: [1,2,3,1]
//  Output: true
//  Example 2:
//
//  Input: [1,2,3,4]
//  Output: false

  public boolean containsDuplicate1(int [] nums){

   for(int i = 0; i < nums.length; ++i){
     for(int j = 0; j < i; ++j){
       if(nums[j] == nums[i]){
         return true;
       }
     }
   }

   return false;


  }


  public boolean containsDuplicate2(int [] nums){

    Set<Integer> set = new HashSet<>();
    for(int i : nums){
      set.add(i);
    }

    return nums.length == set.size() ? false: true;


  }

  public boolean containsDuplicate3(int [] nums){
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i ++){
      if(nums[i] == nums[i+1]){
        return true;
      }
    }
    return false;
  }

}
