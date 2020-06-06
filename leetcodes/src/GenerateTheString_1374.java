public class GenerateTheString_1374 {
//  生成每种字符都是奇数个的字符串
//给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
//  返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。

//  示例 1：
//  输入：n = 4
//  输出："pppz"
//  解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。


//  相当于是判断n是奇数还是偶数。
  public static String generateTheString(int n){

    StringBuilder res = new StringBuilder();
    if(n == 0){
      return null;
    }
    if(n % 2 == 0){
      for(int i = 0; i < n -1;i ++){
        res.append('a');
      }
      res.append('b');
    }else{
      res.append('a');
    }

    return res.toString();
  }


}
