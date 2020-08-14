package cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuddyStrings_859 {

//  给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。

//  示例 1：
//
//  输入： A = "ab", B = "ba"
//  输出： true




  public static boolean buddyStrings(String a, String b){
//  1.如果字符串A的长度不等于字符串B的长度、字符串A等于字符串B等于空字符串以及字符串A的长度等于字符串B的长度等于1，返回false。

    if(a.length() != b.length() || (a.equals(" ") && b.equals(" ")) || (a.length() == 1 && b.length() == 1)){
      return false;
    }

    HashMap <Character , Integer> hashMap = new HashMap<>();
    List<Integer> list = new ArrayList();
    int count = 0;
    for(int i = 0; i < a.length(); i ++){
//      2.相对位置进行比较，并用HashMap记录字符串A每个元素的个数
      if(hashMap.containsKey(a.charAt(i))){
        hashMap.put(a.charAt(i), hashMap.get(a.charAt(i)) + 1);
      }else{
        hashMap.put(a.charAt(i), 1);
      }

//      若相对位置元素不一样count++，若count大于2，返回false。
      if(a.charAt(i) != b.charAt(i)){
        count ++;
        list.add(i);

        if(count > 2){
          return false;
        }
      }
    }
//    3.如果count等于0，代表字符串A和字符串B完全相等，这时候判断字符串A中是否有元素个数大于2，若有返回true。
    if(count == 0){
      if(a.equals(b)){
        Object [] lists = hashMap.values().toArray();
        for(int i = 0; i < lists.length; i ++){
          if((Integer)lists[i] > 2){
            return true;
          }
        }
      }
    }
//    4.如果count等于1，返回false。

    if(count == 1){
      return false;
    }

//    5.如果count等于2，比较(A.charAt(i) == B.charAt(j)) && (A.charAt(j) == B.charAt(i)),若为true，返回true，反之返回false。

    if(count == 2){
      if(a.charAt(list.get(0)) == b.charAt(list.get(1)) && a.charAt(list.get(1)) == b.charAt(list.get(0))){
        return true;
      }
    }
    return false;

  }

}
