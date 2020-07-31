import java.util.Stack;

public class Reformat_1417 {

//  给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
//  请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
//  请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。

//  示例 1：
//  输入：s = "a0b1c2"
//  输出："0a1b2c"
//  解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。

//  定义两个变量，对数字字符和字母字符计数，如果数量相差2及以上，直接溜溜球（你呵护不了我，我也呵护不了你，直接music“可惜不是你”）
//  为了节省空间计数的两个变量拿来复用，哪个数大，哪个从零开始，每次加2，自己走自己的，互不干涉
//  .通过num1和num2双指针，将字符放入到字符数组中，返回字符串
  public String reformat1(String s){
    int num1 = 0, num2 = 0;
    char [] chars = s.toCharArray();
    for(char  c: chars){
      if(c>='0' && c <='9'){
//        统计数字的个数
        num1++;
      }else{
//        统计字符串的个数
        num2++;
      }
    }
//看数字字符比较多还是字母字符比较多
    if(num1 - num2 < -1 || num1 - num2 >1 ){
      return "";
    }
//    那个个数多，则那个从零开始
    if(num1 > num2){
      num1 = 0; num2 = 1;
    }else{
      num1 = 1; num2 = 0;
    }

    for(char c: s.toCharArray()){
//      如果是数字，则将num1 作为索引存放字符，然后num1 按照奇数增加
      if(c >='0' && c <='9'){
        chars[num1] = c;
        num1+=2;
      }else{
//        如果是字母则同理
        chars[num2] = c;
        num2+=2;
      }
    }
//    将字符数组以字符串的形式返回
    return new String(chars);


  }

//1.先把字母和数字分开，分别放入stack中
//  2.要拼接成功，必须两个相减绝对值小于1，否则返回"";
//  3.拼接过程中是先放字母还是数字，取决于判断两个stack大小（谁大谁先放，我做了判断，让大的保持先遍历）
  public String reformat2(String s){
    Stack<Character> stackaz = new Stack();
    Stack<Character> stack09 = new Stack<>();
    Stack<Character> temp = new Stack();
    String res = "";
    for(char c: s.toCharArray()){
      if(c >='0' && c <='9'){
        stack09.add(c);
      }else{
        stackaz.add(c);
      }
    }
//    要拼接成功，必须两个相减绝对值小于1，否则返回"";
    if(Math.abs(stack09.size() - stackaz.size()) > 1){
      return  res;
    }
    if(stack09.size() > stackaz.size()){
      temp = stack09;
      stack09 = stackaz;
      stackaz = temp;
    }
//    3.拼接过程中是先放字母还是数字，取决于判断两个stack大小（谁大谁先放，我做了判断，让大的保持先遍历）
    for(stackaz.size() ; stackaz.size()>0;){
      res+=res+String.valueOf(stackaz.pop());
      if(stack09.empty()){
        continue;
      }else{
        res+=res + String.valueOf(stack09.pop());
      }

    }
    return res;
  }



}
