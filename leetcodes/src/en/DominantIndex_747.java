package en;

public class DominantIndex_747 {

//  在给定的整数数组nums中，总是恰好有一个最大的元素。
//  查找数组中最大的元素是否至少是数组中其他每个数字的两倍。
//  如果是，则返回最大元素的索引，否则返回-1。

//  Input: nums = [1, 2, 3, 4]
//  Output: -1
//
//  Input: nums = [3, 6, 1, 0]
//  Output: 1


  public static int dominantIndex1(int [] nums){

    int firstmaxIndex = 0;

//    遍历找到最大元素的索引
    for(int i = 0; i < nums.length; i ++){

      if(nums[i] > nums[firstmaxIndex]){

        firstmaxIndex = i;

      }

    }

    for(int i = 0; i < nums.length; i ++){
//      再次遍历，如果最大元素的索引不等于当前索引 i, 并且 最大值 小于其他元素的2倍，则返回-1
      if(firstmaxIndex !=i && nums[firstmaxIndex] < 2 * nums[i]){
        return -1;
      }
    }

//否则返回其元素的索引
    return firstmaxIndex;

  }


  public static int dominantIndex2(int [] nums){


    if(nums.length == 1){
      return 0;
    }


     int  firstmaxIndex = nums[0] > nums[1] ? 0: 1;
     int  secondmaxIndex = nums[0] < nums[1]? 0: 1;


    for(int i = 2; i < nums.length; i ++){

      if(nums[i] > nums[firstmaxIndex]){
//        先将之前的firstmaxindex 赋值给second ,然后将新值赋值first
        secondmaxIndex = firstmaxIndex;
        firstmaxIndex = i;

      }else if(nums[i] < nums[firstmaxIndex] && nums[i] > nums[secondmaxIndex]){
        secondmaxIndex = i;
      }

    }

    if(nums[firstmaxIndex] >= nums[secondmaxIndex] * 2){
      return firstmaxIndex;
    }

    return -1;

  }

  public static void main(String[] args){

    int [] arr = {0,0,0,1};

    System.out.println(dominantIndex2(arr));
  }

}
