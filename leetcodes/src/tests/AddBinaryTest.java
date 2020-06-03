package tests;

import java.math.BigInteger;

public class AddBinaryTest {

    public String addBinary(String a, String b) {

        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        String sum = x.add(y).toString(2);
        return sum;
    }

//    这是一种古老的经典算法，无需把数字转换成十进制，直接逐位计算和与进位即可。

    //    通过ASCII转换来实现;字符串需要先转码
//    初始进位 carry=0，如果数字 aa 的最低位是 1，则将 1 加到进位 carry；同理如果数字 bb 的最低位是 1，则也将 1 加到进位。此时最低位有三种情况：(00)_2(01),3(10)

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
//            然后将 carrycarry 的最低位作为最低位的值，将 carrycarry 的最高位移至下一位继续计算。
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