
public class FreqAlphabets_1309 {
//  解码字母到整数映射
//给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符
//  字符（'a' - 'i'）分别用（'1' - '9'）表示。
//  字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
//  输入：s = "10#11#12"
//  输出："jkab"
//  解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".



  public static String freqAlphabets1(String s){

//    1到26个数字，'a'加上这些数字再减一就是 a-z 26个字母
//    将26个字母放到一个数组里
    char [] alphabetChars = new char[27];
//    注意：这里 char 转 int 效率高的方法是 '1' - '0' = 1 ,如果 (int)'1' = 49 是错误的结果
    for(int i = 1; i < alphabetChars.length; i ++){
      alphabetChars[i] = (char)(96+i);
    }

    StringBuilder sb = new StringBuilder();
//    遍历字符串值，
    for(int j = 0; j < s.length(); j++){
//      如果遇到#，则根据#前两位算出对应字母，
      if(j < s.length() - 2 && s.charAt(j + 2) == '#'){
        sb.append(alphabetChars[(s.charAt(j) - '0') * 10 + (s.charAt(j + 1)- '0')]);
        j +=2;
      }else{
//        否则根据当前位算出对应字母
        sb.append(alphabetChars[s.charAt(j) - '0']);
      }
    }

    return sb.toString();


  }

}
