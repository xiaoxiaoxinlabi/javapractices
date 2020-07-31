package en.strings;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct_383 {

//    给定一个任意的赎金票据字符串和另一个包含所有杂志字母的字符串，编写一个函数，如果可以从杂志中构造赎金票据，则该函数将返回true；否则，它将返回false。
//    杂志字符串中的每个字母只能在赎金记录中使用一次。

    public boolean canConstruct1(String ransomNote, String magazine){
//        先将被查找的字符串存放入map中，并统计每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i ++){
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0)+1);
        }

//        遍历要查找的字符串，如果该字符串中的每个字符在map中出现过，则map中对应key的值减一
//        如果不存在，则返回false
        for(int i = 0; i < ransomNote.length(); i ++){
            char c = ransomNote.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) > 0){
                    map.put(c, map.get(c)-1);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

//    利用数组统计26个字符出现的次数
    public boolean canConstruct2(String ransomNote, String magazine){
        int [] count1 = new int[26];
        int [] count2 = new int[26];

//        统计ransomnote 中的字符出现的次数
        for(char r : ransomNote.toCharArray()){
            count1[r-'a']++;
        }
//        统计magazine 中的字符出现的次数
        for(char m : magazine.toCharArray()){
            count2[m - 'a']++;
        }

//        如果ransomNote 中对应的字符出现次数大于magazine 中字符出现的次数，则返回false
        for(int i = 0; i < 26; i ++){
            if(count1[i] != 0 && count1[i] > count2[i]){
                return false;
            }
        }
        return true;

    }

//    利用数组统计字符在出现的次数
    public boolean canConstruct3(String ransomNote, String magazine){
        int [] arr = new int[26];
//        先统计被查找的字符串中，每个字符出现的次数
        for(char ch: magazine.toCharArray()){
            arr[ch - 'a']++;
        }
//        在统计查找的字符串中每个字符出现的次数，如果在数组中出现，则数组对应的值减一
        for(char ch: ransomNote.toCharArray()){
            if(arr[ch - 'a']==0){
                return false;
            }
            arr[ch - 'a']--;
        }
        return true;
    }
}
