import java.util.HashSet;
import java.util.Set;

public class Dd03 {

//  题目： 给定一个数组，找到数组中最长的升序子序列的


  public static int findLengthOfLCIS(int [] nums){
    if(nums.length == 0){
      return 0;
    }

    int max = 0;
    int count =1;
    for(int i = 0; i < nums.length-1; i++){
      if(nums[i] < nums[i+1]){
        count++;
      }else{
        max = Math.max(count, max);
        count=1;
      }
    }
    max = Math.max(count, max);
    return  max;
  }




  public static void main(String [] args){
    int [] arr = {5,3,4,6,7,8,9};
//    System.out.println(findLengthOfLCIS(arr));



  }

}
