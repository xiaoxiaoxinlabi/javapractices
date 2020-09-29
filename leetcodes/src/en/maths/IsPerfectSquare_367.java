package en.maths;

public class IsPerfectSquare_367 {

//    给定一个正整数num，编写一个函数，如果num是一个完全平方数，则返回True，否则返回False。
//    后续：不要使用任何内置库函数，例如sqrt。
//
//    Example 1:
//    Input: num = 16
//    Output: true
//    Example 2:
//
//    Input: num = 14
//    Output: false

    public boolean isPerfectSquare(int num) {

        if(num == 1){
            return true;
        }
        for(int i = 0; i <= num/2; i ++){
           if(i * i == num){
                return true;
            } else if(i * i > num){
                return false;
            }
        }

        return false;

    }
    public boolean isPerfectSquare1(int num) {
        if (num == 1) {
            return true;
        }
        for (int i = num / 2; i >= 0; i--) {
            if (i * i == num) {
                return true;
            } else if (i * i > num) {
                continue;
            }
        }
        return false;

    }

    public static boolean isPerfectSquare2(int num){
        int left = 1, right = num/2;

        if(num == 1){
            return true;
        }

        while(left <= right){
            if(right * right > num){
                right--;
            }else if(left * left < num){
                left++;
            }else if(left * left == num || right * right == num){
                return true;
            }
        }
        return false;

    }

    public boolean isPerfectSquare3(int num){
        long left = 1, right = num/2;

        if(num == 1 || num == 4){
            return true;
        }

        while(left < right){
            long mid = left + (right - left)/2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                left = mid + 1;
            }else{
                right = mid;
            }

        }
        return false;
    }

//    odd num: 1 + 3 + 5 + 7 + 9
//    odd sum: 1   4   9   16  25
//    square of: 1   2   3   4   5
    public boolean isPerfectSquare4(int num){
        int oddSum = 1;
        while(num > 0){
            num -= oddSum;
            oddSum += 2;
        }
        return num == 0 ? true : false;
    }

    public boolean isPerfectSquare5(int num){
        if(num < 0){
            return false;
        }
        long sqrt = num;
        while(sqrt * sqrt > num){
            sqrt = (num/sqrt + sqrt)/2;
        }
        return sqrt * sqrt == num;
    }


    public static void main(String [] args){
        System.out.println(isPerfectSquare2(1));

    }

}
