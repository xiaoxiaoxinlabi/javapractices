package en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber_268 {

//  给定一个数组，该数组包含从0、1、2，...，n中获取的n个不同的数字，请找到该数组中缺少的一个。

  public static int missingNumber1(int [] nums){
//    首先排序
    Arrays.sort(nums);
//    如果数组的长度不等于数组最后一个值；用来判断 [0,1] ,[0,1,2]这种
    if(nums[nums.length-1]!=nums.length){
//      则返回数组的长度
      return nums.length;
//      如果只有一个值，并且不等于0 ，则返回0
    }else if(nums[0]!=0){
      return 0;
    }

//    遍历数组,如果后一个值加1不等于前一个值,则找到了缺失的元素
    for(int i = 1; i < nums.length; i ++){
      int expetedNum = nums[i-1]+1;
      if(nums[i] != expetedNum){
        return expetedNum;
      }
    }

    return -1;

  }

  public static int missingNumber2(int [] nums){
    Set<Integer> set = new HashSet<>();
//    先将数组所有的值放入set结合中
    for(int num: nums){
      set.add(num);
    }

//    整个数组，算上缺失的值总共有 totalnum 个 所有的值是连续的
    int totalNum = nums.length + 1;
//    依次循环遍历，查找如果在set不存在，则说明是要找到的值
    for(int i = 0; i < totalNum; i ++){
      if(!set.contains(i)){
        return i;
      }
    }
    return -1;
  }

//  用异或运算符
//  运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。

  public static int missingNumber3(int [] nums){
    int missing = nums.length;
    for(int i = 0; i < nums.length; i++){
//      通过对索引以及 missing 进行异或
      missing^=i^missing;
    }
    return missing;
  }

//  采用公式：计算n 个数的和 sum = n * (n+1)/2
  public static int missingNumber4(int [] nums){
    int sum = 0;
//    对所有的元素求和
    for(int i = 0; i < nums.length; i++){
      sum+=nums[i];
    }
//    计算n 个数的和 sum = n * (n+1)/2 在减去，当前数组的和，就是缺失的元素
    return nums.length*(nums.length+1)/2 - sum;
  }






  public static void main(String [] args){
    int [] arr = {1};
    System.out.println(missingNumber1(arr));
  }

}
