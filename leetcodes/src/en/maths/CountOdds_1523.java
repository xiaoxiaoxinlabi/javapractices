package en.maths;

public class CountOdds_1523 {

//    给定两个非负整数low和high。返回低和高（含）之间的奇数计数。

    public int countOdds(int low, int high) {

        int count = (high - low)/2;

        if(low % 2 != 0 || high % 2 != 0){
            count++;
        }
        return count;
    }

    public int countOdds1(int low, int high){
        if(high % 2 == 0 && low % 2 == 0){
            return (high - low)/2;
        }else{
            return (high - low)/2 + 1;
        }
    }
}
