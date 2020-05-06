public class Test20 {
//  题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。



  public static  void main(String [] args){
    double a = 1, b = 1, sum = 0;//a为分母，b为分子，sum存储总和
    for(int i = 1; i <=20; i++){
      double temp = b;//存此时b的值
      b = b + a;//b的值等于a+b的值
      a = temp;//将之前存的b的值赋给a
      sum = sum + b / a;//求和
    }
    System.out.println(sum);
  }

}
