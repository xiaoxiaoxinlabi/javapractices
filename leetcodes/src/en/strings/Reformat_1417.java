package en.strings;

public class Reformat_1417 {

//  给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
//  请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
//  请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。


//    Example 1:
//
//    Input: s = "a0b1c2"
//    Output: "0a1b2c"
//    Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
//    Example 2:
//
//    Input: s = "leetcode"
//    Output: ""
//    Explanation: "leetcode" has only characters so we cannot separate them by digits.



    public String reformat(String s) {
        int letterc = 0, numc = 0;
        for(char c: s.toCharArray()){
            if(c >= '0' && c <= '9'){
                numc++;
            }else{
                letterc++;
            }
        }

//        如果字符数量和数字数量相差大，则直接返回空
        if(Math.abs(numc - letterc) > 1){
            return "";
        }
        char [] res = new char[s.length()];
//        定义两个变量, 根据字符,数字的数量的多少确定固定索引处所存放的值
        int p = 0, q = 1;
//         那个个数多，则那个从零开始
        if(letterc > numc){
            p = 1; q = 0;
        }
        for(char c : s.toCharArray()){
//            如果是数字，则将p当做索引，进行存放，然后p+2
            if(c >= '0' && c <= '9'){
                res[p] = c;
                p+=2;
//                如果是字母，则q当做索引
            }else{
                res[q] = c; q+=2;
            }
        }
        return String.valueOf(res);

    }
}
