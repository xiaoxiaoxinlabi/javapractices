package en.maths;

public class AddDigits_258 {

//    给定一个非负整数num，请重复加所有数字，直到结果只有一位。
//    Example:
//    Input: 38
//    Output: 2
//    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
//    Since 2 has only one digit, return it.


    public int addDigits(int num) {

        if(num < 10){
            return num;
        }
        while(num > 9){
            num = num / 10 + num % 10;
        }

        return num;

    }


//    在数学中，我们了解到任何可被9整除的数字，该数字中的数字之和也可被9整除。
//    同样，在这里我们知道问题的结果是一个在[0,9]范围内的整数
    public int addDigits1(int num){
        if(num == 0){
            return 0;
        }
        if(num % 9 == 0){
            return 9;
        }
        return num%9;
    }


}
