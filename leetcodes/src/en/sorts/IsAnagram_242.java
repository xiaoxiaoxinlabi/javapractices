package en.sorts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram_242 {

//    给定两个字符串s和t，编写一个函数以确定t是否是s的字谜。

//    Example 1:
//
//    Input: s = "anagram", t = "nagaram"
//    Output: true

//    Example 2:
//
//    Input: s = "rat", t = "car"
//    Output: false

//统计字符串中的字符出现次数，在比较
    public boolean isAnagram(String s, String t) {

//        如果两个字符串的长度不相等，则返回false
        if(s.length() != t.length()){
            return false;
        }

//        定义一个数组统计 s中 每个字符出现的次数
        int [] arr = new int[26];
        for(int i = 0; i < s.length();i++){
            arr[s.charAt(i) - 'a']++;

        }

//        再次遍历字符串 t
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
//            如果 t 中的某个字符在 arr中的出现次数为0 ，则说明此字符在 s 中不存在，返回false
            if(arr[c - 'a'] == 0){
                return false;
            }else{
//                否则，如果遇到存在的，则减去s中出现的次数
                arr[t.charAt(i) - 'a']--;
            }
        }

        return true;

    }

    public boolean isAnagram0(String s, String t){
        int [] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            count[c - 'a']--;
        }
        for(int i : count){
            if(i != 0){
                return false;
            }
        }
        return true;
    }



//    转换成字符数组，并排序，然后进行比较
    public boolean isAnagram1(String s, String t){

        int lens = s.length(), lent = t.length();
        if(lens != lent){
            return false;
        }
        char [] arrs = s.toCharArray();
        char [] arrt = t.toCharArray();

        Arrays.sort(arrs);
        Arrays.sort(arrt);

        for(int i = 0; i < lens; i++){
            if(arrs[i] !=arrt[i]){
                return false;
            }
        }
        return true;

    }

//    采用hashmap 方式 ;耗时太长
    public boolean isAnagram2(String s, String t){
        Map<Character,Integer> map = new HashMap();
        char [] arrs = s.toCharArray();
        char [] arrt = t.toCharArray();

        for(Character ss: arrs){
            map.put(ss, map.getOrDefault(ss,0)+1);
        }

        for(Character tt: arrt){

            if(map.get(tt) == null){
                return false;
            }

            else if(map.get(tt) == 0 ){
                return false;
            }else{
                map.put(tt, map.get(tt)-1);
            }

        }

        for(Integer value: map.values()){
            if(value != 0){
                return false;
            }
        }
        return true;

    }

    public boolean isAnagram22(String s, String t){
        Map<Character ,Integer> maps = new HashMap();
        for(int i = 0; i < s.length(); i ++){
            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i),0)+1);
        }

        for(int j = 0; j < t.length(); j++){
            char temp = t.charAt(j);
            if(maps.containsKey(temp) &&maps.get(temp) > 0){
                maps.put(temp, maps.get(temp) - 1);
                if(maps.get(temp) == 0){
                    maps.remove(temp);
                }
            }else{
                return false;
            }

        }
        return true;
    }

    public boolean isAnagram3(String s, String t){
        char [] s1 = s.toCharArray();
        char [] s2 = s.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.toString(s1).equals(Arrays.toString(s2));
    }
}
