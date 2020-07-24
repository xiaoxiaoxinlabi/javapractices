package en;

public class SortArrayByParity_905 {

//  给定一个非负整数数组A，返回一个数组，该数组包含A的所有偶数元素，后跟A的所有奇数元素。
//  您可以返回满足此条件的任何答案数组。

  public int [] sortArrayByParity1(int [] A){

  int [] ans = new int[A.length];
  int t = 0;

//  重新定义一个数组，用于存储结果
//    遍历旧数组，如果遇到偶数就存储
  for(int i = 0; i < A.length; i++){
    if(A[i]%2 == 0){
      ans[t++] = A[i];
    }
  }
//  在重新遍历数组，如果遇到奇数再次存储

  for(int i = 0; i < A.length; i ++){
    if(A[i] %2 == 1){
      ans[t++] = A[i];
    }
  }

  return ans;

  }

  public int [] sortArrayByParity2(int [] arr){
//    定义左右边界，分别指向数组的起始位置，结束位置
    int i = 0, j = arr.length - 1;
    while( i < j){
//      如果左边元素是奇数，右边元素是偶数，则交换两个元素
      if(arr[i] % 2 > arr[j] % 2){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
//      如果左边为偶数，则左边索引前进
      if(arr[i] % 2 == 0){
        i++;
      }
//      如果右边为奇数，则右边逆向前进
      if(arr[j] % 2 == 1){
        j--;
      }
    }
    return arr;
  }

}
