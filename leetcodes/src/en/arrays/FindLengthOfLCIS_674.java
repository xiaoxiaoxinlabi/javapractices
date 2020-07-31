package en;

public class FindLengthOfLCIS_674 {

//  给定一个未排序的整数数组，找到最长的连续递增子序列（子数组）的长度

  public int findLengthOfLCIS1(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }
    int count = 1;

    int max = 0;
    for (int i = 1; i < nums.length; i++) {

      if (nums[i - 1] == nums[i] && nums.length == 2 || nums.length == 1) {
        return 1;
      } else if (nums[i - 1] < nums[i]) {
        count++;

      } else {
        max = Math.max(count, max);
        count = 1;
      }
    }
    max = Math.max(count, max);
    return max;
  }


  public int findLengthOfLCIS2( int [] nums){
    int ans = 0, anchor = 0;

    for(int i = 0; i <nums.length; ++i){
//      遍历找到最长升序子数组的开始索引
      if(i > 0 && nums[i-1] >=nums[i]){
        anchor=i;
      }
//      计算当前i- 开始索引+1的长度
      ans = Math.max(ans, i-anchor+1);
    }
    return ans;
  }

  public int findLengthOfLCIS3(int [] nums){
    int answer = 0;
    int length = 0;

    for(int i = 0; i < nums.length; i ++){
//      如果i = 0; 或者 后一个元素大于前一个，ze length ++
      if(i == 0 || nums[i] > nums[i-1]){
        length++;
      }else{
//        否则 wei 1
        length=1;
      }
      answer = Math.max(answer, length);
    }

    return answer;
  }

  public int findLengthOfLCIS4(int [] nums){
    if(nums.length <=1){
      return nums.length;
    }

    int count =1, max = 0;

    for(int i = 0; i < nums.length; i ++){
//      如果i = 0; 或者 后一个元素大于前一个，ze length ++
      if( nums[i] > nums[i-1]){
        count++;
      }else{
//        否则 wei 1
        max = Math.max(count, max);
        count=1;
      }
    }

    return Math.max(count, max);
  }



}
