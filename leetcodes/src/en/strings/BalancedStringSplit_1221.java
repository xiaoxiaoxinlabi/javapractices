package en.strings;

import java.util.Stack;

public class BalancedStringSplit_1221 {

//    平衡的字符串是指具有相等数量的“ L”和“ R”字符的字符串。
//    给定一个平衡字符串s，将其拆分为最大数量的平衡字符串。
//    返回拆分后的平衡字符串的最大数量。

//    Input: s = "RLRRLLRLRL"
//    Output: 4
//    Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

    public int balancedStringSplit(String s) {

       int c1 = 0;
       int num = 0;

        for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == 'L'){
               c1 ++;
           }else if(s.charAt(i) == 'R'){
               c1--;
           }
            if(c1 == 0){
                num++;
            }
        }

        return num;

    }

    public int balancedStringSplit1(String s){
        Stack<Character> stack = new Stack();
        int sum = 0;
        for(char c : s.toCharArray()){
//            如果栈为空，或者当前元素等于栈顶元素，则将其添加到栈中
            if(stack.isEmpty() || c == stack.peek()){
                stack.push(c);
                continue;
            }
//            将栈顶元素弹出
            stack.pop();
//            如果栈为空，则sum++
            if(stack.isEmpty()){
                sum++;
            }
        }
        return sum;

    }

//    分别统计L，R 出现的次数，当两个都相等时，则说明出现一个平衡字符串
    public int balancedStringSplit2(String s){
        char [] arr = s.toCharArray();
        int stackRcount = 0;
        int stackLcount = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == 'R'){
                stackRcount++;
            }else if(arr[i] == 'L'){
                stackLcount++;
            }
            if(stackLcount == stackRcount && stackLcount > 0){
                count++;
                stackLcount = 0;
                stackRcount = 0;
            }
        }
        return count;
    }

}
