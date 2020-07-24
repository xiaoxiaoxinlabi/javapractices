public class ValidPalindrome_680 {

//  给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//  示例 1:
//
//  输入: "aba"
//  输出: True

//  示例 2:
//
//  输入: "abca"
//  输出: True
//  解释: 你可以删除c字符。

//  方法一：贪心算法


  public boolean validPalindrome1(String s){
    int low = 0 , high = s.length() - 1;
//    首先判断原串是否是回文串，如果是，就返回 true
    while(low < high){
      char c1= s.charAt(low), c2 = s.charAt(high);
      if(c1==c2){
        low++;
        high--;
      }else{
        boolean flag1=true, flag2 = true;
//       如果不相等，则缩小右边界
        for(int i = low, j = high - 1; i <j; i++,j--){
          char c3 = s.charAt(i), c4 = s.charAt( j);

          if(c3 !=c4){
            flag1 = false;
            break;
          }
        }

//        如果不相等，则缩小左边界
        for(int i = low+1, j = high; i < j; i++,j--){
          char c3 = s.charAt(i), c4=s.charAt(j);
          if(c3!=c4){
            flag2=false;
            break;
          }
        }

        return flag1 || flag2;
      }
    }
    return true;

  }

}
