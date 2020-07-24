import java.util.HashSet;
import java.util.Set;

public class MaxPower_1446 {

//  给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
//  请你返回字符串的能量。
//  示例 1：
//
//  输入：s = "leetcode"
//  输出：2
//  解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。

//  示例 2：
//
//  输入：s = "abbcccddddeeeeedcba"
//  输出：5
//  解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。


//循环遍历，依次对比
  public int maxPower1(String s){

   if(s.length() < 2){
     return s.length();
   }
   char [] arr = s.toCharArray();
   int res = 1, count = 1;
   for(int i = 1; i <arr.length; i++){
//     如果相等，则计数，并且判断是否最大
     if(arr[i]==arr[i-1]){
       count++;
       res = Math.max(res, count);
     }else{

//       如果不相等，则count 重置为1
       count = 1;
     }
   }
   return res;
  }

//  遍历，每个字符往后查
//  有相同的，计数
//  跳过相同的index，继续

  public int maxPower2(String s){
    int count = 0;
    char [] arr = s.toCharArray();
    for(int i = 0; i < arr.length; i ++){
      int k = i;

      int tempcnt = 0;
      while(k < arr.length){
        if(arr[k] == arr[i]){
          tempcnt++;
        }else{
          break;
        }
        k++;
      }
      i+=(k-i-1);
      if(tempcnt > count){
        count = tempcnt;
      }
    }
    return count;
  }

}
