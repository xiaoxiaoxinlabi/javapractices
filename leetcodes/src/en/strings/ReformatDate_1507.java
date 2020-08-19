package en.strings;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate_1507 {

//    以Day Month Year的形式给出日期字符串，其中
//    Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
//    Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
//    Year is in the range [1900, 2100].

    public String reformatDate(String date) {


        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");

        String[] s = date.split(" ");
        String year = s[2];
        String month = map.get(s[1]);
        String day = s[0].substring(0,s[0].length()-2);
        String days = day.length() == 1 ? "0"+day : day;

        return year +"-"+ month +"-"+  days;


    }
}
