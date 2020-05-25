package tests;

public class FeiBoNaQiTest {

//
//  斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
//  指的是这样一个数列：1,1,2,3,5,8,13,21,34,……1,1,2,3,5,8,13,21,34,……
//  在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1,F(2)=1,F(n)=F(n−1)+F(n−2)(n>=3，n∈N∗)

  public static void main(String [] args){

    System.out.println(fun1(5));

//    System.out.println(fun2(5));

  }

//  递归解法
//  缺点：递归存在这大量的重复计算
//  递归算法的空间复杂度大，在递归深度不断增大的情况下，内存会爆掉。


  public static int fun1(int n){

    if(n <= 2){
      return 1;
    }else{
      return fun1(n-1) + fun1(n-2);
    }


  }


//  迭代法

  public static int  fun2(int n){

    if(n < 2){
      return n;
    }

    int first = 1;
    int second = 1;
    int three = 0;
    for (int i = 2; i < n; i ++){
      three = first+second;
      first = second;
      second = three;


    }

    return three;


  }

}
