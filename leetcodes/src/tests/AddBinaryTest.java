package tests;

import java.math.BigInteger;

public class AddBinaryTest {

    public String addBinary(String a, String b) {

        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        String sum = x.add(y).toString(2);
        return sum;
    }


    //    通过ASCII转换来实现;字符串需要先转码
    public String addBinary1(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carray = 0;

        while (i >= 0 || j >= 0 || carray == 1) {

            char c = a.charAt(i);
            System.out.println(c);
            int ca = i >= 0 ? a.charAt(i) - '0' : 0;
            int cb = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = (ca + cb + carray) % 2;
            carray = (ca + cb + carray) / 2;
            sb.append(sum);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {

        AddBinaryTest addBinaryTest = new AddBinaryTest();
        String a = "111";
        String b = "101";
        String result = addBinaryTest.addBinary1(a, b);

        System.out.println(a.charAt(1));
        System.out.println(result);
    }

}