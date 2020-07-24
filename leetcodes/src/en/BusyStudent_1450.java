package en;

public class BusyStudent_1450 {

//    给定两个数组arr1, arr2, 和一个数字 n
//    找出 n 介于【arr1[i], arr2[i]】 包括边界值

    public int busyStudent1(int [] startTime, int [] endTime, int queryTime){
        int count = 0;
        int i = 0;
        while(i < startTime.length){
            if(startTime[i]<=queryTime && queryTime<=endTime[i]){
                count++;
            }
            i++;
        }
        return count;
    }

    public int busyStudent2(int [] startTime, int [] endTime, int queryTime){
        int count = 0;
        for(int i = 0; i < startTime.length; i ++){
            if(startTime[i] <= queryTime && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
}
