package en.strings;

import java.util.Stack;

public class MakeGood_1544 {

//    给定的字符串由大小写字母组成
//    好的字符串是没有两个相邻字符s [i]和s [i + 1]的字符串，其中：
//
//            0 <= i <= s.length - 2
//            s [i]是小写字母，而s [i + 1]是相同字母，但大写字母，反之亦然。
//    为了使字符串变好，可以选择使字符串变坏的两个相邻字符并将其删除。您可以继续这样做，直到字符串变好为止。
//    改好后返回字符串。在给定的约束下，保证答案是唯一的。

//    Example 1:
//
//    Input: s = "leEeetcode"
//    Output: "leetcode"
//    Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
//    Example 2:
//
//    Input: s = "abBAcC"
//    Output: ""
//    Explanation: We have many possible scenarios, and all lead to the same answer. For example:
//            "abBAcC" --> "aAcC" --> "cC" --> ""
//            "abBAcC" --> "abBA" --> "aA" --> ""


    public String makeGood(String s) {

        Stack<Character> googleElements = new Stack();
        for(Character c : s.toCharArray()){
//            如果当前元素与栈顶元素相差32，则将其弹出，并删除
            if(!googleElements.isEmpty() && Math.abs(googleElements.peek() - c) == 32){
                googleElements.pop();
            }else{
//                否则将其添加到栈中
                googleElements.push(c);
            }
        }
//        将栈中的元素append到StringBuilder中，返回
        StringBuilder res = new StringBuilder();
        for(char c : googleElements){
            res.append(c);
        }
        return res.toString();

    }

    public String makeGood1(String s){
        StringBuilder res = new StringBuilder();

//        遍历字符串，通过当前元素与添加到StringBuilder中的最后的元素进行对比，如果两者相差32，则说明是需要被删除的，则将
//        StrinbBuilder.append() 添加的元素最新的都在最后
        for(int i = 0; i < s.length(); i ++){

            if(res.length() > 0 && Math.abs(s.charAt(i) - res.charAt(res.length()-1))==32){
//                res.setLength(res.length()-1);
                res.deleteCharAt(res.length()-1);
            }else{
//                否则将其添加到res中
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
