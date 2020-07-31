package en.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseVowels_345 {

//    编写一个将字符串作为输入并仅反转字符串的元音的函数。

//    调换元音字母的顺序
    public String reverseVowels(String s){
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'o' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'U'){
                stack.push(s.charAt(i));
            }
        }
        String s1 = "";
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'o' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'O' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'U'){
                s1=s1+stack.pop();
            }else{
                s1=s1+s.charAt(i);
            }
        }
        return s1;

    }

//    省时间
    public String reverseVowels2(String s){
        char[] temp = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0,j=0;i<s.length();i++){
            char ch = temp[i];

            if( ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'O' || ch == 'I' || ch == 'U'
            ){
                stack.push(ch);
            }

        }

        for(int i=0,j=0;i<s.length();i++){
            char ch = temp[i];

            if( ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u' ||  ch == 'A' || ch == 'E' || ch == 'O' || ch == 'I' || ch == 'U'
            ){
                temp[i] = stack.pop();
            }
        }

        s = String.valueOf(temp);
        return s;
    }
}
