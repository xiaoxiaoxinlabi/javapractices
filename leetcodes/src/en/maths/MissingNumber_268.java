package en.maths;

import java.util.Arrays;
import java.util.HashMap;

public class MissingNumber_268 {

//    给定一个数组，其中包含从0、1、2，...，n中提取的n个不同的数字，请找到该数组中缺少的一个。

//    Example 1:
//    Input: [3,0,1]
//    Output: 2
//    Example 2:
//
//    Input: [9,6,4,2,3,5,7,0,1]
//    Output: 8


    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        int i;
        for( i = 0; i < nums.length; i ++){
                if(nums[i] != i){
                    break;
                }

            }

        return i;

    }
//    前n 项和 逐一减去 nums中的数，剩余的就是缺失的
    public int missingNumber1(int [] nums){
        int sum = (nums.length * (nums.length+1))/2;
        for(int i : nums){
            sum = sum - i;
        }
        return sum;
    }

    public int missingNumber2(int [] nums){
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i],1);
        }
        for(int i = 0; i < map.size(); i++){
            if(!map.containsKey(i+1)){
                return i + 1;
            }
        }
        return 0;
    }
}
