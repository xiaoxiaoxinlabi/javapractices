import java.util.HashMap;
import java.util.Map;

public class Test07 {

//  题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。

  public static void fun1(String s){

    int enNum = 0, spaceNum = 0, digNum = 0, otherNum = 0;

    for(int i = 0; i < s.length(); i ++){

      if(Character.isLetter(s.charAt(i))){
        digNum ++;
      }else if(Character.isSpaceChar(s.charAt(i))){
        spaceNum++;
      }else if(Character.isDigit(s.charAt(i))){
        digNum++;
      }else{
        otherNum++;
      }

    }

  }

}
