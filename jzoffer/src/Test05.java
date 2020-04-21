

public class Test05 {
//  替换空格
//  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。


  public String replaceSpace1(String s){

    StringBuilder sb = new StringBuilder();

    for(Character c : s.toCharArray()){
      if(c == ' '){
        sb.append("%20");
      }else{
        sb.append(c);
      }
    }

    return sb.toString();

  }

  public String replaceSpace2(String s){
    s.replaceAll(" ", "%20");

    return s;
  }

//  字符数组
//  由于每次替换从 1 个字符变成 3 个字符，使用字符数组可方便地进行替换。建立字符数组地长度为 s 的长度的 3 倍，这样可保证字符数组可以容纳所有替换后的字符。


  public String replaceSpace3(String s){
    int length = s.length();
    char [] array = new char[length * 3];
    int size = 0;
    for(int i = 0; i < length; i ++){
      char c = s.charAt(i);
      if(c == ' '){
        array[size++] = '%';
        array[size++] = '2';
        array[size++] = '0';
      }else{
        array[size++] = c;
      }
    }
//    遍历结束之后，size 的值等于替换后的字符串的长度，从 array 的前 size 个字符创建新字符串，并返回新字符串

    String newStr = new String(array, 0, size);
    return newStr;
  }



}
