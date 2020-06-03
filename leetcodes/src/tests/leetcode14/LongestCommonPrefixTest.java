package tests.leetcode14;

public class LongestCommonPrefixTest {
//    Write a function to find the longest common prefix string amongst an array of strings.
//    If there is no common prefix, return an empty string ""
//    All given inputs are in lowercase letters a-z.

//    编写一个函数来查找字符串数组中的最长公共前缀。
//    如果不存在公共前缀，返回空字符串 ""。
//    示例 1:
//    输入: ["flower","flow","flight"]
//    输出: "fl"

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

//        将数组的第一个字符串当做最长前缀
        String prefix = strs[0];
//        循环遍历数组
        for (int i = 1; i < strs.length; i++) {

//            当前字符串中的字符不包含前缀时
            while (strs[i].indexOf(prefix) != 0) {
//                前缀开始缩小
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;

    }

    public String longestCommonPrefix1(String strs []){
        if (strs.length == 0)return "";

//        令最长公共前缀 的值为数组中的第一个字符串，然后针对第一个字符串进行截取
        for (int i = 0; i < strs[0].length(); i ++){
            char c = strs[0].charAt(i);
//            循环遍历数组中的每个值
            for(int j = 1; j < strs.length; j ++){

//                如果遇到值遍历结束，或者值中的某个字符不等于当前比较的值，则停止
                if (i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return "";

    }

//    链表
//    当字符串数组长度为 0 时则公共前缀为空，直接返回
//令最长公共前缀 ans 的值为第一个字符串，进行初始化

    public static String longestCommonPrefix2(String [] strs){

        if(strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for(int i = 1; i < strs.length; i ++){
            int j = 0;
            for(; j < ans.length() && j < strs[i].length(); j++){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if(ans.equals("")){
                return ans;
            }

        }
        return ans;

    }


    public static void main(String [] args){

        LongestCommonPrefixTest l = new LongestCommonPrefixTest();
        String s [] =  {"fldesd","fld","fldoight"};
        String s1 [] = {"dog","racecar","car"};
        System.out.println(l.longestCommonPrefix1(s));
        String ss = "fld";
        System.out.println("====" + ss.indexOf("fldo"));


    }
}
