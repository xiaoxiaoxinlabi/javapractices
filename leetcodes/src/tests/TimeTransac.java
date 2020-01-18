package tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeTransac {

    public void timeStampToDate( long var){
        long timestemp = var < 10000000000L ?  (var * 1000) : var;
        System.out.println(timestemp);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(timestemp));


       System.out.println(date);

    }

    public static void main(String [] args){
        TimeTransac t = new TimeTransac();
        t.timeStampToDate(1473048265);

    }
}
