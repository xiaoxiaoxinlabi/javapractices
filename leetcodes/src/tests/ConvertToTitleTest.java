package tests;

public class ConvertToTitleTest {

//    给定一个正整数，返回它在 Excel 表中相对应的列名称

    public String convertToTitle(int n){

        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();
        while (n > 0){
            // Find remainder(求余)
            int temp = n % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (temp == 0){
                columnName.append("Z");
                n = n / 26 - 1;
            }else {
                // If remainder is non-zero
                columnName.append((char)((temp - 1) + 'A'));
                n = n / 26;
            }
        }

        // Reverse the string and print result
        return columnName.reverse().toString();
    }

    public String convertToTitle1(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n --;
            char c = (char)(n % 26 + 'A');
            sb.append(c);
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public String convertToTitle2(int n){
        String str = "A B C D E F G H I G K L M N O P Q R S T U V W X Y Z";
        String [] arr = str.split(" ");
        String str1 = "";
        while(n != 0){
            n --;
            int temp = n % 26;
            str1 = arr[temp] + str1;
            n = n / 26;
        }
        return str1;
    }


    public static void main(String [] args){
        ConvertToTitleTest convertToTitleTest = new ConvertToTitleTest();
        int n =1;
        String result = convertToTitleTest.convertToTitle2(n);
        System.out.println(result);

    }
}
