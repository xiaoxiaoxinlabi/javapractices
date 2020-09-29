package en.maths;

public class IsPowerOfThree_326 {

//    给定一个整数，编写一个函数以确定它是否为三的幂。
//      注意：不使用任何循环/递归
//    Example 1:
//    Input: 27
//    Output: true

//    Example 2:
//    Input: 0
//    Output: false


    public boolean isPowerOfThree(int n) {

        while(n > 1){
            if(n % 3 == 0){
                n = n / 3;
            }else{
                return false;
            }
        }
        if(n == 1){
            return true;
        }
        return false;

    }

    public boolean isPowerOfThree1(int n) {
        while (n >= 1) {
            if (n % 3 != 0 && n != 1) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            n = n / 3;
        }
        return false;

    }


//    递归
    public boolean isPowerOfThree2(int n){
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        return n % 3 == 0 && isPowerOfThree2(n/3);
    }

//    循环

    public boolean isPowerOfThree3(int n){
        if(n == 0){
            return false;
        }
        while(n % 3 == 0){
            n/= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree4(int n){
        if(n == 0){
            return false;
        }
        double logVal = Math.log10(n) / Math.log10(3);
        return logVal == Math.rint(logVal);
    }

    public boolean isPowerOfThree5(int n){
        while( n!= 1){
            if(n % 3!= 0 || n == 0){
                return false;
            }
            n/=3;
        }
        return true;
    }

    public boolean isPowerOfThree6(int n){
        if((n & 1) == 1){
            double j = 1;
            while(j < n){
                j*=3;
            }
            return j == n;
        }
        return false;
    }
}
