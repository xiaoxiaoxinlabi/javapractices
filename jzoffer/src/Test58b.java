public class Test58b {
//  左旋转字符串
//  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

//  输入: s = "abcdefg", k = 2
//  输出: "cdefgab"


//  方法一：利用切割法
//  应用字符串切片函数，可方便实现左旋转字符串。
//  获取字符串 s[n:]s[n:] 切片和 s[:n]s[:n] 切片，使用 "++" 运算符拼接并返回即可。


  public String reverseLeftWords1(String s , int n){
    return s.substring(n, s.length()) + s.substring(0,n);

  }

//  方法二：列表遍历拼接
//若面试规定不允许使用 切片函数 ，则使用此方法

  public String reverseLeftWords2(String s, int n){
    StringBuilder sb = new StringBuilder();
    for(int i = n; i < s.length(); i++){
      sb.append(s.charAt(i));
    }

    for(int i = 0; i < n; i++){
      sb.append(s.charAt(i));
    }

    return sb.toString();

  }


//  方法三：利用求余运算，可以简化代码。

  public String reverseLeftWords3(String s, int n){
    StringBuilder sb = new StringBuilder();
    for(int i = n; i<n+s.length(); i++){
      sb.append(s.charAt(i % s.length()));
    }
    return sb.toString();

  }



//  方法四：字符串遍历拼接

public String reverseLeftWords4(String s, int n){
    String res=" ";
    for(int i =n; i<s.length(); i ++){
      res+=s.charAt(i);
    }

    for(int i = 0; i < n; i++){
      res+=s.charAt(i);
    }
    return res;
}

}
