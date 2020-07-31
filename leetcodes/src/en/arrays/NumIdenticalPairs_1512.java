package en;

import java.util.HashMap;
import java.util.Map;

public class NumIdenticalPairs_1512 {
//    给定整数nums数组。
//    如果nums [i] == nums [j]并且i <j，则对（i，j）被称为好。
//    返回好的对的数量

//    双重循环遍历
    public int numIdenticalPairs1(int [] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            for(int j = 1; j < nums.length; j++){
                if(nums[i] == nums[j] && i < j){
                    count++;
                }
            }
        }
        return count;
    }

//    计算每个元素出现的次数，然后利用公式计算配对数
    public int numIdenticalPairs2(int [] nums){
        int res = 0;
        int [] memo = new int[101];
        for(int num:nums){
            memo[num]++;
        }
        for(int i = 0; i < 101; i++){
            int t = memo[i];
            if(t >=2){
                res +=t *(t-1)/2;
            }
        }
        return res;

    }

    public int numIdenticalPairs3(int [] nums){
        Map<Integer, Integer> numcount = new HashMap();
        int res = 0;
        for(int n: nums){
            if(numcount.containsKey(n)){
//                如果包含n 则，res+= n出现次数
                res+=numcount.get(n);
                // update the total occurances for the number
                numcount.put(n, numcount.get(n)+1);
            }else{
                // if the number is encountered for the first time, update occurance count to 1
                numcount.put(n,1);
            }
        }
        return res;
    }


    // whenever you encounter a number, go to the slot where that number is
    // in.

    // The value in that slot shows how many times the number has occurred
    // already, that means you can pair it with all of the exisitng number,
    // which is basically nums[i].
    public int numIdenticalPairs4(int [] nums){
        int [] arr = new int[101];
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
//            配对数 = num 出现的次数
            count= count + arr[num];
            arr[num]++;
        }
        return count;
    }
}
