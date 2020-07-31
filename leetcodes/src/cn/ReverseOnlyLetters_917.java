package cn;

import java.util.Stack;

public class ReverseOnlyLetters_917 {


//  仅仅反转字母
//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

//  输入："ab-cd"
//  输出："dc-ba"
//  示例 3：
//
//  输入："Test1ng-Leet=code-Q!"
//  输出："Qedo1ct-eeLg=ntse-T!"

//  思想：利用栈（先进后出）
  public static String reverseOnlyLetters1(String s) {

    Stack<Character> stack = new Stack();
    for(int i = 0; i < s.length(); i ++){

//      如果是字母则放入栈中
      if(Character.isLetter(s.charAt(i))){
        stack.push(s.charAt(i));
      }
    }

    StringBuilder res = new StringBuilder();
    for(int j=0; j < s.length(); j++){
//      将栈中的内容pop粗来
      if(Character.isLetter(s.charAt(j))){
        res.append(stack.pop());
      }else{
        res.append(s.charAt(j));
      }
    }

    return res.toString();


  }


public static String reverseOnlyLetters2(String s){
  StringBuilder ans = new StringBuilder();
  int j = s.length()-1;
  for(int i = 0; i < s.length(); i++){
    if(Character.isLetter(s.charAt(i))){
      while(!Character.isLetter(s.charAt(j))){
        j--;
      }
      ans.append(s.charAt(j--));
    }else{
      ans.append(s.charAt(i));
    }
  }
  return ans.toString();
}
}