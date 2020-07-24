package en;

import java.util.Arrays;

public class Average_1491 {

//    返回员工的平均工资，不包括最低和最高工资。

    public double average1(int [] salary){

        Arrays.sort(salary);
        double sum = 0;
        double average = 0.0;

        for(int i = 1; i < salary.length-1; i ++){
            sum+=salary[i];
        }

        average = sum / (salary.length-2);
        return average;
    }

    public double average2(int [] salary){

        double sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double avarage = 0;

//        在遍历的时候找出最大，最小值
        for(double i : salary){
            if(min > i){
                min = i;
            }
            if(max < i){
                max = i;
            }
            sum+=i;

        }
        sum-=max;
        sum-=min;
        avarage = sum / (salary.length - 2);

        return avarage;
    }
}

