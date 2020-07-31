import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation_0102 {
//  面试题 01.02. 判定是否互为字符重排
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//  示例 1：
////
////  输入: s1 = "abc", s2 = "bca"
////  输出: true
////
////  示例 2：
////
////  输入: s1 = "abc", s2 = "bad"
////  输出: false

  public boolean CheckPermutation1(String s1, String s2) {

    if (s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
      return false;
    }
//    因为大小写字符ASCII最大值为z的122,所以只要是大于122就可以
    int[] index = new int[128];
    for (int i = 0; i < s1.length(); i++) {
      index[s1.charAt(i)]++;
      index[s2.charAt(i)]--;
    }
    for (int i = 0; i < 128; i++) {
      if (index[i] != 0) {
        return false;
      }
    }

    return true;

  }

  //  直接用调用内置函数
  public boolean CheckPermutation2(String s1, String s2) {
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    Arrays.sort(c1);
    Arrays.sort(c2);
    return new String(c1).equals(new String(c2));
  }


  public boolean CheckPermutation3(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap();
    for (char ch : s1.toCharArray()) {
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    for (char ch : s2.toCharArray()) {
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) < 0) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;

  }

  //利用数组
  public boolean CheckPermutation4(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int[] temp = new int[256];
    for (int i = 0; i < s1.length(); i++) {
//      利用字符的ascii码做索引，计算该索引出现的次数
      temp[s1.charAt(i)]++;
    }
    for (int i = 0; i < s2.length(); i++) {
//      如果s2 中的字符对应的ascii 在temp中的值为0 ，则说明在s1中没有出现过
      if (temp[s2.charAt(i)] == 0) {
        return false;
      }
//      如果出现，则减一，直到为0
      temp[s2.charAt(i)]--;
    }

    return true;
  }


  public static void main(String[] args) {

    CheckPermutation_0102 ss = new CheckPermutation_0102();
    ss.CheckPermutation4("abc", "cba");


  }

}