public class CompressString_0106 {

//  字符串压缩
//  字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
//  示例1:
//
//  输入："aabcccccaaa"
//  输出："a2b1c5a3"
//  示例2:
//  输入："abbccd"
//  输出："abbccd"
//  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。


  public static String compressString1(String s) {
    int N = s.length();
    int i = 0;
    StringBuilder res = new StringBuilder();
    while (i < N) {
      int j = i;
//      用j 计算连续出现的字符的数量
      while (j < N && s.charAt(j) == s.charAt(i)) {
        j++;
      }
//      将字符添加进去
      res.append(s.charAt(i));
//      接着在将字符的数量添加进去
      res.append(j - i);
//      让j 指向i 的位置，计算下一个字符
      i = j;
    }

//    将stringbuilder 转换成 String
    String ans = res.toString();
//    判断转换之后，与转换之前的长度
    if (ans.length() < s.length()) {
      return ans;
    } else {
      return s;
    }
  }

//  循环遍历
  public static String compressString2(String s) {
    if(s.length() == 0 || s.length() <= 2){
      return s;
    }

//    首先将第一个字符存放到builder中
    StringBuilder sb = new StringBuilder().append(s.charAt(0));
//    默认计数为1
    int cnt = 1;
    for (int i = 1; i < s.length(); i++) {
      // 如果i与i-1相同，cnt累加
      if(s.charAt(i) == s.charAt(i - 1)){
        cnt++;
      }else{
        // 否则拼接上i-1的次数，从i开始重新计数
        sb.append(cnt).append(s.charAt(i));
        cnt = 1;
      }


    }
    sb.append(cnt);

    return  s.length() > sb.length() ? sb.toString(): s;

  }

//  双指针法
//  快慢指针

  public static String compressString3(String s){
    int len = s.length();
    if(s.length() == 0 || s.length() <2){
      return s;
    }
    StringBuilder sb = new StringBuilder();
//    左右两个指针
    int left = 0, right = 0;
//    右指针小于长度
    while (right < len){
//      如果右指针不等于左指针，则说明左指针所对应的值没有重复，则添加字符，并且添加出现次数
      if(s.charAt(right)!=s.charAt(left)){
        sb.append(s.charAt(left));
        sb.append((right - left) + "");
//        将左右指针执行同一个字符
        left = right;
//        然后在移动右指针
        right+=left;
      }else{
//        如果相同，则移动右指针（快指针）
        right++;
      }
    }
    //最后一个相同的字符
    sb.append(s.charAt(left));
    sb.append((right - left) + "");

    return s.length() > sb.length() ? sb.toString(): s;

  }

  public static void main(String [] args){

    System.out.println(compressString2("abbccddddd"));

  }

}