package en.maths;

public class IsPowerOfTwo_231 {

//    给定整数n，编写一个函数以确定它是否为2的幂。

//    Example 1:
//
//    Input: n = 1
//    Output: true
//    Explanation: 20 = 1
//    Example 2:
//
//    Input: n = 16
//    Output: true
//    Explanation: 24 = 16

    public static boolean isPowerOfTwo(int n) {

        if(n == 1){
            return true;
        }
        if(n <= 0){
            return false;
        }
        Double x = (double) n;
        while(x >2){
            x = x / 2;
            if(x % 2 != 0){
                return false;
            }

        }

        return true;

    }

    public boolean isPowerOfTwo1(int n){
        if(n < 1){
            return false;
        }
        if(n == 1){
            return true;
        }
        return n%2 != 0? false:isPowerOfTwo1(n/2);
    }

    public boolean isPowerOfTwo2(int n){
        while(n >= 1){
            if(n % 2!= 0 && n != 1){
                return false;
            }
            if(n == 1){
                return true;
            }
            n = n / 2;
        }
        return false;
    }
}
