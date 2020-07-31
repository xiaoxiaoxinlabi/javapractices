package en;

import java.util.Arrays;

public class CanMakeArithmeticProgression_1502 {

//    给定一组数字arr。如果任意两个连续元素之间的差相同，则数字序列称为算术级数。
//    如果可以重新排列数组以形成算术级数，则返回true；否则，返回false。

    public boolean canMakeArithmeticProgression1(int [] arr){
        Arrays.sort(arr);
        int check = arr[1] - arr[0];
        for(int i = 1; i < arr.length; i ++){
            if(Math.abs(arr[i] - arr[i-1])!=Math.abs(check)){
                return false;
            }
        }
        return true;
    }

    public boolean canMakeArithmeticProgression2(int [] arr){
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 0; i < arr.length; i ++){
            if(i == arr.length - 1){
                return true;
            }
            if(arr[i+1] - arr[i] != diff){
                return false;
            }
        }
        return true;
    }

//    sum = n*(a1+an)/2 => 2sum = n(a1+an)
    public boolean canMakeArithmeticProgression3(int [] arr){
        int sum = 0, min = arr[0], max = arr[0];
        for(int a: arr){
            sum+=a;
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        return 2 * sum ==(arr.length*(min +max));
    }
}
