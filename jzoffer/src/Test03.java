import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test03 {

//  找出数组中重复的数字。
//  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
//  输入：
//      [2, 3, 1, 0, 2, 5, 3]
//  输出：2 或 3


//
//  时间复杂度：O(n)O(n)。
//  遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)O(1)，故总的时间复杂度是 O(n)O(n)。
//  空间复杂度：O(n)O(n)。不重复的每个元素都可能存入集合，因此占用 O(n)O(n) 额外空间。




  public int findRepatNumber01(int [] nums){
//    初始化集合为空集合，重复的数字 repeat = -1
    Set<Integer> set = new HashSet<Integer>();

    int repeat = -1;
//    遍历数组中的每个元素：
    for(int num: nums){
//      将该元素加入集合中，判断是否添加成功，如果添加失败，说明该元素已经在集合中，因此该元素是重复元素，将该元素的值赋给 repeat，并结束遍历
      if (!set.add(num)){

        repeat = num;
        break;

      }
    }
//    返回 repeat
    return repeat;

  }



//  找出数组中的所有重复值
  public void findRepatNumber02(int [] nums){

    Map<Integer, Integer> map = new HashMap();

    for (int i = 0; i < nums.length; i ++){
      if(map.containsKey(map.get(nums[i]))){
        map.put(nums[i], map.get(nums[i]) + 1);
      }else{

        map.put(nums[i], 1);
      }

    }

    for(Map.Entry <Integer,Integer>re: map.entrySet()){
      if(re.getValue() > 1){
        System.out.println(re.getKey());

      }
    }

  }

//  原地删除数组中的重复值

  public void   findRepatNumber03(int [] nums){

    int j = 0;
    for(int i = 1; i < nums.length; i ++){
      if(nums[i] != nums[j]){
        j++;
        nums[j] = nums[i];
      }
    }


  }


//  删除数组中的重复值，并返回数组

  public int []  findRepatNumber04(int [] nums){
    int j = 0;

    for(int i = 1; i < nums.length; i ++){
      if(nums[i] !=nums[j]){
        j++;
        nums[j] = nums[i];
      }
    }

    return nums;
  }


}
