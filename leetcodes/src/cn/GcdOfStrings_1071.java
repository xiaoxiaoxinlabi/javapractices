public class GcdOfStrings_1071 {

//  字符串的最大公因子
//  对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
//  返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
//  示例 1：
//  输入：str1 = "ABCABC", str2 = "ABC"
//  输出："ABC"


  public  String gcdOfStrings(String str1, String str2){
    // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
//    、若s1和s2存在相同的除数X，即s1=XXX, s2=XX, 可见s1+s2=s2+s1
    if(!(str1 + str2).equals(str2 + str1)){
      return "";
    }
    // 辗转相除法求gcd。
    return str1.substring(0, gcd(str1.length(), str2.length()));
  }



  private int gcd(int a, int b){
    return b == 0?a: gcd(b, a % b);
  }


}
