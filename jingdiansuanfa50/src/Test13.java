import java.util.Map;

public class Test13 {

//  题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？

//  一个数如果是另一个整数的完全平方，那么我们就称这个数为完全平方数，也叫做平方数。

  public static void main(String [] args){

    for(int i = 100; i < 1000; i ++){

//      获取平方根
      int a = (int)Math.sqrt(i+100);
      int b = (int)Math.sqrt(i+168);
        if(a*a == (i+100) && b*b ==(i+168)){
          System.out.println(i);
        }
    }
  }


}
