public class CountSegmentsTest434 {

//  434. 字符串中的单词数
//  统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//  请注意，你可以假定字符串里不包括任何不可打印的字符。

//  输入: "Hello, my name is John"
//  输出: 5
//  解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。

  public static int countSegments1(String s){
    int count = 0;

    for(int i = 0; i < s.trim().length(); i ++){
      if((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) !=' '){
        count++;
      }
    }

    return count;

  }

  public static int countSegments2(String s){

    if(s.trim().equals(" ")){
      return 0;
    }
    return s.trim().split(" ").length;

  }


  public static int countSegments3(String s){
    if(s == null || s.length() == 0){

      return 0;

    }
    int res = 0;
    int temp = 0;
    for(int i = 0; i < s.length(); i ++){
      char c = s.charAt(i);
//      一次遍历,当遍历到的字符不是空格时,temp加1
      if(c != ' '){
        temp++;
//        当遍历到最后一个字符不是空格时,结果加1;
        if(i == s.length() - 1){
          res++;
        }
//        当遍历到的字符是空格并且temp大于0的时候结果加1
      }else if(c == ' ' && temp > 0){
        res++;
        temp = 0;
      }
    }
    return res;
  }


  public static void main(String [] args){
    System.out.println(countSegments1("Hello, my name is John"));

  }

}
