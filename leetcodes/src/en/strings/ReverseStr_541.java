package en.strings;

public class ReverseStr_541 {
//    给定一个字符串和一个整数k，您需要从字符串开头算起，每2k个字符反转前k个字符。
//    如果剩余的字符数少于k，则将它们全部反转。
//    如果少于2k但大于或等于k个字符，则反转前k个字符，另一个保留为原始字符。

    public String reverseStr(String s, int k) {
//        如果k 为0 或者1 则返回原字符串
      if(k == 0 || k == 1){
          return s;
      }
      StringBuilder strs = new StringBuilder();
      int limit = 0;
      while(limit < s.length()){
          String str = "";
          if(limit + (2*k) < s.length()){
              str = s.substring(limit, (limit + (2*k)));
          }else{
              str = s.substring(limit, s.length());
              if(str.toString().length() < k){
                  k = str.length();
              }
          }
          strs.append(new StringBuilder(str.substring(0, k)).reverse().toString()).append(str.substring(k, str.length()));
          limit = limit + 2 * k;
      }
      return strs.toString();

    }

    public String reverseStr1(String s, int k){
        StringBuilder str = new StringBuilder();
        int len = 2 * k;
//        如果2k 小于当前字符串长度，翻转前k个
        while(len < s.length()){
            str.append(new StringBuilder(s.substring(len - 2 * k, len - k)).reverse()).append(s.substring(len - k, len));
            len = len + 2 * k;
        }
        if(len - k <= s.length()){
            str.append(new StringBuilder(s.substring(len - 2 * k, len - k)).reverse()).append(s.substring(len - k, s.length()));
        }else{
            str.append(new StringBuilder(s.substring(len - 2 * k, s.length())).reverse());
        }
        return str.toString();

    }
}
