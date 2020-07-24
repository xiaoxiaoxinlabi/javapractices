
public class ReverseWords_58_1 {

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

public static String reverseWords3(String s){
  // 删除首尾空格
  s = s.trim();
  int j = s.length()-1, i = j;
  StringBuilder res = new StringBuilder();
  while(i >=0){
    // 搜索首个空格
    while(i >=0 && s.charAt(i)!=' '){
      i--;
    }
    res.append(s.substring(i+1, j+1)+"");
// 跳过单词间空格
    while(i >=0 && s.charAt(i) == ' '){
      i--;
    }
    // j 指向下个单词的尾字符
    j = i;
  }
  // 转化为字符串并返回
  return res.toString().trim();

}

public static String reverseWords4(String s){
//  按照空格转换为字符串数组
  String [] str = s.trim().split(" ");
  StringBuilder res = new StringBuilder();
//  倒序遍历
  for(int i = str.length-1; i >=0; i--){
//    如果值为空字符串，则跳过
    if(str[i].equals(" ")){
      continue;
    }

//    将单词拼接至res中
    res.append(str[i] + "");
  }

//  转换为字符串，删除首尾空格
  return res.toString().trim();
}




  public static void main(String [] args){

  reverseWords2("Let's take LeetCode contest");


  }



}
