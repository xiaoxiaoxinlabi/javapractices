package en.hashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar_387 {
//    给定一个字符串，找到其中的第一个非重复字符并返回其索引。如果不存在，则返回-1。
//    Examples:
//    s = "leetcode"
//            return 0.
//
//    s = "loveleetcode"
//            return 2.
//
    public int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }

    public int firstUniqChar1(String s){
        char [] carrs = new char[26];
        for(int i = 0; i < s.length(); i ++){
            carrs[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i ++){
            if(carrs[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s){
        int arr[] = new int[26];
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            if(arr[c - 'a'] == 1){
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public int firstUniqChar3(String s){
        int [] count = new int[256];
        for(int i = 0; i < s.length(); i ++){
            count[s.charAt(i)]++;
        }

        for(int i = 0; i < s.length(); i ++){
            if(count[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
    
    public int firstUniqChar4(String s){
        int min = Integer.MAX_VALUE;
        for(char i = 'a'; i <= 'z'; i ++){
            int index = s.indexOf(i);

            if(index != -1 && s.lastIndexOf(i) == index){
                min = Math.min(index,min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
