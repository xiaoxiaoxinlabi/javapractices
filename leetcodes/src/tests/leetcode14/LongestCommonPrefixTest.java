package tests.leetcode14;

public class LongestCommonPrefixTest {
//    Write a function to find the longest common prefix string amongst an array of strings.
//    If there is no common prefix, return an empty string ""
//    All given inputs are in lowercase letters a-z.

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;

    }

//    public String longestCommonPrefix1(String strs []){
//        if (strs.length == 0)return "";
//
//        for (int i = 0; i < strs[0].length(); i ++){
//            char c = strs[0].charAt(i);
//            for(int j = 1; j < strs.length; j ++){
//                System.out.println();
//                if (i == strs[j].length() || strs[j].charAt(i) != c){
//                    return strs[0].substring(0,i);
//                }
//            }
//        }
//
//    }

    public static void main(String [] args){

        LongestCommonPrefixTest l = new LongestCommonPrefixTest();
        String s [] =  {"fldesd","fld","fldoight"};
        String s1 [] = {"dog","racecar","car"};
        System.out.println(l.longestCommonPrefix(s));
        String ss = "fld";
        System.out.println(ss.indexOf("fldo"));


    }
}
