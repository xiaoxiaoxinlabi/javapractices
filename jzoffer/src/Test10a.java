public class Test10a {

//  写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

//  F(0) = 0,   F(1) = 1
//  F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

//  斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

//  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1




  public  int getFibonacci2(int n){

    if (n < 3){
      return  n;
    }
    return getFibonacci2(n-1) + getFibonacci2(n-2);
  }


//  循环求余法：
//  大数越界： 随着 nn 增大, f(n)f(n) 会超过 Int32 甚至 Int64 的取值范围，导致最终的返回值错误。

//  求余运算规则： 设正整数 x, y, px,y,p ，求余符号为 \odot⊙ ，则有 (x + y) \odot p = (x \odot p + y \odot p) \odot p(x+y)⊙p=(x⊙p+y⊙p)⊙p 。
//  解析： 根据以上规则，可推出 f(n) \odot p = [f(n-1) \odot p + f(n-2) \odot p] \odot pf(n)⊙p=[f(n−1)⊙p+f(n−2)⊙p]⊙p ，从而可以在循环过程中每次计算 sum = (a + b) \odot 1000000007sum=(a+b)⊙1000000007 ，此操作与最终返回前取余等价。

  public  int fib(int n){
    int a = 0, b = 1, sum;

    for(int i =0; i < n; i ++){
      sum = (a+b)%1000000007;
      a=b;
      b=sum;
    }
    return a;
  }

}
