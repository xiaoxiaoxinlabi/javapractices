package en.hashTable;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference_389 {

//    字符串t由随机改组字符串s生成，然后在随机位置再添加一个字母。
//    返回添加到t的字母

    public char findTheDifference(String s, String t) {

        char [] arr = new char[26];
        char res = ' ';

        for(int i = 0; i < t.length(); i ++){
            char c = t.charAt(i);
            arr[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i ++){
            char cs = s.charAt(i);
            arr[cs - 'a']--;
        }

        for(int i = 0; i < t.length(); i ++){
            if(arr[t.charAt(i) - 'a'] != 0){
                res = t.charAt(i);
            }
        }
        return res;

    }

    public char findTheDifference1(String s, String t){
        Map<Character, Integer> map = new HashMap();

        char res = ' ';
        for(int i = 0; i < t.length(); i ++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            }
        }

//        遍历数组，通过数组匹配map
//        for(int i = 0; i < t.length(); i ++){
//            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) != 0){
//                res = t.charAt(i);
//            }
//        }

//        遍历map
        for(Character i : map.keySet()){
            if(map.get(i) != 0){
                res = i;
            }
        }
        return res;

    }

    public char findTheDifference2(String s,String t){
        int [] cht = new int[26];
        int [] chs = new int[26];

        for(char cs : s.toCharArray()){
            chs[ cs - 'a']++;
        }

        for(char ts : t.toCharArray()){
            cht[ts - 'a']++;
        }

        for(int i = 0; i < 26; i ++){
            if(chs[i] != cht[i]){
                return (char)(i + 'a');
            }
        }

        return '0';

    }

    public char findTheDifference3(String s, String t){
        int [] counts = new int[26];
        for(char ch : s.toCharArray()){
            ++counts[ch - 'a'];
        }

        for(char ch : t.toCharArray()){
            --counts[ch - 'a'];
            if(counts[ch - 'a'] < 0){
                return ch;
            }
        }
        return ' ';
    }

//    转换成ascii 的值，相减之后再转成字符
    public char findTheDifference4(String s, String t){
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < s.length(); i ++){
            sum1+=s.charAt(i);
        }
        for(int i = 0; i < t.length(); i ++){
            sum2+=t.charAt(i);
        }
        int a = sum2 - sum1;
        char c = (char)a;
        return c;
    }
}
