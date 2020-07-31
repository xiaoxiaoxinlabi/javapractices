package en;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm_989 {
//
//  对于非负整数X，X的数组形式是其数字从左到右的数组。例如，如果X = 1231，则数组形式为[1,2,3,1]。
//  给定非负整数X的数组形式A，返回整数X + K的数组形式。
//  Input: A = [1,2,0,0], K = 34
//  Output: [1,2,3,4]
//  Explanation: 1200 + 34 = 1234
//
//  Example 3:
//
//  Input: A = [2,1,5], K = 806
//  Output: [1,0,2,1]
//  Explanation: 215 + 806 = 1021
//
//  Example 4:
//
//  Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
//  Output: [1,0,0,0,0,0,0,0,0,0,0]
//  Explanation: 9999999999 + 1 = 10000000000


  public List<Integer> addToArrayForm1 (int [] A, int k){

    int N = A.length;
    int cur = k;
    List<Integer> ans = new ArrayList();
    int i = N;
    while(--i >= 0 || cur > 0){

//      计算cur 与当前 索引对应的值，
      if(i >= 0){
        cur+=A[i];
      }
//      然后取 余将结果添加到集合中
      ans.add(cur % 10);
      cur = cur / 10;
    }

    Collections.reverse(ans);
    return ans;
  }

  public List<Integer> addToArrayForm2(int [] A, int k){
    List<Integer> res = new ArrayList<>();
    int i = A.length - 1, carry = 0;
    while(i >= 0 || k > 0){
      int sum = carry;

//      如果索引存在,则
      if(i >= 0){
        sum=sum + A[i];
      }
//      如果k 存在 sum = sum + k % 10
      if(k > 0){
        sum= sum + k % 10;
      }

//      将sum % 10 添加到集合中
      res.add(sum % 10);
//      进位值为当前sum / 10
      carry = sum / 10;
//      缩小 i, 缩小 k
      i--;
      k=k/10;
    }

//    如果进位值为1 ，则添加到 集合中
    if(carry == 1){
      res.add(1);
    }
//    集合是在末尾添加，所以最后添加的值则在集合的末尾，因此需要将集合翻转
     Collections.reverse(res);
    return res;
  }



}
