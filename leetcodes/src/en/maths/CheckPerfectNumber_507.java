package en.maths;

import java.util.HashSet;
import java.util.Set;

public class CheckPerfectNumber_507 {

//    我们将“完美数”定义为一个正整数，该整数等于除其自身以外的所有正整数之和。
//    现在，给定一个整数n，编写一个函数，当它是一个完美数时返回true，否则返回false。
//    Example:
//    Input: 28
//    Output: True
//    Explanation: 28 = 1 + 2 + 4 + 7 + 14

    public static boolean checkPerfectNumber(int num) {

        if(num == 0){
            return true;
        }

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 1; i < num; i ++){
            if(num % i == 0){
                set.add(i);
            }
        }

        int sum = 0;

        for(Integer res: set){
            sum+=res;
        }

        if(sum == num){
            return true;
        }
        return false;

    }

    public boolean checkPerfectNumber1(int num){
        if(num == 0){
            return false;
        }
        int sum = 0;

        for(int i = 1; i < num; i ++){
            if(num % i == 0 ){
                sum+=i;
            }
        }
        if(num == sum){
            return true;
        }
        return false;
    }

    public boolean checkPerfectNumber2(int num){
        if(num < 2){
            return false;
        }
        int sum = 1, multiplier = 2;
        while(multiplier <= num/multiplier){
            if(num % multiplier == 0){
                sum+=multiplier + (num/multiplier);
            }
            multiplier++;
        }
        return num==sum;
    }

    public boolean checkPerfectNumber3(int num){
        if(num <= 0){
            return false;
        }
        int i = 1;
        int sum = 0;
        for(; i * i < num; i ++){
            if(num % i == 0){
                sum+= i + (num / i);
            }
        }
        return sum - num == num;
    }

    public static void main(String [] args){
        System.out.println(checkPerfectNumber(28));
    }
}
