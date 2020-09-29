package en.binarysearch;

public class IsPerfectSquare_367 {

//    给定一个正整数num，编写一个函数，如果num是一个完美的平方，则返回True，否则返回False。
//    后续：不要使用任何内置库函数，例如sqrt。

//    Example 1:
//
//    Input: num = 16
//    Output: true
//    Example 2:
//
//    Input: num = 14
//    Output: false


    public boolean isPerfectSquare(int num) {
        if(num == 0){
            return false;
        }
        if(num == 1){
            return true;
        }

        int low = 1, high = num;
        while(low <= high){
            long mid = low +(long) (high - low)/2;
            if(mid * mid == num){
                return true;
            }
            if(mid * mid < num){
                low = (int)mid + 1;
            }
            else{
                high = (int)mid - 1;
            }
        }

        return false;

    }
}
