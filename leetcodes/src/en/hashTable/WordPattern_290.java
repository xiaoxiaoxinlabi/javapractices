package en.hashTable;
import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

//    给定一个模式和一个字符串s，查找s是否遵循相同的模式。
//    Example 1:
//    Input: pattern = "abba", s = "dog cat cat dog"
//    Output: true
//
//    Example 2:
//    Input: pattern = "abba", s = "dog cat cat fish"
//    Output: false
    public boolean wordPattern(String pattern, String s) {

//        map中存储的key: 匹配模式 value：截取的字符串
        Map<String, String> map = new HashMap();
        String [] ss = s.split(" ");
        if(ss.length != pattern.length()){
            return false;
        }

        for(int i = 0; i < pattern.length(); i ++){
            String tmp = String.valueOf(pattern.charAt(i));
            if(map.containsKey(tmp)){
                if(!map.get(tmp).equals(ss[i])){
                    return false;
                }
            }else if(map.containsValue(ss[i])){
                return false;
            }else{
                map.put(tmp, ss[i]);
            }

        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s){
        Map<Character,String> map = new HashMap();
        String [] str = s.split(" ");
        if(str.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < pattern.length(); i ++){
            char c = pattern.charAt(i);
            String stmp = str[i];
            if(!map.containsKey(c) && !map.containsValue(stmp)){
                map.put(c, stmp);
            }
            if(map.containsKey(c) && !map.get(c).equals(stmp) || !map.containsKey(c) && map.containsValue(stmp)){
                return false;
            }
        }
        return true;
    }


}
