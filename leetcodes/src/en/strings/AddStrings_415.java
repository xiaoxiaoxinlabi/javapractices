package en.strings;

import java.math.BigInteger;

public class AddStrings_415 {
//    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//    给定两个表示为字符串的非负整数num1和num2，返回num1和num2之和。
    public String addStrings(String num1, String num2){
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger res = a.add(b);
        return res.toString();
    }
}
