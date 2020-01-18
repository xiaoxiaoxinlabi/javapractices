package tests;

public class RotateTest {
//  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//  输入: [-1,-100,3,99] 和 k = 2
//  输出: [3,99,-1,-100]
//  解释:
//  向右旋转 1 步: [99,-1,-100,3]
//  向右旋转 2 步: [3,99,-1,-100]
  public void rotate1(int [] nums, int k){
//    printResults(nums);
    int n = nums.length;
    int [] ret = new int [n];
    for (int i = 0; i < n; i ++){
//      当前的索引加上移动的位置的值 然后对总长度求余
      ret[(i+k)%n] = nums[i];
    }
    nums  = ret;

//    printResults(nums);


  }


  public void printResults(int [] nums){
    for (int i = 0; i < nums.length; i ++){
      if (i != nums.length - 1){
        System.out.print(nums[i] + ",");

      }else{
        System.out.println(nums[i]);
      }
    }
  }


  public static void main(String [] args){
    RotateTest rotateTest = new RotateTest();
    int [] arr1 = {1,2,3,4,5,6,7};
    int k = 3;

    rotateTest.rotate1(arr1,k);
  }

}
