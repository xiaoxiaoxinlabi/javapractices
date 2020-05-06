import java.util.Arrays;

public class Test25 {
//  题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。

  public static void fun(int n){

    String s = String.valueOf(n);
    for(int i = 0; i < s.length() / 2; i ++){
      if(s.charAt(i) == s.charAt(s.length()/2 -i -1)){
        System.out.println("ok");
      }
    }


  }
//  https://blog.csdn.net/YaoChung/article/details/80793691


}
