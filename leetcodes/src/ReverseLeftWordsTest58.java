public class ReverseLeftWordsTest58 {

//  左旋转字符串
//  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
//  示例 1：
//
//  输入: s = "abcdefg", k = 2
//  输出: "cdefgab"


//  方法一：字符串切片
//时间复杂度 O(N)O(N) ： 其中 NN 为字符串 ss 的长度，字符串切片函数为线性时间复杂度（参考资料）；
//  空间复杂度 O(N)O(N) ： 两个字符串切片的总长度为 NN 。

  public static String reverseLeftWords1(String s, int n){

    int len = s.length();

    if(len < n){
      return s;
    }

    s = s.substring(n , s.length()) + s.substring(0, n);
    return s;

  }

//  方法二：列表遍历拼接

  public static String reverseLeftWords2(String s, int n){
    StringBuilder res = new StringBuilder();
    for(int i = n; i < s.length(); i++){
      res.append(s.charAt(i));
    }

    for(int i = 0; i <n; i ++){
      res.append(s.charAt(i));
    }
    return res.toString();
  }


  //  方法三：求余

  public static String reverseLeftWords3(String s, int n){
    StringBuilder res = new StringBuilder();
    for(int i = n; i < n+s.length(); i ++){
      res.append(s.charAt(i % s.length()));
    }
    return res.toString();

  }

//  方法四：字符串遍历拼接

  public static String reverseLeftWords4(String s, int n){
    String res = " ";
    for(int i = n; i < s.length(); i ++){
      res+=s.charAt(i);

    }
    for(int i = 0; i < n; i++){
      res+=s.charAt(i);
    }

    return res;
  }
}
