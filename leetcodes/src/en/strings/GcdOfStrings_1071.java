package en.strings;

public class GcdOfStrings_1071 {

//    对于字符串S和T，当且仅当S = T + ... + T（T与自身连接1次或多次）时，才说“ T除以S”
//    返回最大的字符串X，以使X除以str1，X除以str2。
//    即最长的公共子串

//    Example 1:
//
//    Input: str1 = "ABCABC", str2 = "ABC"
//    Output: "ABC"
//    Example 2:
//
//    Input: str1 = "ABABAB", str2 = "ABAB"
//    Output: "AB"
//    Example 3:
//
//    Input: str1 = "LEET", str2 = "CODE"
//    Output: ""

    public String gcdOfStrings(String str1, String str2) {

//        如果str2, 长度大于str1，则交换它们的位置，重新开始
        if(str2.length() > str1.length()){
            return gcdOfStrings(str2, str1);
        }
//        如果字符串2的长度为0 ，则返回字符串1
        if(str2.length() == 0){
            return str1;
        }
//        如果字符串1 是以字符串2开始的
        if(str1.startsWith(str2)){
//            则采用递归的方式遍历
            return gcdOfStrings(str1.substring(str1.indexOf(str2)+str2.length()), str2);
        }
        return "";

    }

    public String gcdOfStrings1(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
//        得到两个长度的最大公约数
        int gcd = gcd(len1,len2);
        String temp = str2.substring(0,gcd);
        for(int i = 0; i < len1; i+=gcd){
            if(!str1.substring(i).startsWith(temp)){
                return "";
            }
        }
        return temp;
    }

//    求最大公约数
    private int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }

}
