package tests;

public class TitleToNumberTest {

//    给定一个Excel表格中的列名称，返回其相应的列序号。
//Utilizing the ASCII values and treating each letter as a digit in a 26-base system (ex: "ABC" -> "A" * 26^2 + "B" * 26 ^ 1 + "C" * 26 ^ 0 = 1 * 26^2 + 2 * 26^1 + 3 * 26^0 = 731)

    public int titleToNumber(String s){
//        将字符串转换成数组
       char [] c = s.toCharArray();
//       定义变量用来判断字符串是属于是否大于最大的number = 26（title = Z）
       int result = 0;

       for (int i = 0; i < c.length; i ++){
           int dist = c[i] - 'A' + 1;
           result = result * 26 + dist;
       }
       return result;

    }

    public int titleToNumber1(String s){
        int num = 0,m = 1;
        for (int i = s.length() - 1; i >= 0; i --){
            int ascii = s.charAt(i) - 'A' + 1;
            num =num + ascii * m;
            m = m * 26;
        }
        return num;
    }

    public int titleToNumber2(String s){
        int total = 0;
        char [] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i ++){
            int dist = (int)ch[i] - (int)('A') + 1;
            total = 26*total + dist;
        }

        return total;
    }

    public static void main(String [] args){
        TitleToNumberTest titleToNumberTest = new TitleToNumberTest();
        String s = "AB";
        System.out.println(titleToNumberTest.titleToNumber(s));

    }
}
