package en.strings;

public class RemovePalindromeSub_1332 {
//
//    给定仅由字母“ a”和“ b”组成的字符串s。您只需一步即可从中删除一个回文子序列。
//    返回使给定字符串为空的最小步骤数。
//    字符串是给定字符串的子序列，如果它是通过删除给定字符串的某些字符而不改变其顺序而生成的。
//    如果一个字符串向后和向前读取相同，则称为回文。
//    return 0, when s is empty
//return 1, when s is a palindrome
//return 2, when s is not a palindrome, i.e step 1- remove all 'a', step 2- remove all 'b', and now s is empty

    public int removePalindromeSub(String s) {

        if(s.length() == 0){
            return 0;
        }
        int i = 0, j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return 2;
            }else{
                i++;
                j--;
            }
        }
        return 1;

    }

    public int removePalindromeSub1(String s){
        if(s == null || s.length() == 0){
            return 0;
        }else if(isPalindfomic(s)){
            return 1;
        }else
            return 2;
    }
    private boolean isPalindfomic(String s){
        int i = 0, j = s.length()-1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public int removePalindromeSub2(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean isPalindrome = true;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome ? 1:2;
    }
}
