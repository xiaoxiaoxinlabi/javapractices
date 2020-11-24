package en.hashTable;

import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum_1 {

//    给定一个整数nums数组和一个整数目标，返回两个数字的索引，这样它们加起来就等于目标。
//    您可以假设每个输入都只有一个解决方案，并且您可能不会两次使用同一元素。
//    您可以按任何顺序返回答案

    public int[] twoSum(int[] nums, int target) {

        int tmp = 0;
        int [] arr = new int[2];
        for(int i = 0; i < nums.length; i ++){
            tmp = target - nums[i];
            for(int j = i+1; j < nums.length; j ++){
                if(nums[j] == tmp){
                    arr[0] = j;
                    arr[1] = i;
                }
            }

            }
        return arr;
    }



    public int [] twoSum1(int [] nums, int target){

        Arrays.sort(nums);
        int [] arr = new int[2];
        int left = 0, right = nums.length-1;

        while(left <= right){
            if(nums[left] + nums[right] > target){
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else if(nums[left] + nums[right] == target){
                arr[0] = left + 1;
                arr[1] = right + 1;
            }
        }

        return arr;

    }

    public int [] twoSum2(int [] nums, int target){
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        int [] arr = new int[2];
        for(int i = 0; i < nums.length; i ++){
           if(hash.containsKey(target - nums[i])){
               arr[0] = i;
               arr[1] = hash.get(target - nums[i]);
           }else{
               hash.put(nums[i],i);
           }

        }
        return arr;
    }


}

