package en.strings;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AddStrings_415 {
//    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//    给定两个表示为字符串的非负整数num1和num2，返回num1和num2之和。
//
//    The length of both num1 and num2 is < 5100.
//    Both num1 and num2 contains only digits 0-9.
//    Both num1 and num2 does not contain any leading zero.
//    You must not use any built-in BigInteger library or convert the inputs to integer directly.



    public String addStrings(String num1, String num2){
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger res = a.add(b);
        return res.toString();
    }

    public String addStrings1(String num1, String num2){
//        将数字字符串转换成数组
       char [] nums1 = num1.toCharArray();
       char [] nums2 = num2.toCharArray();
       StringBuilder sum = new StringBuilder();
//       定义两个变量分别代表 数字1，数字2 的倒序索引
       int i = num1.length() - 1;
       int j = num2.length() - 1;
//       定义一个进位数
       int carry = 0;

       while(i >= 0 || j >=0 || carry == 1){
//           将数组1，数组2 中每个值转换为数字
           int firstNum = i >=0 ? (nums1[i--] - '0') : 0;
           int secondNum = j >= 0 ? (nums2[j--] - '0') :0;
//           然后将转换的值相加
           int incremetal = firstNum + secondNum + carry;
//           拼接到stringbuilder 中
           sum.insert(0, incremetal % 10);
//           重新计算进位数的值
           carry = incremetal / 10;
       }
       return sum.toString();
    }

//    定义一个数字字典 nums

    public static String addStrings2(String num1, String num2){
        int n1 = num1.length(), n2 = num2.length();
        if(n1 == 0 && n2 == 0){
            return "";
        }
        if(n1 == 0){
            return num2;
        }
        if(n2 == 0){
            return num1;
        }
        Map<Character,Integer> map = new HashMap();
//        定义一个数字字典 nums
        char [] nums = {'0','1','2','3','4','5','6','7','8','9'};
//        将字典装入map中 key(字符数字)--value（int 数字）
        int number = 0;
        for(char ch: nums){
            map.put(ch, number ++);
        }
        StringBuilder sb = new StringBuilder();
//        定义进位数，num1, num2 的倒序索引
        int carry = 0; n1 = n1 - 1; n2 = n2 - 1;
        while(n1 >= 0 || n2 >= 0){
//            逐个将num1， num2中从后往前的每个值转换为对应的数字
            int v1 = n1 >= 0 ? map.get(num1.charAt(n1)):0;
            int v2 = n2 >= 0 ? map.get(num2.charAt(n2)):0;
//            将对应的值加起来
            int add = v1 + v2 + carry;
//            如果和大于9 则需要进位
            if(add > 9){
                carry = 1;
                add = add % 10;
            }else{
                carry = 0;
            }
//            将处理后的和添加到append中
            sb.append(add);
            n1--;
            n2--;
        }
//        如果进位数为1 ，则将其拼接到和中
        if(carry == 1){
            sb.append(carry);

        }
//        返回结果
        return sb.reverse().toString();
    }

    public static String addStrings3(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int n1 = num1.length() - 1, n2 = num2.length() - 1; n1>= 0 || n2 >= 0; n1--, n2--){
            int x = n1 >= 0 ? num1.charAt(n1) - '0': 0;
            int y = n2 >= 0 ? num2.charAt(n2) - '0': 0;
//            StringBuilder insert 代表在固定索引插入
            sb.insert(0,(x+y+carry)%10);
            carry = (x+y+carry)/10;
        }
        if(carry >0){
            sb.insert(0, carry);

        }
        return sb.toString();
    }

    public static void main(String [] args){

        System.out.println(addStrings2("123","123"));

    }




}
