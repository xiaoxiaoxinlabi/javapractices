public class FindLengthOfLCISTest674 {

  //    给定一个未经排序的整数数组，找到最长且连续的的递增序列。

//    输入: [1,3,5,4,7]
////    输出: 3
////    解释: 最长连续递增序列是 [1,3,5], 长度为3。
////    尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。


//  解决方法：滑动窗口
  public int findLengthOfLCIS(int [] nums){

    int ans = 0, start = 0;
    for(int i = 0; i < nums.length;++i){
//      并且每当 nums[i-1]>=nums[i] 时，每个此类子序列的边界都会出现。当它这样做时，它标志着在 nums[i] 处开始一个新的递增子序列，我们将这样的 i 存储在变量 anchor 中。

      if(i > 0 && nums[i-1] >= nums[i]){
        start = i;
      }
      ans = Math.max(ans, i- start+1);
    }
    return ans;

  }


  public int findLengthOfLCIS1(int [] nums){
    if(nums.length <= 1){
      return nums.length;
    }
    int ans = 1;
    int count = 1;
    for(int i = 0; i < nums.length-1; i ++){
      if(nums[i+1] > nums[i]){
        count++;
      }else{
        count=1;
      }
      ans = Math.max(ans, count);
    }
    return ans;
  }

}
