public class Test53a {


//  在排序数组中查找数字
//  统计一个数字在排序数组中出现的次数

//  输入: nums = [5,7,7,8,8,10], target = 8
//  输出: 2

//  本题要求统计数字 targettarget 的出现次数，可转化为：使用二分法分别找到 左边界 leftleft 和 右边界 rightright ，易得数字 targettarget 的数量为 right - left - 1right−left−1 。
//  始化： 左边界 i = 0 ，右边界 j = len(nums) - 1；代表闭区间 [i, j]

  public int search(int [] nums, int target){
    int i = 0, j = nums.length-1;
    while(i<=j){
      int m = (i+j)/2;
      if(nums[m] <=target){
        i = m+1;
      }else{
        j = m - 1;
      }
    }
    int right = i;

    i = 0; j = nums.length-1;
    while(i<=j){
      int m = (i+j)/2;
      if(nums[m] < target){
        i = m+1;
      }else{
        j=m-1;
      }
    }
    int left = j;

    return right-left-1;
  }

}
