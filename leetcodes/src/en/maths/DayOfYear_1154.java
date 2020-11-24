package en.maths;

import java.time.LocalDate;

public class DayOfYear_1154 {

//    给定一个表示公历日期的字符串日期，格式为YYYY-MM-DD，请返回年份的天数。

    public int dayOfYear(String date) {


        String [] newdate = date.split("-");

        int year = Integer.parseInt(newdate[0]);
        int month = Integer.parseInt(newdate[1]);
        int days = Integer.parseInt(newdate[2]);

        int monarray [] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int totaldays = 0;

        for(int i = 0; i < month - 1; i ++){
            totaldays += monarray[i];
        }

//        闰年
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){

            if(month > 2){
                return totaldays + days + 1;
            }

        }
        return totaldays + days;

    }

    public int dayOfYear1(String date){
        String [] full = date.split("-");
        int y = Integer.parseInt(full[0]);
        int m = Integer.parseInt(full[1]);
        int d = Integer.parseInt(full[2]);

        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int total = d;

        for(int i = 1; i < m; i ++){
            total += months[i-1];
        }

        if(LocalDate.of(y,m,d).isLeapYear() && m > 2){
            total ++;
        }
        return total;

    }

    public int dayOfYear2(String date){
        int y = Integer.valueOf(date.substring(0,4));
        int m = Integer.valueOf(date.substring(5,7));
        int d = Integer.valueOf(date.substring(8,10));

        int [] monthArr = new int [] {31,28,31,30,31,30,31,31,30,31,30,31};

        if((y % 4 == 0) && (y % 100 != 0) || (y % 400 == 0)){
            monthArr[1] = 29;
        }
        int ans = 0;

        for(int i = 0; i < m - 1; i ++){
            ans += monthArr[i];
        }
        ans += d;

        return ans;


    }


//    判断是否为闰年
    public boolean isLeapYear(int year){
        boolean isLeap = false;

//        首先判断是否整除4
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    isLeap = true;
                }else{
                    isLeap = false;
                }
            }else {
                isLeap = true;
            }
        }else{
            isLeap = false;
        }
        return isLeap;
    }




}
