package en.strings;

import java.util.HashMap;
import java.util.Map;

public class IsLongPressedName_925 {

    //    您的朋友正在键盘上输入他的名字。有时，在键入字符c时，按键可能会被长按，并且该字符将被键入1次或多次。
//    您检查键盘的键入的字符。如果可能是您的朋友名字，并且长按了某些字符（可能没有字符），则返回True。

//    Input: name = "alex", typed = "aaleex"
//    Output: true
//    Explanation: 'a' and 'e' in 'alex' were long pressed.
//    Example 2:
//
//    Input: name = "saeed", typed = "ssaaedd"
//    Output: false
//    Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

    public boolean isLongPressedName(String name, String typed) {


       if(name.equals(typed)){
           return true;
       }
       if(name.length() > typed.length()){
           return false;
       }
       int i = 0;
       int j = 0;
       int n = name.length();
       int t = typed.length();
       while(j < t){
           if(i < n && name.charAt(i) == typed.charAt(j)){
               i++;
           }else if(j == 0 || typed.charAt(j) != typed.charAt(j-1)){
               return false;
           }
           j++;
       }
       return i == n;



    }

    public boolean isLongPressedName1(String name, String typed){
        if(name.equals(typed)){
            return true;
        }
        if(typed.length() < name.length()){
            return false;
        }
        if(typed.charAt(0) != name.charAt(0)){
            return false;
        }
        boolean returnVal = true;
        int index = 1;
        for(int i = 1; i < typed.length(); i ++){
            if(index <name.length() && typed.charAt(i) == name.charAt(index)){
                index++;
            }else if(typed.charAt(i) == name.charAt(index -1)){
                continue;
            }else{
                returnVal = false;
                break;
            }
        }
        if(index != name.length()){
            return false;
        }
        return returnVal;
    }


}
