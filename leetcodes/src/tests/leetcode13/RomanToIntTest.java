package tests.leetcode13;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntTest {

//    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int result = m.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {

            if (m.get(s.charAt(i)) >= m.get(s.charAt(i + 1))) {
                result += m.get(s.charAt(i));
            } else {
                result -= m.get(s.charAt(i));
            }

        }
        return result;
    }

    public int romanToInt1(String s){
        int ans;
        ans = toInt(s.charAt(0));
        for (int i = 1; i < s.length(); i ++){
            ans += toInt(s.charAt(i));
            if(toInt(s.charAt(i - 1)) < toInt(s.charAt(i)))
                ans -= toInt(s.charAt( i- 1)) * 2;
            }
        return ans;
        }



    int toInt(char s){
        switch (s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;

        }
        return 0;
    }

    public static void main(String[] args) {

        String s = "IX";
        RomanToIntTest r = new RomanToIntTest();

        //System.out.println(r.romanToInt(s));
        System.out.println(r.romanToInt1(s));


    }
}
