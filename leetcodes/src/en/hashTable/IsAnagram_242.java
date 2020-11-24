package en.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram_242 {
//    给定两个字符串s和t，编写一个函数以确定t是否是s的字谜。

    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i ++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        for(int j = 0; j < t.length(); j ++){
           char c = t.charAt(j);
           if(!map.containsKey(c)){
               return false;
           }
           int count = map.get(c) - 1;
           if(count == 0){
               map.remove(c);
           }else{
               map.put(c,count);
           }
        }

        return map.size() == 0 ? true:false;
    }

    public boolean isAnagram1(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char [] arrs = s.toCharArray();
        char [] arrt = t.toCharArray();
        Arrays.sort(arrs);
        Arrays.sort(arrt);

        String first = new String(arrs);
        String second = new String(arrt);
        return first.equals(second);
    }

    public boolean isAnagram2(String s, String t){
        int [] alphain = new int[26];
        char [] arrs = s.toCharArray();
        for(int i = 0; i < arrs.length; i ++){
            alphain[arrs[i] - 'a']++;
        }
        char [] arrt = t.toCharArray();
        for(int i = 0; i < arrt.length; i ++){
            alphain[arrt[i] - 'a']--;
            if(alphain[arrt[i] - 'a'] < 0){
                return false;
            }
        }
        for(int i = 0; i < 26; i ++){
            if(alphain[i] != 0){
                return false;
            }
        }
        return true;
    }
}
