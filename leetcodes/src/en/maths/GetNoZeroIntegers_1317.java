package en.maths;

public class GetNoZeroIntegers_1317 {
//
//    给定整数n。无零整数是一个正整数，其十进制表示形式不包含任何0。
//    返回两个整数[A，B]的列表，其中：
//    A和B是都不包括 0
//    A + B = n
//    保证至少有一个有效的解决方案。如果有许多有效的解决方案，您可以返回其中任何一个。
    public int[] getNoZeroIntegers(int n) {

        int a = 1;
        int b = n - a;
        String bs = String.valueOf(b);
        String as = String.valueOf(a);

        while(bs.contains("0") || as.contains("0")){
            a++;
            b--;
            bs = String.valueOf(b);
            as = String.valueOf(a);
        }
        return new int []{a,b};




    }

    public int [] getNoZeroIntegers1(int n){
        int [] out = new int[2];
        for(int i = 1; i <= n; i ++){
            if(isContainsZero(i) && isContainsZero(n-i)){
                out[0] = i;
                out[1] = n - i;
                break;
            }
        }
        return out;
    }

    public boolean isContainsZero(int n){
        while(n != 0){
            if(n % 10 == 0){
                return false;
            }
            n = n / 10;
        }
        return true;
    }


    public int [] getNoZeroIntegers2(int n){
        int first = 1, second = n - 1;
        while(containsZero(first) || containsZero(second)){
            first++;
            second--;
        }
        return new int[]{first,second};
    }

    private boolean containsZero(int n){
        while (n != 0){
            if(n % 10 == 0){
                return true;
            }
            n = n / 10;
        }
        return false;
    }
}
