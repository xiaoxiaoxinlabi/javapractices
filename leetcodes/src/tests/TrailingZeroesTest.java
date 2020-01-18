package tests;

public class TrailingZeroesTest {

//    给定一个整数 n，返回 n! 结果尾数中零的数量。
//    5！=1*2*3*4*5=1*2*3*2*2*5,共有1对2*5，所以结果就只有一个0嘛；有几对2*5,结果就有几个0！
//    25!结果不只是25/5=5个0，25结果有6个0,因为25=5*5，有两个5。所以结果f(n)=n/5+f(n/5)!

    public int trailingZeroes0(int n ){
        if (n < 5) return 0;
        if (n < 10) return 1;
        return (n / 5 + trailingZeroes0(n/5));
    }

    public int trailingZeroes1(int n){
        int result = 0;
        while (n > 5){
            result += n/5;
            n/=5;
        }
        return result;
    }

    public int trailingZeroes2(int n){
        int count = 0;
        while(n != 0){
            n = n/5;
//            count +=n;
            count = count + n;
        }
        return count;
    }



    public static void main(String [] args){
        TrailingZeroesTest trailingZeroesTest = new TrailingZeroesTest();
        int arg = 5;
        int result = trailingZeroesTest.trailingZeroes2(arg);
        System.out.println(result);
    }
}
