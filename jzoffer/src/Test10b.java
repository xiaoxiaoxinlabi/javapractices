public class Test10b {

//  青蛙跳台阶问题

//  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

//  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。


//  方法1：动态规划

//  思路分析：借助辅助变量sum，利用双指针，a、b。a = b向后移动a（a从0移动到n的位置停下，所以最后返回a），b = sum向后移动b（为了同步）
//  时间复杂度：O(N) 循环N次
//  空间复杂度：O(1) 省去了dp数组的方式

  public int numway1(int n){

    int a = 1, b = 1 , sum;
    for(int i = 0; i < n; i++){
      sum = (a+b)%1000000007;
      a=b;
      b=sum;
    }

    return a;
  }

  //斐波那契数列

  public int numway2(int n){
    if(n==1){
      return 1;
    }
    int first=1;
    int second =2;
    int res = 0;
    for(int i = 3; i <=n; i ++){
       res = (first+second) %1000000007;
      first=second;
      second=res;

    }
    return res;
  }




}
