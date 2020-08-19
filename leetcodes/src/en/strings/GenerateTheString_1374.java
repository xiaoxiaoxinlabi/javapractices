package en.strings;

import java.util.Arrays;

public class GenerateTheString_1374 {

//    给定一个整数n，返回一个包含n个字符的字符串，以使该字符串中的每个字符出现奇数次。
//    返回的字符串只能包含小写英文字母。如果有多个有效字符串，则返回其中任何一个。

    public String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++){
            res.append("a");
        }
        if(n % 2 == 0){
            res.setCharAt(0,'b');
        }
        return res.toString();


    }

    public String generateTheString1(int n){
      char [] arr = new char[n];
      for(int i = 0; i <= n; i++){
          arr[i] = 'a';
      }
      if(n % 2 == 0){
          arr[n-1]='b';
      }
      return new String(arr);
    }

}
