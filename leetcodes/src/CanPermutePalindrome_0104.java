import java.util.HashSet;
import java.util.Set;

public class CanPermutePalindrome_0104 {

//  给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//  回文串是指正反两个方向都一样的单词或短语。
//  排列是指字母的重新排列。
//  回文串不一定是字典当中的单词。
//  示例1：
//
//  输入："tactcoa"
//  输出：true（排列有"tacocat"、"atcocta"，等等）



//思路一：  每个字符出现的次数为偶数, 或者有且只有一个字符出现的次数为奇数时, 是回文的排列; 否则不是.

  public static boolean canPermutePalindrome(String s){

    Set<Character> set = new HashSet<>();
    for(int i = 0; i < s.length(); i ++){
      if(!set.add(s.charAt(i))){
        set.remove(s.charAt(i));
      }
    }

    return set.size() <= 1;



  }

  //  采用消消乐的思想，遍历字符串，如果set集合中有当前字符则消除它，没有就添加它，最终字符数量小于等于1说明它能完成对称

  public static boolean canPermutePalindrome1(String s){

    Set<Character> res = new HashSet<>();
    for(int i = 0; i < s.length(); i ++){
      if(res.contains(s.charAt(i))){
        res.remove(s.charAt(i));
      }else{
        res.add(s.charAt(i));
      }
    }
//    当set.size() == 1 时，同时也得到s.length 为奇数 当set.size() == 0 时，同时也得到s.length 为偶数
    return res.size() <= 1;

  }

}
