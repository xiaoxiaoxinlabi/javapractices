package en;

import java.util.Arrays;

public class SumZero_1304 {

//  给定整数n，返回任何包含n个唯一整数的数组，以使它们加起来为0

  public static int [] sumZero1(int n){

//    采用二分查找法

    int [] arr = new int [n];

    int mid = n /2;
    int low = 0;
    int high = n - 1;
    while(high > low){
      arr[low++] = -mid;
      arr[high--] = mid;
      mid --;
    }
    System.out.println(Arrays.toString(arr));
    return arr;
  }

  public static int [] sumZero2(int n){
    int res [] = new int[n];
    int index = 0;
    for(int i = - n / 2; i <=n / 2; i ++){
//      如果n 是偶数，则结果中不可能包含0
      if(n % 2 == 0 && i == 0){
        continue;
      }else{
        res[index++] = i;
      }
    }
    return res;
  }

  public static void main(String [] args){

    System.out.println(sumZero1(5));

  }

}
