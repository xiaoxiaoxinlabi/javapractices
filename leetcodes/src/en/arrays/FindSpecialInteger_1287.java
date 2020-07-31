package en;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindSpecialInteger_1287 {
//  给定一个以非降序排序的整数数组，该数组中恰好有一个整数出现超过25％的时间。
//  返回该整数。

  public static int findSpecialInteger1(int [] arr){

    Map<Integer, Integer> map = new TreeMap<>();

    for(int i = 0; i < arr.length; i ++){
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }


    for(int i = 0; i < arr.length; i ++){
      if(map.get(arr[i]) >  arr.length / 4){
        return arr[i];
      }
    }
    return 0;
  }

  public static void main(String [] args){
    int [] arr = {1,2,2,6,6,6,6,7,10};
    findSpecialInteger1(arr);
  }

  public int findSpecialInteger2(int [] arr){

//    如果数组长度为1，则返回数组第一个元素
    if(arr.length == 1){
      return arr[0];
    }

    int size = arr.length;
    int oneforth = size/4;
    for(int i = 1; i < size - oneforth; i ++){
      if((i+oneforth < size) && arr[i+oneforth] == arr[i]){
        return arr[i];
      }
    }
    return -1;
  }

//  滑动窗口法
  public int findSpecialInteger3(int [] arr){
    int n = arr.length, l = 0, r = n / 4;
    while(r < n){
      if(arr[r++] == arr[l++]){
        return arr[--l];
      }
    }
    return -1;
  }

}
