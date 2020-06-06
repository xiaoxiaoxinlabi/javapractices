import java.util.HashMap;
import java.util.Map;

public class Dd04 {

//  倒序输出字符串

  public static String fun(String s){
    String res = "";
    for(int i = s.length() - 1; i >=0; i--){
      res+=s.charAt(i);
    }
    return res;
  }

//  输出字符串中的重复字符,

  public static String fun1(String s){
    String res = "" ;
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < s.length(); i ++){
      if(map.containsKey(s.charAt(i))){
        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
      }else{
        map.put(s.charAt(i), 1);
      }
    }

    for(int i = 0; i < s.length(); i ++){
      if(map.get(s.charAt(i)) > 1){
        res+= s.charAt(i);
      }
    }
    return res;

  }

  //  输出字符串中的重复字符,

  public static void fun2(String s){


    int count = 0;
    for(int i = 0; i < s.length(); i ++){
      for(int j = i+1; j < s.length(); j ++){

        if(s.charAt(i) == s.charAt(j)){
          count++;
        }

      }
      if(count == 1){
        System.out.println(s.charAt(i));
      }
      count = 0;


      }

    }

  public static void fun3(String s){


    int count = 0;
    for(int i = 0; i < s.length(); i ++){
      for(int j = i+1; j < s.length(); j ++){

        if(s.charAt(i) == s.charAt(j)){
          count++;
        }

      }
      if(count == 1){
        System.out.println(s.charAt(i));
      }
      count = 0;


    }

  }




  public static void main(String [] args){
    fun2("aeebcde");

  }

}
