public class ToLowerCase709Test {

//709. 转换成小写字母
//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//  输入: "Hello"
//  输出: "hello"

  public static void toLowerCase1(String s){

    String res = "";

    for(int i = 0; i < s.length(); i ++){
      if(Character.isUpperCase(s.charAt(i))){
//        res +=(s.charAt(i) +32);
        res+=Character.toLowerCase(s.charAt(i));
      }else{
        res+=s.charAt(i);
      }
    }
    System.out.println(res.toString());

  }



  public static void toLowerCase2(String s){
    String res = "";
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) >= 'A' && s.charAt(i) <='Z'){
        char temp = s.charAt(i);
        temp+=32;
        res+=temp;
      }else{
        res+=s.charAt(i);
      }
    }

    System.out.println(res);

  }

  public static void main(String [] args){
    toLowerCase1("Hello");
    toLowerCase2("HESSoo");
  }



}
