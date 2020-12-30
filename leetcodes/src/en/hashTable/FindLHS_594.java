package en.hashTable;

import java.util.Arrays;
import java.util.HashMap;

public class FindLHS_594 {

//    我们将和谐数组定义为最大值和最小值之差恰好为1的数组。
//    给定一个整数数组nums，返回其所有可能子序列中最长的和谐子序列的长度。
//    数组的子序列是可以通过删除一些元素或不删除某些元素而无需更改其余元素的顺序而从数组中得出的序列。

    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap();
        int max = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.containsKey(num + 1)){
                max = Math.max(max, map.get(num) + map.get(num + 1));
            }if (map.containsKey(num - 1)){
                max = Math.max(max, map.get(num) + map.get(num - 1));
            }
        }
        return max;
    }
    public int findLHS1(int [] nums){
        Arrays.sort(nums);
        int res = 0, currcount = 1, preNum = Integer.MIN_VALUE, precount = 0;

        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i - 1]){
                currcount++;
            }else{
                if(nums[i - 1] - preNum == 1){
                    res = Math.max(precount + currcount, res);
                }
                precount = currcount;
                preNum = nums[i-1];
                currcount = 1;
            }
        }
        if(nums[nums.length - 1] - preNum == 1){
            res = Math.max(precount + currcount, res);
        }
        return res;
    }

    public int findLHS2(int [] nums){
        Arrays.sort(nums);
        int res = 0;
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] - nums[left] < 1){
                right++;
            }else if(nums[right] - nums[left] == 1){
                res = Math.max(res, right - left + 1);
                right++;
            }else{
                left++;
            }
        }
        return res;
    }

}
