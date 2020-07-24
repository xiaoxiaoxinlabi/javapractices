import java.util.Scanner;

public class Test50 {

//  判断是否为闰年

//  闰年2月29天，平年2月28天

  public static void main(String [] args){

    fun2();



  }



//  判断是否为闰年
  public static void fun1(int year){

    if((year %4 == 0 && year %100!=0)||year %400 == 0){
      System.out.println(year +"是润年");
    }else{
      System.out.println(year + "不是闰年");
    }

  }

  public static void fun2(){
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入年份：");
    int year = sc.nextInt();

//    判断年份是否能被4整除
    boolean isLeapYear = (year % 4)==0;

//    年份能被4整除，并且不能被100整除？
    isLeapYear = isLeapYear && (year % 100!=0);

//    或者能被400整除

    isLeapYear = isLeapYear || (year % 400==0);

    if(isLeapYear){
      System.out.println(year + "是闰年");
    }else{
      System.out.println(year + "不是闰年");
    }
  }


}
