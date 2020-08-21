package en.strings;

public class MaxPower_1446 {
//  给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空连续的子字符串的长度。
//  请你返回字符串的能量。

//    Example 1:
//
//    Input: s = "leetcode"
//    Output: 2
//    Explanation: The substring "ee" is of length 2 with the character 'e' only.
//            Example 2:
//
//    Input: s = "abbcccddddeeeeedcba"
//    Output: 5
//    Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

    public int maxPower(String s) {

        int count = 1;
        int max = 1;
        for(int i = 1; i < s.length(); i ++){

            if(s.charAt(i) == s.charAt(i-1)){
                count++;
                max = Math.max(max, count);
            }else{
                count = 1;
            }
        }


        return max ;

    }
}
