package en;

public class sortArrayByParityII_922 {
//
//  当且仅当您可以选择X> = 2并可以将整个卡片组分成1组或多组卡片时，才返回true，其中：
//  每组都有X张卡片。
//  每组中的所有卡均具有相同的整数。

  public int []  sortArrayByParityII(int [] A){

    int n = A.length;
    int [] ans = new int[n];
    int t = 0;
//    重新定义一个数组用于存放新排列的值
    for(int x: A){
//      如果当前值为偶数，则将当前值存放在ans中，ans 的索引以step 2 增加
      if(x % 2 == 0){
        ans[t] = x;
        t+=2;
      }
    }

    t = 1;
    for(int x : A){
      if(x % 2 == 1){
        ans[t] = x;
        t+=2;
      }

    }

    return ans;

  }

  public int [] sortArrayByParityI2(int [] A){
    int j = 1;
//    以步长为2 遍历数组
    for(int i = 0; i < A.length; i +=2){
//      如果当前值为奇数
      if(A[i] % 2 ==1){
//        j 为奇数切片，找到偶数元素
        while (A[j] % 2 == 1){
          j+=2;

        }
//        两者交换
        int tmp = A[j];
        A[i] = A[j];
        A[j] = tmp;
      }
    }
    return A;
  }


}
