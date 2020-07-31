package en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference_1200 {
//  给定一个由不同整数arr组成的数组，找到所有元素，其中任意两个元素的绝对差值都最小，输出

  public static List<List<Integer>> minimumAbsDifference(int [] arr){

//    定义一个list存放最终结果
    List<List<Integer>> ans = new ArrayList<>();
//    将数组排序
    Arrays.sort(arr);

//    定义一个最小值
    int min = Integer.MAX_VALUE;

//    依次循环数组，如果两者之差小于最小值，则将最小值赋值给最小值
    for(int i = 0; i < arr.length-1; i ++){
      if(arr[i+1] - arr[i] < min){
        min = arr[i+1] - arr[i];
      }
    }

//    再次循环遍历数组，如果当前值加上最小值等于下一个值，则将其添加到结果中
    for(int i = 0; i < arr.length - 1; i ++){
      if(arr[i]+min == arr[i+1]){
        ans.add(Arrays.asList(arr[i], arr[i+1]));
      }
    }

    return ans;


  }

//  两步：
//  step1： 找到最小的差值
//  step2：将两者差为最小值的元素组合到集合中，并输出

  public static List<List<Integer>> minimumAbsDifference2(int [] arr){

//    将数组排序
    Arrays.sort(arr);
//    定义一个最小值，其默认值是Integer 的最大值
    int min_diff = Integer.MAX_VALUE;
    int diff = 0;
//    依次循环遍历数组
    for(int i = 0; i < arr.length; i ++){
//      比较两者之间的差的绝对值
      diff = Math.abs(arr[i+1] - arr[i]);
//      将两者差的绝对值与diff相比较，找到最小的值
      min_diff = Math.min(min_diff, diff);
    }

    List<List<Integer>> res = new ArrayList<>();
//    再次遍历数组，如果前后两个元素的差的绝对值等于最小值，则将其添加到集合中
    for(int i = 0; i < arr.length - 1; i ++){
      if(Math.abs(arr[i+1] - arr[i]) == min_diff){
        res.add(Arrays.asList(arr[i], arr[i+1]));
      }
    }

    return res;
  }

  public  static void main(String [] args){

    int arr[] = {4,2,1,3};

    System.out.println(minimumAbsDifference(arr));

  }

}
