public class Test58a {

//  翻转单词顺序
//  输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

//  输入: "the sky is blue"
//  输出: "blue is sky the"

  public String reverseWords1(String s){
    char [] newStr = s.toCharArray();

    for(int i = 0; i < newStr.length/2; i ++){
      char temp = newStr[i];
      newStr[i] = newStr[newStr.length-1-i];
      newStr[newStr.length-1-i] = temp;
    }

    return newStr.toString();

  }


//  方法一：双指针

//  倒序遍历字符串
  public String reverseWords2(String s){
//    删除收尾空格
    s = s.trim();
//    记录单词的左右边界
    int j = s.length()-1, i = j;
    StringBuilder sb = new StringBuilder();
    while(i>=0){
//      搜索首个空格
//      没确定一个单词的边界，则将其添加到单词列表res,
      while(i>=0 && s.charAt(i)!=' '){
        i--;
      }
//      添加单词
      sb.append(s.substring(i+1, j+1) +  " ");

//      跳过单词间空格，遇到空格则跳过
      while(i >=0 && s.charAt(i) == ' '){
        i--;
      }
//      指向下个单词的尾字符
      j=i;
    }
//    转换字符串并返回
    return sb.toString().trim();
  }


//  方法二：分割+倒序
  public String reverseWords3(String s){

    String [] strs = s.trim().split(" ");
    StringBuilder sb = new StringBuilder();
    for(int i =strs.length-1; i>=0; i--){
      if(strs[i].equals(" ")){
        continue;
      }
      sb.append(strs[i] + " ");
    }

    return sb.toString().trim();

  }



}
