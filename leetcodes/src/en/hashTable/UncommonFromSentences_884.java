package en.hashTable;

import java.io.StringReader;
import java.util.*;

public class UncommonFromSentences_884 {

//    给定两个字符串，；如果一个单词恰好在一个句子中出现一次而在另一个句子中不出现，则该单词并不常见。
//    返回所有不常见单词的列表。
//    Example 1:
//    Input: A = "this apple is sweet", B = "this apple is sour"
//    Output: ["sweet","sour"]
//
//    Example 2:
//    Input: A = "apple apple", B = "banana"
//    Output: ["banana"]

    public String[] uncommonFromSentences(String A, String B) {

      Set<String> set = new HashSet<>();
      Set<String> removed = new HashSet();
      for(String a: A.split(" ")){
//          如果set不包含，则将其添加到set中去
          if(!set.add(a) || !removed.add(a)){
              set.remove(a);
          }
      }

      for(String b: B.split(" ")){
          if(!set.add(b) || !removed.add(b)){
              set.remove(b);
          }
      }

      String [] res = new String[set.size()];
      int i = 0;
      for(String r: set){
          res[i++] = r;
      }
      return res;
    }

    public String[] uncommonFromSentences1(String A, String B){
        String C = A + " " + B;
        String [] words = C.split(" ");
        HashMap<String, Integer> hm = new HashMap();
        List<String> res = new ArrayList();

        for(String word: words){
            hm.put(word, hm.getOrDefault(word,0) + 1);
        }

        for(Map.Entry<String,Integer> entry: hm.entrySet()){
            if(entry.getValue() == 1){
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public String [] uncommonFromSentences2(String A, String B){
        Set<String> firstSet = new HashSet<>();
        Set<String> repetition = new HashSet<>();

//        如果A中的元素在firstSet中存在，则将其添加到重复的set中
        for(String word: A.split(" ")){
            if(firstSet.contains(word)){
                repetition.add(word);
            }else{
                firstSet.add(word);
            }
        }

//        如果B中的元素在secondSet中存在，则将其添加到重复的set中
        Set<String> secondSet = new HashSet<>();
        for(String word: secondSet){
            if(secondSet.contains(word)){
                repetition.add(word);
            }else{
                secondSet.add(word);
            }
        }

        List<String> res = new ArrayList();
        for(String word: firstSet){
            if(!secondSet.contains(word) && !repetition.contains(word)){
                res.add(word);
            }
        }
        for(String word: secondSet){
            if(!firstSet.contains(word) && !repetition.contains(word)){
                res.add(word);
            }
        }
        String [] result = new String[res.size()];
        return res.toArray(result);
    }

    public static void main(String [] args){
        String A = "this apple is sweet";
        String B = "this apple is sour";
        new UncommonFromSentences_884().uncommonFromSentences(A,B);
    }
}
