package cn;

import java.util.Arrays;

public class ReverseString_344 {

//  编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出
//  不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
//
//  示例 1：
//
//  输入：["h","e","l","l","o"]
//  输出：["o","l","l","e","h"]

  public static void reverseString1(char [] chars){

    for(int i = 0; i < chars.length / 2; i ++){
      char  temp = chars[i];
      chars[i] = chars[chars.length - i - 1];
      chars[chars.length-i-1] = temp;
    }

    System.out.println(Arrays.toString(chars));

  }

//  时间复杂度：O(N)。执行了 N/2次的交换
//  空间复杂度：O(1)，只使用了常数级空间。
  public static void reverseString2(char [] s){

    int left = 0, right = s.length - 1;
    while(left < right){
      char tmp = s[left];
      s[left++] = s[right];
      s[right--] = tmp;
    }

  }


  public static void main(String [] args){
    char []  c = {'h','e','l','l','o'};

    reverseString1(c);
  }

}
