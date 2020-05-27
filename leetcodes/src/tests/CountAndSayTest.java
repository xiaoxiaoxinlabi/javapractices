package tests;

public class CountAndSayTest {

//    38. 外观数列
//    「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
//     1.     1
//    2.     11
//    3.     21
//    4.     1211
//    5.     111221
//    1 被读作  "one 1"  ("一个一") , 即 11。
//        11 被读作 "two 1s" ("两个一"）, 即 21。
//        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//
//    给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
//
//    注意：整数序列中的每一项将表示为一个字符串。


/**
 * 解题思路：
 * 本题的难点在于：报数的概念理解，至少我从题意中没有很清晰的理解，但是感觉像是个递推式
 * 从4->5分析，将4个每一位拆开看（个数+数字），4=1211 => 1=11，2=12，11=21，所以5=111221
 * 所以解题用循环，从1->n可求解出来

**/

    public String countAndSay(int n) {


//    如果n<=0,则返回-1
        if (n <= 0) return "-1";

        String result = "1";
        for (int i = 1; i < n ; i ++){
            StringBuilder builder = new StringBuilder();
            int index = 0;
            while(index < result.length()){
//                 根据ascii码  字符串："1" 所对应十进制为：49
                char val = result.charAt(index);
                int count = 0;
                while(index < result.length() && result.charAt(index) == val){
                    index++;
                    count++;
                }
                builder.append(String.valueOf(count));
                builder.append(val);
            }
            result = builder.toString();
        }
        return result;

    }


    public String countAndSay1(int n){
        String oldString = "1";
        while(--n > 0){
            StringBuilder sb = new StringBuilder();
            char [] oldChars = oldString.toCharArray();

            for (int i = 0; i < oldChars.length; i ++){
                int count = 1;
                while((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]){
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            oldString = sb.toString();
        }

        return oldString;

    }

    public String countAndSay2(int n){
        if (n == 1){
            return "1";
        }
        String str = countAndSay2(n - 1);
        StringBuilder sb = new StringBuilder();
        char cur = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i ++){
            if (str.charAt(i) != cur){
                sb.append(count).append(cur);
                count = 1;
                cur = str.charAt(i);
                continue;

            }
            count ++;
        }

        return sb.append(count).append(cur).toString();
    }



    public static void main(String [] args){

        CountAndSayTest c = new CountAndSayTest();
        System.out.println(c.countAndSay2(3));



    }
}
