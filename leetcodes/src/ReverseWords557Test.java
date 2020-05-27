public class ReverseWords557Test {

//  557. 反转字符串中的单词 III
//  给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//  输入: "Let's take LeetCode contest"
//  输出: "s'teL ekat edoCteeL tsetnoc"

//  方法 1：简单的解法 [Accepted]

public static void  reverseWords1(String s){

  String [] newStr = s.split(" ");

  String res = "";

  for(int i = 0; i < newStr.length; i ++){

    res+=  new StringBuilder (newStr[i]).reverse().toString()+ " " ;

  }

  res.trim();

  System.out.println("res: "+ res);


}


public static void reverseWords2(String s){

  StringBuilder res = new StringBuilder();
//  创建临时字符串 wordword 保存单词，我们在遍历过程中将字符逐一连接在 wordword 后面，
  StringBuilder world = new StringBuilder();
  for(int i = 0; i < s.length(); i++){
//    当我们遇到 ' ' 字符时，我们将 wordword 反转后连接在结果字符串 resultresult 后面
    if(s.charAt(i) != ' '){
      world.append(s.charAt(i));

    }else{
      res.append(world.reverse());
      res.append(" ");
      world.setLength(0);
    }
  }
  res.append(world.reverse());
  System.out.println(res.toString());

}




  public static void main(String [] args){

  reverseWords2("Let's take LeetCode contest");


  }



}
