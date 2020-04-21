import java.util.HashMap;
import java.util.Map;

public class Test57a {


//  和为s的两个数字

//  输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可

  public int [] gettwoNumber1(int [] nums, int target){

    Map<Integer, Integer> map = new HashMap<>();
    int [] res = new int [2];
    for(int i = 0; i < nums.length; i ++){

      if(map.containsKey(target-nums[i])){
        res[0] = i;
        res[1] = map.get(target-nums[i]);

      }else{
        map.put(nums[i],i);
      }
    }

    return res;

  }

  public int[] twoSum(int[] nums, int target){
    int i = 0, j = nums.length-1;
    while(i<j){
      int s = nums[i] + nums[j];
      if(s<target){
        i++;
      }else if(s > target){
        j--;
      }else{
        return new int[]{nums[i], nums[j]};
      }
    }
    return new int[0];
  }
}
