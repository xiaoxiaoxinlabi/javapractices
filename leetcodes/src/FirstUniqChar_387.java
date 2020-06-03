import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar_387 {

//  给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//  示例：
//
//  s = "leetcode"
//  返回 0
//
//  s = "loveleetcode"
//  返回 2
  public static int firstUniqChar1(String s){

    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < s.length(); i ++){
      if(map.containsKey(s.charAt(i))){
        map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
      }else{
        map.put(s.charAt(i),1);
      }
    }

    for(int j = 0; j < s.length(); j ++){
      if(map.get(s.charAt(j)) == 1){

        return j;

      }
    }
    return -1;


  }

  // 第一种为字符串长度小于26的，遍历字符串
  public static int firstUniqChar2(String s){
    //存储各字符出现次数
    int [] letter = new int[26];
//    第一次遍历字符串求得各字符出现次数.
    for(char c: s.toCharArray()){
      letter[c-'a'] ++;
    }
//    第二次遍历字符串找出第一个出现次数为1的字符.
    for(int i = 0; i < s.length(); i++){
      if(letter[s.charAt(i) - 'a'] == 1){
        return i;
      }
    }
    return -1;
  }

  // 第二种字符串长度大于26，遍历26个字母
  public static int firstUniqChar3(String s){
    int index = -1;
    for(char ch = 'a'; ch <='z'; ch++){
      int beginIndex = s.indexOf(ch);
      // 从头开始的位置是否等于结束位置，相等说明只有一个，
      if(beginIndex !=-1 && beginIndex ==s.lastIndexOf(ch)){
        index = (index == -1 || index > beginIndex)? beginIndex:index;
      }
    }
    return index;
  }

  public static void main(String [] args){
    System.out.println(firstUniqChar1("loveleetcode"));
  }

}
