package en.maths;

import java.util.ArrayList;
import java.util.List;

public class IsUgly_263 {

//    编写程序以检查给定的数字是否是丑数。
//    丑数是正数，其因子仅包括2、3、5

//    Example 1:
//
//    Input: 6
//    Output: true
//    Explanation: 6 = 2 × 3

//    Example 2:
//
//    Input: 8
//    Output: true
//    Explanation: 8 = 2 × 2 × 2

//    One Ugly number must be：Ugly number = n12 + n23 + n3*5

    public static boolean isUgly(int num) {
       if(num <= 0){
           return false;
       }

        while(true){
            if(num % 2 == 0){

                num = num / 2;

            }else if(num % 3 == 0){
                num = num / 3;
            }else if(num % 5 == 0){
                num = num / 5;
            }else{
                break;
            }
        }

        return num == 1;

    }

    public boolean isUgly1(int num){

        if(num <= 0){
            return false;
        }
        while(num % 2 == 0){
            num= num / 2;
        }
        while(num % 3 == 0){
            num = num / 3;
        }
        while(num % 5 == 0){
            num = num / 5;
        }
        if(num == 1){
            return true;
        }
        return false;
    }

//     *要检查数字是否丑陋，请将该数字除以2、3和5的最大可除幂。如果数字变为1，则否则为丑陋数字。* /
    public boolean isUgly2(int num){
        for(int i = 2; i < 6 && num > 0; i++){
            while(num % i == 0){
                num /=i;
            }
        }
        return num==1;
    }

    public static void main(String [] args){
        System.out.println(isUgly(10));
    }
}
