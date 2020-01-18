package tests;

public class PalindromeTest {

//    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

    public boolean isPalindrome(int x) {

        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String temp = sb.reverse().toString();
        if (String.valueOf(x).equals(temp)) {
            return true;
        }

        return false;

    }

    public boolean isPalindrome1(int x) {

        if (x < 0 || (x / 10 == 0 && x != 0)) {
            return false;
        }
        int sum = 0;
        while (x > sum) {
            sum = sum * 10 + x % 10;
            x /= 10;

        }

        return x == sum || x == sum / 10;


    }

    public static void main(String args[]) {

        PalindromeTest p = new PalindromeTest();
        //System.out.println(p.isPalindrome(121));
        System.out.println(p.isPalindrome1(121));


    }
}
