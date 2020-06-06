public class IsPalindrome_125 {

//
//    说明：本题中，我们将空字符串定义为有效的回文串。
//    回文：数字或者字符串具有首尾回环性质，从后向前按位颠倒后与原文一样。如数字12321是回文数，字符串 abcba 也是回文，叫回文字符串。
//    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//    说明：本题中，我们将空字符串定义为有效的回文串。

//    示例 1:
//
//    输入: "A man, a plan, a canal: Panama"
//    输出: true

//    方法一：

    public boolean isPalindrome(String s) {

//        将字符串转换为字符数组
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i <= j) {

//            如果不是字母或者数字，则跳过index（i）的位置上的字符,改位置上的字符不参与比较

            while (i <= j && !Character.isLetterOrDigit(ch[i])) {
                i++;
            }

//            如果不是字母或者数字，则跳过index（j）的位置上的字符，改位置上的字符不参与比较
            while (i <= j && !Character.isLetterOrDigit(ch[j])) {
                j--;
            }
            if (i <= j) {

//                如果忽略大小写后 ch[i] != ch[j] ，则不是回文
                if (Character.toLowerCase(ch[i]) != Character.toLowerCase(ch[j])) {
                    return false;
                }

                i++;
                j--;

            }

        }

        return true;

    }


    public boolean isPalindrome1(String s){

        int count = 0;

        for(int i = 0; i < s.length()/ 2; i ++){

            if(s.charAt(i) == s.charAt(s.length() - i - 1)){

                count++;

            }else{

                return false;
            }

        }

        if(count == s.length() / 2){
            return true;
        }

        return false;




    }

//    输入：字符串
//    返回： 回文true，  非回文false
//    如 "abcba" "abccba" 都属于回文

    public static boolean isPalindrome2(String s){

        s = s.toLowerCase();
        char [] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while(i <=j){
            if((chars[i] >= '0' && chars[i] <='9') ||(chars[i] >='a' && chars[i] <='z')){
                if((chars[j] >='0' && chars[j] <='9') || (chars[j] >='a' && chars[j] <='z')){
                    if(chars[i]!=chars[j]){
                        return false;
                    }else{
                        i++;
                        j--;
                    }
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return true;
    }

//    双指针法
    public static boolean isPalindrome3(String s){
        int i = 0, j = s.length() -1;
        while(i < j){
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {

        IsPalindrome_125 isPalindromeTest = new IsPalindrome_125();

        String s =  "abcba";
        System.out.println(isPalindromeTest.isPalindrome1(s));
    }
}
