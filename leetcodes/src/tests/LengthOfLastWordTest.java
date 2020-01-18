package tests;

public class LengthOfLastWordTest {

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


    public static void main(String [] args){

        String s = "hello world aa";

        System.out.println(s.trim());

        LengthOfLastWordTest lengthOfLastWordTest = new LengthOfLastWordTest();
        int length = lengthOfLastWordTest.fun1(s);
        System.out.println(length);
    }
}
