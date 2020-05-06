public class Test01 {
//  题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？

  //这是一个菲波拉契数列问题
//  它的突破口在三个月之后开始，界定第一个月数目为1，第二个月也是1，从第三个月开始计算第一次出生的兔子数
//  通过分析，可以看出当月份为n时，兔子的对数为前两个之和，设对数为函数f(n),则有：
//  f  (n) = f（n-1）+  f（n-3）；

  public static void main(String [] args){
    int num1 = 1, num2 = 1, num;
//    定义结束的月份
    int M = 30;
    for(int i = 1; i < M; i++){

      if(i <=2){
        System.out.println("第"+i+"个月的兔子总对数是:1对");
      }else{
        //先把第month-1个月的对数赋值给中间变量num1,此时的num1已不用
        num = num2;
        //第month个月的总对数=month-1个月的总对数+month-2个月的总对数
        num2 = num1+num2;
        //再把第本次的mont-1个月的对数赋值给下一次循环的第month-2个月的对数
        num1 = num;
        System.out.println("第"+i+"个月的兔子总对数是:"+num2+"对");
      }

    }

  }

}
