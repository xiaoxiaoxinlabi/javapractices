package en;

public class Rotate_189 {

//  Given an array, rotate the array to the right by k steps, where k is non-negative.
//  Example 1:
//
//  Input: nums = [1,2,3,4,5,6,7], k = 3
//  Output: [5,6,7,1,2,3,4]
//  Explanation:
//  rotate 1 steps to the right: [7,1,2,3,4,5,6]
//  rotate 2 steps to the right: [6,7,1,2,3,4,5]
//  rotate 3 steps to the right: [5,6,7,1,2,3,4]


//  Example 2:
//
//  Input: nums = [-1,-100,3,99], k = 2
//  Output: [3,99,-1,-100]
//  Explanation:
//  rotate 1 steps to the right: [99,-1,-100,3]
//  rotate 2 steps to the right: [3,99,-1,-100]

//  暴力法

  public void rotate1(int [] nums, int k){

    int temp, previous;
//    从数组末尾开始，倒序将k个元素依次保存到pervious中
    for(int i = 0; i < k; i ++){
      previous = nums[nums.length - 1];
//      然后将保存的元素与数组开头的元素依次交换，直到k为止
      for(int j = 0; j < nums.length; j++){
        temp = nums[j];
        nums[j] = previous;
        previous = temp;
      }
    }

  }

//  Using Extra Array（使用额外的数组保存）除余法

  public void rotate2(int [] nums, int k){
    int [] a = new int [nums.length];
    for(int i = 0; i <nums.length; i++){
      a[(i+k)%nums.length] = nums[i];

    }
    for(int i = 0; i < a.length; i ++){
      nums[i]=a[i];
    }
  }


//  使用循环替换

  public void rotate3(int [] nums, int k){

    k = k % nums.length;
    int count = 0;
    for(int start = 0; count < nums.length; start++){

      int current = start;
      int pre = nums[start];
      do{
        int next = (current+k)%nums.length;
        int temp = nums[next];
        nums[temp] = pre;
        pre = temp;
        current = next;
        count++;
      }while(start != current);
    }
  }

//  使用旋转(分治)

  public void rotate4(int [] nums, int k){
    k = k % nums.length;
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k-1);
    reverse(nums, k , nums.length - 1);
  }


  private void reverse(int [] nums, int start, int end){

    while(start < end){
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }


}
