package en.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatching_1408 {

//    给定一个字符串单词数组。以任何顺序返回单词中所有字符串，这些字符串是另一个单词的子字符串。
//    字符串words [i]是words [j]的子字符串，如果可以获取的话，可以去除words [j]左侧和/或右侧的一些字符

//    Example 1:
//
//    Input: words = ["mass","as","hero","superhero"]
//    Output: ["as","hero"]
//    Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
//            ["hero","as"] is also a valid answer.
//            Example 2:
//
//    Input: words = ["leetcode","et","code"]
//    Output: ["et","code"]
//    Explanation: "et", "code" are substring of "leetcode".



    public List<String> stringMatching(String[] words) {

        List<String> res = new ArrayList();
//        采用双层循环遍历，如果内部循环中的元素包含外部的某一个元素，并且不等于它，则将它添加到结果集中
        for(String word: words){
            for(int i = 0; i < words.length; i++){
               if(words[i].contains(word) && words[i] != word){
                   res.add(word);
                   break;
               }
            }
        }
        return res;

    }

    public List<String> stringMatching1(String[] words){
        Set<String> res = new HashSet<>();
        for(int i = 0; i < words.length; i ++){
            for(int j = 0; j < words.length; j ++){
                if(words[i].contains(words[j]) && i != j){
                    res.add(words[j]);

                }
            }
        }
        return new ArrayList(res);
    }

}
