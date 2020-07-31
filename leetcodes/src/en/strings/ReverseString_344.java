package en.strings;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString_344 {
//    编写一个反转字符串的函数。输入字符串作为字符数组char []给出。
//    不要为另一个数组分配额外的空间，必须通过使用O（1）额外的内存就地修改输入数组来做到这一点。
//    您可以假定所有字符都由可打印的ASCII字符组成。

    public void reverseString(char [] s){
       int i = 0, j = s.length-1;
       while(i < j){

           char c = s[i];
           s[i] = s[j];
           s[j] = c;

           i++;
           j--;

       }
    }

    public void reverseString1(char [] s){


//    变量定义在外边，需要的时间更少
        char temp;
        int i = 0, j = s.length-1;
        while(i <= j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void reverseString2(char [] s){

      for(int i = 0; i < s.length/2; i ++){
          char lef = s[i];
          s[i] = s[s.length-1-i];
          s[s.length-1-i] = lef;
      }
    }

//    用栈先进后出的原理
    public static void reverseString3(char [] s){

        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length; i ++){
            stack.push(s[i]);
        }
        for(int i = 0; i < s.length; i ++){
            s[i] = stack.pop();
        }

        System.out.println(Arrays.toString(s));

    }



    public static void main(String [] args){
        char c [] = {'h','e','l','l','o'};
        reverseString3(c);
    }
}
