import java.util.Stack;

public class BalancedStringSplit_1221 {
//  分割平衡字符串
//  在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//  给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//  返回可以通过分割得到的平衡字符串的最大数量。

//  示例 1：
//
//  输入：s = "RLRRLLRLRL"
//  输出：4
//  解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。


//  贪心算法
//  利用一个变量num记录'L'('R')的数量，遍历字符串s，如果字符为'L'('R')，则num++，否则num--

//  当num为0时，之前出现的'L'和'R'的数量必定相等，此时将记录子串数量的res++，遍历完后返回res即可
  public static int balancedStringSplit1(String s){

    int num = 0;
    int res = 0;
    for(int i = 0; i < s.length(); i ++){
      if(s.charAt(i) == 'L'){
        num++;
      }else{
        num--;
      }
      if(num == 0){
        res++;
      }
    }

    return res;

  }

//  使用一个栈来实现该功能：
//      1)当栈中没有元素时，当前字符入栈;
//      2)当栈中有元素时，若栈顶字符与当前字符一致，字符入栈，否则栈顶出栈；
//      3)检查当前栈是否为空，若为空则平衡次数+1；

//  pop():大家都返回栈顶的值。pop会把栈顶的值删除
//  peek():大家都返回栈顶的值。peek 不改变栈的值(不删除栈顶的值)

  public static int balancedStringSplit2(String s){
    Stack<Character> stack = new Stack();
    int count = 0;
    for(int i = 0; i < s.length(); i ++){

      char c = s.charAt(i);
//      栈为空，或者当前元素等于栈顶元素，则将该字符加入栈中
      if(stack.isEmpty() || c == stack.peek()){
        stack.push(c);
      }else{
//        否则弹出
        stack.pop();
      }

//      若为空则平衡次数加1
      if(stack.isEmpty()){
        count++;
      }

    }

    return count;

  }

}
