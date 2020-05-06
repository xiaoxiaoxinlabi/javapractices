import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test50 {

//  第一个只出现一次的字符
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
//  s = "abaccdeff"
//  返回 "b"

//  s = ""
//  返回 " "



  public void getString1(String s){


    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < s.length(); i ++){
      if(map.containsKey(s.charAt(i))){
        map.put(s.charAt(i), map.get(s.charAt(i)) +1);
      }else{
        map.put(s.charAt(i), 1);
      }
    }

    for(int j = 0; j < s.length(); j ++){
      if(map.get(s.charAt(j)) == 1){
         System.out.println(s.charAt(j));
         return;
      }
    }

  }

//  方法一：哈希表
//遍历字符串 s ，使用哈希表统计 “各字符数量是否 > 1”
//再遍历字符串 s ，在哈希表中找到首个 “数量为 1 的字符”，并返回。



  public char firstUniqChar(String s){
    HashMap <Character, Boolean> map = new HashMap<>();
    char [] sc = s.toCharArray();

//    如果map中以存在，则不存储
//    dic 中 不包含 键(key) c ：则向 dic 中添加键值对 (c, True) ，代表字符 c 的数量为 1；
//    若 dic 中 包含 键(key) c ：则修改键 c 的键值对为 (c, False) ，代表字符 c 的数量 > 1
//    map.containsKey(c): 如果包含则为TRUE, 如果不包含则为false

    for(char c: sc){
      map.put(c, !map.containsKey(c));
    }

//    从map根据sc的索引取出值
//    查找数量为 1 的字符： 遍历字符串 s 中的每个字符 c ；
    for(char c: sc){
//      若map.get(c) == true
      if(map.get(c)){
        return c;
      }
    }
//    返回 ' ' ，代表字符串无数量为 11 的字符。
    return ' ';

  }

//  方法二：有序哈希表
  public char firstUniqChar2(String s){

//    有序哈希表中的键值对是 按照插入顺序排序 的。基于此，可通过遍历有序哈希表，实现搜索首个 “数量为 11 的字符”。
      Map<Character, Boolean> map = new LinkedHashMap();
      char [] sc = s.toCharArray();
//    哈希表是 去重 的，即哈希表中键值对数量 \leq≤ 字符串 s 的长度
      for(char c: sc){
        map.put(c, !map.containsKey(c));
      }

//    当字符串很长（重复字符很多）时，方法二则效率更高。
      for(Map.Entry<Character, Boolean> res: map.entrySet()){
        if(res.getValue() == true){
          return res.getKey();
        }
      }
      return ' ';

  }

}
