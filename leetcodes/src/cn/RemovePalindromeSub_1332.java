public class RemovePalindromeSub_1332 {
//
//  删除回文子序列
//  给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。返回删除给定字符串中所有字符（字符串为空）的最小删除次数

//「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
//  回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。

//  示例 1：
//
//  输入：s = "ababa"
//  输出：1
//  解释：字符串本身就是回文序列，只需要删除一次。

//  解题思路
//      判断字符串本身是否是回文字符
//    如果是，则只需一次，否则需要两次

  public int removePalindromeSub1(String s){

    if(s.length() == 0){
      return 0;
    }
    char [] chars = s.toCharArray();
    boolean ispalindrome = true;
    for(int i = 0; i < chars.length/2; i ++){
      if(chars[i] !=chars[chars.length - i - 1]){
        ispalindrome = false;
        break;
      }
    }

    return ispalindrome ? 1: 2;
  }

}
