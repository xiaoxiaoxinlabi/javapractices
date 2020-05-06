import java.util.HashSet;
import java.util.Set;

public class Test0101 {

//  实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

  public boolean isUnique1(String s){
    for(int i = 0; i < s.length(); i ++){
      //比较该字符之后的字符是否有相同字符
      if(s.indexOf(s.charAt(i), i+1) > -1){
        return false;
      }
      return true;
    }
    return false;
  }

  public boolean isUnique2(String s){
    Set set = new HashSet<>();

    for(int i = 0; i < s.length(); i ++){
      if(!set.add(s)){
        return false;
      }
    }
    return true;
  }


}
