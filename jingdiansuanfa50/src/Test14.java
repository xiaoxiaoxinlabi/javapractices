import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test14 {
//  题目：输入某年某月某日，判断这一天是这一年的第几天？

//  分析：大家都知道，每年的总共日期，要么就是365天，要么就是366天，具体是取决于闰年还是平年，更确切的说就是每年二月是28天还是29天，
//  归结到这个问题，有一个关键的认识点，就是求解这一年是闰年（366天）还是平年（365天）。

  public static void fun1(String args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str = bf.readLine();
    String [] strArr = str.split("-");
    int year = Integer.parseInt(strArr[0]);
    int month = Integer.parseInt(strArr[1]);
//    定义第二个月默认是28天
    int twoMonth = 28;

    if((year % 4 ==0 && year %100!=0) || year % 400 ==0){
//      如果是闰年则2月是29天
      twoMonth = 29;
    }

    int totalDay = 0;
    int [] months = {31, twoMonth, 31,30,31,30,31,31,30,31,30,31};

//    /前几个月加上本月的天数
    for(int i = 0; i < months.length; i ++){
      if(month >=i+1){
        if(month == i+1){
          totalDay+=Integer.parseInt(strArr[2]);
          break;
        }else{
          totalDay+=months[i];
        }
      }
    }

    System.out.println(totalDay);



  }

  public  void fun2(){
    int year,  month,  day,  sum = 0;

    Scanner sc = new Scanner(System.in);
    int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    System.out.println("请输入年份：");
    year = sc.nextInt();
    if((year % 4 ==0 && year %100!=0) || year % 400 ==0){
//      如果是闰年则2月是29天
      months[1] = 29;
    }else{
      months[1]=28;
    }
    System.out.println("请输入月份:");
    month = sc.nextInt();

    System.out.println("请输入日期:");
    day = sc.nextInt();


    if(month == 1){
      System.out.println(year + "年的第"+ day+"天");

    }

    for(int i = 0; i < month-1;i++){
      sum = sum + months[i];
    }

    System.out.println("这是"+year+"年的第"+(sum+day)+"天");



  }

}
