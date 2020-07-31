package en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonChars_1002 {


//  给定仅由小写字母组成的字符串数组A，返回列表中所有字符串（包括重复项）中显示的所有字符的列表。
//  例如，如果一个字符在所有字符串中出现3次，但没有出现4次，那么您需要在最终答案中将该字符包含3次。
//
//  您可以按任何顺序返回答案。

//  Example 1:
//
//  Input: ["bella","label","roller"]
//  Output: ["e","l","l"]
//  Example 2:
//
//  Input: ["cool","lock","cook"]
//  Output: ["c","o"]

  public List<String> commonChars1(String [] A){

    Map<Character,Integer> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    for(int i = 0; i < A.length; i++){
      for(int j = 0; j < A[i].length(); j ++){
        if(map.containsKey(A[i].charAt(j))){
          map.put(A[i].charAt(j), map.get(A[i].charAt(j)) + 1);
        }else{
          map.put(A[i].charAt(j), 1);
        }
      }
    }


    for(Map.Entry m: map.entrySet()){
      if(m.getValue().equals(3)){
       res.add(m.getKey().toString());
      }
      if( (int)m.getValue() % 3 == 0 && (int)m.getValue() / 3 !=0){
        res.add(m.getKey().toString());

      }
    }

    return res;

  }


  public List<String> commonChars2(String [] A){

    Map<Character,Integer> map = new HashMap<>();
    List<String> res = new ArrayList<>();
//    遍历数组
    for(int i =0; i < A.length; i ++){

//      tmp 用来存储数组中每个索引上的字符出现的次数
      HashMap<Character,Integer> tmp = new HashMap<>();
      for(char c: A[i].toCharArray()){
//        Add all characters with their frequencies
        tmp.put(c, tmp.getOrDefault(c, 0) + 1);
      }

//      如果map为空的情况下
//      最初，结果为空。因此，只需将所有条目从临时映射复制到结果
      if(map.isEmpty()){
//        将tmp中的存储的key遍历，存储到map中
        for(Character c: tmp.keySet()){
          map.put(c, tmp.get(c));
        }
      }else{

//        如果map不为空，找出tmp 中的每个字符出现的次数，与map中字符出现的次数，然后将两者的最小值存储到map对应的value中
        for (Character c: map.keySet()){

          map.put(c, Math.min(tmp.getOrDefault(c, 0), map.get(c)));
        }
      }

    }

//    循环遍历 map的key, 然后将值添加到list中

    for(Character c: map.keySet()){
      for(int i = 0; i < map.get(c); i ++){
        res.add(c.toString());
      }
    }
    return res;

    }

  }


