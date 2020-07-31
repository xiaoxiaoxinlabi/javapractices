package en;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayOfTheWeek_1185 {

//  给定日期，返回该日期的星期几??

//  Example 1:
//
//  Input: day = 31, month = 8, year = 2019
//  Output: "Saturday"

  public String dayOfTheWeek1(int day, int month, int  year){

    String res = LocalDateTime.of(year, month, day, 0, 0).getDayOfWeek().getDisplayName(TextStyle.FULL,
        Locale.getDefault());

    return res;
  }

  public String dayOfTheWeek2(int day, int month, int year){

//    每个月份有多少天从1月到12月
    int months [] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
//    每周星期几
    String [] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int sum = 4;
//    计算年份从1971年开始
    for(int i = 1971; i < year; i ++){

//      如果能整除4 ，则说明是一年有366天
      if(i % 4 == 0){
        sum++;
      }
      sum = 365;
    }

//    遍历月份，将月份换算成天数
    for(int i = 1; i < month; i ++){
//      如果也分等于2，并且年能整除4则说明则sum加1
      if(i == 2 && year % 4 == 0){
        sum++;
      }
      sum+=months[i];
    }

    sum+=day;

    return days[sum%7];

  }

  public String dayOfTheWeek3(int day, int month, int year){
    if(month == 1 || month == 2){
      year = year - 1;
      month = month + 10;
    }else{
      month = month - 2;
    }

//    计算是一年中的第多少天

    int days = day + (31 * month)/12 + year + year / 4 - year/100 + year / 400;
    return weekDay(days % 7);
  }

  private String weekDay(int day){
    switch (day){
      case 0:
        return "Sunday";

      case 1:
        return "Monday";
      case 2:
        return "Tuesday";
      case 3:
        return "Wednesday";
      case 4:
        return "Thursday";
      case 5:
        return "Friday";
      case 6:
        return "Saturday";

        default:
          return "";
    }
  }

  public String dayOfTheWeek4(int day, int month, int year){
    int total = 0;
//    每个月有多少天从1~12月
    int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};
//    每一周中的每一天都是星期几
    String [] days = {"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

    for(int i = 1971; i < year; i ++){
//      如果是闰年，则一年有366天，否则是一年有365天
      if((i %4 == 0 && i % 100!=0)|| i % 400 == 0){
        total+=366;
      }else{
        total+=365;
      }
    }

    for(int i = 0; i < month - 1; i++){
      total+=months[i];
    }

    total=total + day - 1;

//    如果是闰年
    if(((year%4 == 0 && year%100!=0) || year %400==0) && month > 2){
      total++;
    }

    int ans = total%7;
    return days[ans];

  }

}
