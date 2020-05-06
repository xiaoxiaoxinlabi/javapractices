public class Test08 {

//  题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。

  public static  void fun(int a, int n){

    int sum = 0, b =0;

    for(int i = 0; i < n; i++){
      b=b+a;
      sum=sum+b;
      a=a*10;

    }
    System.out.println(sum);

  }

}
