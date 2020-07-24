package en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindDisappearedNumbers_448 {

//  给定一个整数数组，其中1≤a [i]≤n（n =数组大小），某些元素出现两次，而另一些元素出现一次。;
//  查找[1，n]包含的所有未出现在此数组中的元素
//  您能在没有额外空间的情况下在O（n）运行时执行此操作吗？您可能会假设返回的列表不算作多余的空间。

//  Example:
//
//  Input:
//      [4,3,2,7,8,2,3,1]
//
//  Output:
//      [5,6]

//list  方法之 ：set, add


  public List<Integer> findDisappearedNumbers1(int [] nums){

    List<Integer> list = new ArrayList();

//    populate the list with all the values 1 ≤ a[i] ≤ nums.length
//    用所有的 i <=nums[i] <=nums.length; 填充list

    for(int i = 0; i < nums.length; i++){
//      add 方法用于在末尾插入元素
      list.add(i);
    }

//    遍历数组并将列表中数组中存在的所有值设置为零
    for(int j = 0; j < nums.length; j ++){
//      set 方法用于已经初始化的list，并将原始index上的值替换掉
      list.set(nums[j]-1, 0);
    }

//    删除list中所有值为0的元素
    list.removeAll(Collections.singleton(0));
    return list;

  }


  public static  List<Integer> findDisappearedNumbers2(int [] nums){
    List<Integer> list = new ArrayList();

    for(int i = 0; i < nums.length; i ++){
//      计算当前元素的下标
      int index = Math.abs(nums[i])-1;
//      如果下标锁对应的元素值大于0 ，则 乘以-1，丢失的元素（没有出现过的元素）即其值为 大于0
      if(nums[index] > 0){
        nums[index] = nums[index] * -1;
      }
    }

//    经过一次重排之后数组的顺序为：{-4，-3，-2，-7,8,2，-3，-1}

    for(int i = 0; i < nums.length; i ++){
//      重新遍历数组，如果当前值大于0，则丢失的元素为当前的索引+1
      if(nums[i] > 0){
        int elementmissing = i+1;
        list.add(elementmissing);
      }
    }

    return list;
  }

  public static void main(String [] args){

    int [] nums = {4,3,2,7,8,2,3,1};

    System.out.println(findDisappearedNumbers2(nums).toString());

  }



}
