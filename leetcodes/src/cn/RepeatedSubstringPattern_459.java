package cn;

import java.util.HashMap;
import java.util.Map;

public class RepeatedSubstringPattern_459 {

//  给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//  示例 1:
//  输入: "abab"
//  输出: True
//  解释: 可由子字符串 "ab" 重复两次构成。

  public boolean repeatedSubstringPattern1(String s){

//    1.将原字符串给出拷贝一遍组成新字符串；
    String str = s +s;
//    2.掐头去尾留中间；
//    3.如果还包含原字符串，则满足题意。
    return str.substring(1, str.length()-1).contains(s);



  }

//  如果全是重复的子字符串，那么使用split函数拆分后的数组长度将会是0
//  找字符串长度的因子，挨个去拆分出子串，去测试满足split函数拆分的数组长度是否为0
  public boolean repeatedSubstringPattern2(String s){
    if(s == null){
      return false;
    }
    if(s.length() == 1){
      return false;
    }
    // 长度大于1，可以拆分出子串，判断字符串中是否所有字符都相同，如"aaaaaa","zzz"，一定满足按子串长度为1的拆分，所以直接返回true
    if(s.split(String.valueOf(s.charAt(0))).length == 0){
      return true;
    }

    for(int i = s.length()-1; i >=2;i--){
      if(s.length() % i == 0){
        String pattern = s.substring(0,i);
        String [] arr = s.split(pattern);
        if(arr.length == 0){
          return true;
        }
      }
    }
    return false;
  }


}
