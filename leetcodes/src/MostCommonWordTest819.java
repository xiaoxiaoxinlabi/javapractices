import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class MostCommonWordTest819 {

  //    给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
//    题目保证至少有一个词不在禁用列表中，而且答案唯一。
//    禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

//    输入:
//    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//    banned = ["hit"]
//    输出: "ball"

  public static String mostCommonWord(String paragraph, String [] banned){

    Set<String> set = new HashSet<>();
    for(int i = 0 ; i < banned.length; i ++){
      set.add(banned[i]);
    }

    Map<String, Integer> map = new HashMap<>();
    char [] c = paragraph.toCharArray();
    StringBuilder newStr = new StringBuilder();
    int max = 0;
    String ans = " ";

    for(int j = 0; j < c.length; j ++){

//      将单词存放在StringBuilder 中
      if(Character.isLetter(c[j])){
        newStr.append(Character.toLowerCase(c[j]));

      }else if(newStr.length() > 0){
        String finalnewStr = newStr.toString();
//      判断单词是否在禁用单词中
        if(!set.contains(finalnewStr)){
//          如果不在则，将单词放入map中，并统计出现的次数
          map.put(finalnewStr, map.get(finalnewStr) + 1);

//          比较当前单词出现的次数与历史最高次数的大小
          if(map.get(finalnewStr) > max){
//            将出现最多的值存放到输出值中
            ans = finalnewStr;
            max = map.get(finalnewStr);
          }
        }
//        一个单词处理完之后清空newStr,
        newStr = new StringBuilder();
      }

    }

 return ans;


  }



}
