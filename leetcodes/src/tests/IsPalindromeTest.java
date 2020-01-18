package tests;

public class IsPalindromeTest {

//    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//    说明：本题中，我们将空字符串定义为有效的回文串。
//    回文：数字或者字符串具有首尾回环性质，从后向前按位颠倒后与原文一样。如数字12321是回文数，字符串 abcba 也是回文，叫回文字符串。


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


    public static void main(String[] args) {

        IsPalindromeTest isPalindromeTest = new IsPalindromeTest();

        String s =  "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeTest.isPalindrome(s));
    }
}
