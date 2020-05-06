
public class Test43 {

//  面试题43. 1～n整数中1出现的次数
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//  例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

  public int countDigitOne(int n){
    return f(n);
  }

//  将n拆分为两部分，最高一位的数字high和其他位的数字last，分别判断情况后将结果相加
//  例子如n=1234，high=1, pow=1000, last=234
//  可以将数字范围分成两部分1~999和1000~1234
//      1~999这个范围1的个数是f(pow-1)
//    1000~1234这个范围1的个数需要分为两部分
//  千分位是1的个数：千分位为1的个数刚好就是234+1(last+1)，注意，这儿只看千分位，不看其他位
//  其他位是1的个数：即是234中出现1的个数，为f(last)
  private int f(int n){
    if (n <= 0){
      return 0;
    }

    String s= String.valueOf(n);
    int high = s.charAt(0) - '0';
    int pow = (int) Math.pow(10, s.length() - 1);
    int last = n - high * pow;
    if(high == 1){
      return f(pow - 1) + last + 1 + f(last);
    }else{
      return pow + high*f(pow - 1) + f(last);
    }

  }
}

