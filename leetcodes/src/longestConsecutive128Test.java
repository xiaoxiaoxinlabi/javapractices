import java.util.Arrays;

public class longestConsecutive128Test {
//  给定一个未排序的整数数组，找出最长连续序列的长度。
//要求算法的时间复杂度为 O(n)。

//  输入: [100, 4, 200, 1, 3, 2]
//  输出: 4
//  解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

  public int longestConsecutive(int [] nums){
    if(nums.length == 0){
      return 0;
    }
    Arrays.sort(nums);
    int longest = 1;
    int current = 1;

    for(int i = 1; i < nums.length; i ++){
      if(nums[i] != nums[i-1]){
        if(nums[i] == nums[i-1] + 1){
          current ++;
        }else{
          longest = Math.max(longest, current);
          current = 1;
        }
      }
    }
    return longest;
  }

}
