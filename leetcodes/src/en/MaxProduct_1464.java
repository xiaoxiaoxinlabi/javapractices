package en;

import java.util.Arrays;

public class MaxProduct_1464 {

//    给定整数nums数组，您将选择该数组的两个不同的索引i和j。返回（nums [i] -1）*（nums [j] -1）的最大值。

    public int maxProduct1(int [] nums){
       int k = Integer.MIN_VALUE;
       for(int i = 0; i < nums.length; i ++){
           for(int j = i + 1; j < nums.length; j ++){
               k = Math.max(k, (nums[i]-1) * (nums[j]-1));
           }
       }
       return k;

    }

    public int maxProduct2(int [] nums){
        Arrays.sort(nums);
        return ((nums[nums.length-1] -1) * (nums[nums.length-2]-1));
    }

    public int maxProduct3(int [] nums){
        int res = (nums[0]-1) * (nums[1]-1);
        int max = 0;
        for(int i = 0; i < nums.length; i ++){
            for(int j = i+1; j < nums.length; j ++){
                if(max > res){
                    res = max;
                }
            }
        }
        return res;
    }

//    找到两个最大的数
    public int maxProduct4(int [] nums){
        int firstMax = 0, secondMax = 0;
        for(int i :nums){
            if(i > firstMax){
                secondMax = firstMax;
                firstMax = i;
            }else if(i > secondMax){
                secondMax = i;
            }
        }

        return (firstMax-1) * (secondMax-1);

    }
}
