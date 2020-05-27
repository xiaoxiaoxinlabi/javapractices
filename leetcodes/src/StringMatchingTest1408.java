import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StringMatchingTest1408 {

//  数组中的字符串匹配
//给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
//如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
//  输入：words = ["mass","as","hero","superhero"]
//  输出：["as","hero"]
//  解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
//      ["hero","as"] 也是有效的答案。


  public static String  stringMatching(String [] words){

    ArrayList<String> res = new ArrayList();

    for(int i = 0; i < words.length; i++){
      for(int j = 0; j < words.length; j ++){
       if(i == j){
         continue;
       }
//       如果 words[i]  在 words[j] 中出现过，则加入集合
       if(words[j].indexOf(words[i]) >= 0){
         res.add(words[i]);
         break;
       }
      }
    }

    return res.toString();

  }

  public static List<String> stringMatching1(String [] words){
    List<String> rsult = new ArrayList<>();
    String longer = null;
    String shorter = null;
    for(int i = 0; i < words.length; i++){
      for(int j = i + 1; j < words.length; j++){
        longer = words[i].length() > words[j].length() ? words[i] : words[j];
        shorter = words[i].length() < words[j].length() ? words[i] : words[j];

        if(longer.contains(shorter)){
          if(!rsult.contains(shorter)){
            rsult.add(shorter);
          }
        }
      }
    }
    return rsult;
  }


  public static void main(String [] args){

      String [] words = {"mass","as","hero","superhero"};
    System.out.println(stringMatching1(words).toString());


  }

}
