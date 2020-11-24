package en.hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsIsomorphic_205 {
//    给定两个字符串s和t，确定它们是否同构。
//    如果可以替换s中的字符以获得t，则两个字符串是同构的。
//    在保留字符顺序的同时，必须将所有出现的字符替换为另一个字符。没有两个字符可以映射到同一字符，但是一个字符可以映射到自身。
//    Example 1:
//    Input: s = "egg", t = "add"
//    Output: true
//
//    Example 2:
//    Input: s = "foo", t = "bar"
//    Output: false
//
//    Example 3:
//    Input: s = "paper", t = "title"
//    Output: true
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap();

        char [] as = s.toCharArray();
        char [] at = t.toCharArray();

        for(int i = 0; i < as.length; i ++){
            if(!map.containsKey(as[i]) && !map.containsValue(at[i])){
                map.put(as[i], at[i]);
            }
            if(map.get(as[i]) == null || map.get(as[i]) != at[i]){
                return false;
            }
        }
        return true;

    }

    public boolean isIsomorphic1(String s, String t){
        Map<Character,Character> mapping = new HashMap();
        Set<Character> visited = new HashSet();

        for(int i = 0; i < s.length(); i ++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(!mapping.containsKey(sc) && !visited.contains(tc)){
                mapping.put(sc,tc);
                visited.add(tc);
            }else if(mapping.containsKey(sc) && mapping.get(sc) == tc){
                continue;
            }else{
                return false;
            }

        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t){
        HashMap<Character, Character> map = new HashMap();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i ++){
            Character tmp = map.get(s.charAt(i));

            if(tmp == null && map.containsValue(t.charAt(i))){
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        StringBuilder ss = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            ss.append(map.get(s.charAt(i)));
        }
        if(ss.toString().endsWith(t)){
            return true;
        }
        return false;
    }

    public boolean isIsomorphic3(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
//        数组 a,b 用于存放 每个字符出现的次数
        int a[] = new int[256];
        int b[] = new int[256];

        for(int i = 0; i < s.length(); i ++){
//            如果固定索引上的a，b 两者相同，则增加其值
            if(a[s.charAt(i)] == b[t.charAt(i)]){
                a[s.charAt(i)] = i + 1;
                b[t.charAt(i)] = i + 1;
            }else{
                return false;
            }
        }
        return true;
    }
}
