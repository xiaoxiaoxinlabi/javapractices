package tests;

public class LengthOfLastWordTest {


//    最后一个单词的长度
//    给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
//    如果不存在最后一个单词，请返回 0 。
//
//    说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//    输入: "Hello World"
//    输出: 5




    public int lengthOfLastWord(String s){


        if (s == null || s.replace(" ", "").length() <1){

            return 0;
        }

        String str [] = s.split(" ");

        int len = str[str.length - 1].length();


        return len;

    }



    public int fun1(String s){

        s = s.trim();
        if (s.lastIndexOf("")!= -1){
            return (s.substring(s.lastIndexOf(" ") + 1)).length();
        }

        return s.length();

    }


    public static int lengthOfLastWord2(String s){
        if(s.length() == 0){
            return 0;
        }

        int count = 0;

        for(int i = s.length()-1; i >=0; i --){
            if(s.charAt(i) == ' '){
             if(count == 0){
             continue;
             }else{
                 break;
             }
            }
            count++;
        }

        return count;

    }

    public static int lengthOfLastWord3(String s){
        int end = s.length() - 1;
//        过滤掉单词尾部的空格
        while(end >= 0 && s.charAt(end) == ' '){
            end--;
        }
        if(end < 0){
            return 0;
        }
        int start = end;
//        找到单词头部
        while(start >=0 && s.charAt(start) != ' '){
            start --;
        }
//        用尾部减去头部就是长度
        return end - start;

    }


    public static void main(String [] args){

        String s = "hello world addsda    ";
//
//        System.out.println(s.trim());
//
//        LengthOfLastWordTest lengthOfLastWordTest = new LengthOfLastWordTest();
//        int length = lengthOfLastWordTest.fun1(s);
//        System.out.println(length);

        System.out.println(lengthOfLastWord2(s));
    }
}
