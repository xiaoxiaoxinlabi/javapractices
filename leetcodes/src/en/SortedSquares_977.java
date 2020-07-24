package en;

import java.util.Arrays;

public class SortedSquares_977 {

//  给定整数A数组（以非降序排列），返回每个数字的平方的数组（也以非降序排列 即升序）。

  public static int [] sortedSquares1(int [] A){

    for(int i = 0; i < A.length; i ++){

        A[i] = A[i] * A[i];

      }

    Arrays.sort(A);
    return A;

  }

//  针对于升序排列的数组

  public static int [] sortedSquares2(int [] A){
    int N = A.length;
    int j = 0;

//    遍历数组找到大于等于0 的元素
    while(j < N && A[j] < 0){
      j++;
    }
//    定义指针指向前一个元素
    int i = j - 1;
    int[] ans = new int[N];
    int t = 0;
    while(i >= 0 && j < N){
//      如果前一个元素的平方 小于当前元素的平方
      if(A[i] * A[i] < A[j] * A[j]){
//        则将前一个元素的平方值赋给新的数组，然后i 的值指向左端的元素
        ans[t++] = A[i] * A[i];
        i--;
      }else{
        ans[t++] = A[j] * A[j];
//        j继续向右前进
        j++;
      }
    }

    while(i >= 0){
      ans[t++] = A[i] * A[i];
      i--;
    }
    while(j <N){
      ans[t++] = A[j] * A[j];
      j++;
    }
    return ans;
  }

  public static void main(String [] args){
    int [] arr = {-4,-1,0,3,10};

    System.out.println(Arrays.toString(sortedSquares2(arr)));
  }

}
