package en.hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsHappy_202 {
//
//    编写算法以确定数字n是否为“ happy”。
//    一个快乐的数字是由以下过程定义的数字：以任何正整数开头，用该数字的平方和代替该数字，然后重复该过程，直到该数字等于1（它将停留在该位置），否则将循环在不包含1的循环中无休止地循环。以1结尾的那些数字是快乐数字。

    public boolean isHappy(int n) {

      Set<Integer> set = new HashSet<>();
      while( n != 1){
          int sum = 0;
          int curr = n;
          while(curr != 0){
              sum += (curr % 10) * (curr % 10);
              curr = curr / 10;
          }
          if(!set.add(sum)){
              return false;
          }
          n = sum;
      }
      return true;

    }

    public boolean isHappy1(int n){
        int temp = n;
        Set<Integer> set = new HashSet<>();
        while( 1 > 0){
            int sum = 0;
            while(temp > 0){
                sum = sum + (int) Math.pow(temp % 10, 2);
                temp = temp / 10;
            }
            if(sum == 1){
                return true;
            }
            temp = sum;
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
        }
    }
}
