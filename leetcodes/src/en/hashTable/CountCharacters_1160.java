package en.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountCharacters_1160 {

//    给您一个字符串单词数组和一个字符串char。
//    如果字符串可以由字符中的字符组成（每个字符只能使用一次），则该字符串是好的。
//    返回所有好的字符串的长度之和。

//    Example 1:
//    Input: words = ["cat","bt","hat","tree"], chars = "atach"
//    Output: 6
//    Explanation:
//    The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
//    Example 2:
//
//    Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//    Output: 10
//    Explanation:
//    The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

    public int countCharacters(String[] words, String chars) {

        int count = 0;
        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < chars.length(); i ++){
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i),0)+1);
        }

        for(String word :words){
            Map<Character,Integer> check = new HashMap();
            for(char c: word.toCharArray()){
                check.put(c, check.getOrDefault(c,0)+1);
            }
            if(check.size() > map.size()){
                continue;
            }
            boolean findIt = true;
            for(Map.Entry<Character,Integer> entry : check.entrySet()){
                if(map.get(entry.getKey()) == null || map.get(entry.getKey()) < entry.getValue()){
                    findIt = false;
                    break;
                }
            }

            if(findIt){
                count += word.length();
            }

        }
        return count;


    }

    public int countCharacters1(String[] words, String chars){
        int count = 0;
        int [] charct = new int[26];
        for(int i = 0; i < chars.length(); i ++){
            charct[chars.charAt(i) - 'a']++;
        }

        for(String word: words){
            int [] temp = Arrays.copyOf(charct,26);
            boolean canbeformed = true;
            for(char ch : word.toCharArray()){
                if(--temp[ch - 'a'] < 0){
                    canbeformed = false;
                    break;

                }
            }
            if(canbeformed){
                count += word.length();
            }
        }
        return count;
    }

    public int countCharacters2(String[] words, String chars){
        int [] charArr = new int[26];
        for(int i = 0; i < chars.length(); i ++){
            charArr[chars.charAt(i) - 'a']++;
        }

        int count = 0;
        for(String word: words){
            if(word.length() <= chars.length() && isFit(word.toCharArray(),charArr)){
                count += word.length();
            }
        }
        return count;
    }

    private boolean isFit(char [] wordArr, int [] chars){
        int [] arr = new int[26];
        for(int i = 0; i < wordArr.length; i ++){
            arr[wordArr[i] - 'a']++;
            if(chars[wordArr[i] - 'a'] < arr[wordArr[i] - 'a']){
                return false;

            }
        }
        return true;

    }
}
