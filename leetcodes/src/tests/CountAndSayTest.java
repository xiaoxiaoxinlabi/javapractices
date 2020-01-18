package tests;

public class CountAndSayTest {

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
