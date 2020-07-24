package en;

public class CountCharacters_1160 {

//  给定一个数组，一个字符串，如果数组中的每个值都能由字符串中的每个字符组成，则返回字符串数组中的值的长度之和

//  Example 1:
//
//  Input: words = ["cat","bt","hat","tree"], chars = "atach"
//  Output: 6
//  Explanation:
//  The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
//
//  Example 2:
//
//  Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//  Output: 10
//  Explanation:
//  The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.



  public static int countCharacters1(String [] words, String chars){

    int count = 0;
    int c [] = new int [26];

//    将chars 中的单个字符通过ascii 的形式统计其出现的次数
    for(int i = 0; i < chars.length(); i ++){
      c[chars.charAt(i) - 'a']++;
    }
    for(String s: words){
      int ch[] = c.clone();
      boolean flag = true;

//      依次遍历数组中每个元素中的每个字符是否在ch数组中匹配到
      for(int i = 0; i < s.length(); i ++){
        char chr = s.charAt(i);
        ch[chr - 'a']--;

        if(ch[chr - 'a'] < 0){
          flag = false;
          break;
        }
      }
//      如果匹配到，则其长度为 之前长度加上 改元素的长度
      if(flag){
        count+=s.length();
      }
    }

    return count;


  }

  public static void main(String [] args){

    String [] str = {"cat","bt","hat","tree"};
    String chars = "atach";
    System.out.println(countCharacters1(str,chars));

  }
}

