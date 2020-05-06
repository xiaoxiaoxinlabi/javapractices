import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MeituanTest01 {

//  找出字符串中的数字，去重之后，并降序排列


  public static void fun1(String s){


    Set set = new HashSet<>();

    int [] res = new int [s.length()];
    StringBuilder sb = new StringBuilder();



    for(int i = 0; i < s.length(); i ++){

      if(Character.isDigit(s.charAt(i)) && set.add(s.charAt(i))){

        sb.append(s.charAt(i));

      }else {
        continue;
      }

    }

    Arrays.sort(sb.toString().toCharArray());

  }

}
