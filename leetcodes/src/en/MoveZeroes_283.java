package en;

public class MoveZeroes_283 {

//  给定一个数组num，编写一个函数，将所有0移到它的末尾，同时保持非零元素的相对顺序

  public static void moveZeroes1(int [] nums){
    int j = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] != 0){
        nums[j] = nums[i];
        j++;
      }
    }
    for(int p =j; p < nums.length; p++){
      nums[p] = 0;
    }

  }

}
