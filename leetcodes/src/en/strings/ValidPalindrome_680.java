package en.strings;

public class ValidPalindrome_680 {

//    给定一个非空字符串s，您最多可以删除一个字符。判断是否可以使它回文
//    Example 1:
//    Input: "aba"
//    Output: True
//    Example 2:
//    Input: "abca"
//    Output: True
//    Explanation: You could delete the character 'c'.

    public boolean validPalindrome1(String s){
        int flag = 0;

        for(int i = 0; i <= s.length()/2; i ++){
            int j = s.length() - 1 - i;
            if(s.charAt(i) == s.charAt(j)){
                continue;
            }else if(flag == 0){
                flag = 1;
                return validPalindrome1(s.substring(i+1,j+1)) || validPalindrome1(s.substring(i,j));
            }else if(flag == 1){
                return false;
            }
        }
        return true;

    }

    public boolean validPalindrome2(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isp(s, i+1, j) || isp(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isp(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }


}

