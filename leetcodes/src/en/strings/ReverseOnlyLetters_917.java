package en.strings;

import java.util.Stack;

public class ReverseOnlyLetters_917 {

//    给定字符串S，返回“反转”字符串，"其中所有不是字母的字符都位于同一位置"，并且所有字母都将其位置反转。
//    Input: "ab-cd"
//    Output: "dc-ba"

//    注意：要确保非字符串的位置不变

    public String reverseOnlyLetters1(String S){
        int i = 0, j = S.length() - 1;
        char [] ch = S.toCharArray();
        while(i <= j){
            if(ch[i] >'a' && ch[i] <'z' || ch[i] >'A' && ch[i] <'Z'){
                i++;
            }else if(ch[j] > 'a' && ch[j] < 'z' || ch[j] > 'A'&& ch[j] <'Z'){
                j--;
            }else if(ch[i] != '-' && ch[j] !='-'){
                char c = ch[i];
                ch[i] = ch[j];
                ch[j] = c;
                i++;
                j--;
            }
        }
        return new String(ch);
    }

//    字符比较的时候，尽量与对应的ascii十进制比较，如果直接与字母比较速度比较慢

    public String reverseOnlyLetters(String S){
        int i = 0, j = S.length() - 1;
        char [] ch = S.toCharArray();
        while(i <= j){
            if(ch[i] >32 && ch[i] <65 || ch[i] >90 && ch[i] <97){
                i++;
            }else if(ch[j] > 32 && ch[j] < 65 || ch[j] > 90&& ch[j] <97){
                j--;
            }else if(ch[i] != '-' && ch[j] !='-'){
                char c = ch[i];
                ch[i] = ch[j];
                ch[j] = c;
                i++;
                j--;
            }
        }
        return new String(ch);
    }

    public String reverseOnlyLetters2(String S){
        char [] arr = S.toCharArray();
        Stack<Character> stack = new Stack();
        for(char c: arr){
            if(Character.isLetter(c)){
                stack.push(c);
            }
        }

        for(int i = 0; i < arr.length; i ++){
            if(Character.isLetter(arr[i])){
                arr[i] = stack.pop();
            }
        }
        return new String(arr);
    }
}
