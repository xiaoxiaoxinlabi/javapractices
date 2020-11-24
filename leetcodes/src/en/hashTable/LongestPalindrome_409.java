package en.hashTable;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {

//    给定一个由小写或大写字母组成的字符串s，返回可以用这些字母建立的最长回文的长度。
//    字母区分大小写，例如，“ Aa”在这里不被视为回文。
//    Example 1:
//    Input: s = "abccccdd"
//    Output: 7
//    Explanation:
//    One longest palindrome that can be built is "dccaccd", whose length is 7.
//    Example 2:
//
//    Input: s = "a"
//    Output: 1

    public int longestPalindrome(String s) {

        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int len = 0;
        for(Integer res : map.values()){
            len +=res / 2;

        }
        len = len * 2;

        return  len < s.length() ? len + 1 : len;
    }

    public int longestPalindrome1(String s){
        int [] arr = new int[256];
        int n = s.length();
        for(int i = 0; i < n; i ++){
            int index = (int)s.charAt(i);
            arr[index]++;
        }
        int count = 0;
        int odd_max = 0;
        int odd_max_char = 0;

        for(int i = 0; i < 256; i ++){
            if(arr[i] % 2 == 1){
                if(arr[i] > odd_max){
                    odd_max = arr[i];
                    odd_max_char = i;
                }
            }else {
                count += arr[i];
            }
        }
        for(int i = 0; i < 256; i ++){
            if(arr[i] % 2 ==1 && i != odd_max_char){
                count += arr[i] - 1;
            }

        }
        return count + odd_max;
    }

    public int longestPalindrome2(String s){
        if(s.length() == 1){
            return 1;
        }
        int [] a = new int[58];
        int x = 0;
        for(char c : s.toCharArray()){
            a[c - 'A']++;
        }
        int count = 0;
        for(int d: a){
            count += d / 2;
            if(x == 0 && d % 2 != 0){
                x = 1;
            }
        }
        return count * 2 + x;
    }

    public int longestPalindrome3(String s){
        int [] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        int len = 0;
        for(int char_count : count){
            len += char_count / 2 * 2;

            if(len % 2 == 0 && char_count % 2 ==1){
                len++;
            }
        }
        return len;
    }

    public int longestPalindrome4(String s){
        int [] count = new int[128];
        int ans = 0;
//        this is needed to include odd frequency character only once.
        boolean oddIncluded = false;
        for(char ch : s.toCharArray()){
            count[ch]++;
        }
        for(int i = 0; i < count.length; i ++){
            if(count[i] == 0){
                continue;
            }
            if(count[i] % 2 == 0){
                ans += count[i];
            }else{
                if(!oddIncluded){
                    ans +=count[i];
                    oddIncluded = true;
                }else{
                    ans += count[i] - 1;
                }
            }
        }
        return ans;
    }


}
