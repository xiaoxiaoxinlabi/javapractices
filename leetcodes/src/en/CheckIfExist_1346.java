package en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfExist_1346 {

//  给定一个数组，判断数组中是否存在 n, m 是的 n = 2 * m

    public boolean checkIfExist1(int [] arr){

      for(int i = 0; i < arr.length; i ++){
        for(int j = 0; j < arr.length; j ++){
          if(arr[j] * 2 == arr[i] && i !=j){
            return true;
          }
        }
      }
      return false;
    }

    public boolean checkIfExist2(int [] arr){
      int flag = 0;

//      循环遍历数组
      for(int i = 0; i < arr.length; i ++){
//        如果数组中存在零，则继续下一个元素
        if(arr[i] == 0){
          continue;
        }
//        再次循环遍历数组，
        for(int j = 0; j < arr.length; j ++){
          if(arr[j] *2 == arr[i] || arr[i] * 2 == arr[j]){
            return true;
          }
        }
        flag = 1;
      }
      if(flag == 0){
        return true;
      }
      return false;
    }


}
