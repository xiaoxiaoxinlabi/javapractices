package tests.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTest1 {
    //    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    //    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

    public int [] twoSum0(int [] numbers, int target){

        for (int i = 0, j = numbers.length - 1; i < j && j < numbers.length;){
            if (numbers[i] + numbers[j] > target){
                j --;
            }else if (numbers[i] + numbers[j] < target){
                i ++;
            }else{
                return new int[]{i + 1, j + 1};
            }
        }

        return new int [] {};

    }

    public int [] twoSum1(int [] num, int target){
        int i = 0;
        int j = num.length - 1;
        while (i < j){
            if (num[i] + num[j] > target){
                j --;
            }else if(num[i] + num[j] < target){
                i ++;
            }else {
                return new int []{i + 1, j + 1};
            }
        }
        return new int[]{};
    }

    public int [] twoSum2(int [] num, int target){
        int [] index = new int[2];
        for (int i = 0; i < num.length; i ++){
            for (int j = num.length - 1; j > -1; j --){
                if (num[i] + num[j] == target && i != j){
//                    为什么是这样子赋值？？？？
                    index[1]= i + 1;
                    index[0] = j + 1;
                    break;
                }
            }
        }
        return  index;
    }


    public int [] twoSum3(int [] num, int target){

        int [] res =  new int [2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num.length; i ++){
            if(map.containsKey(target - num[i])){
                res[0] = i;
                res[1] = map.get(target - num[i]);
            }else{
                map.put(num[i], i);
            }
        }

        return res;

    }

    public static void main(String [] args){

        TwoSumTest1 twoSumTest1 = new TwoSumTest1();
        int [] arr = {2,7,11,15};
        int target = 9;
        int [] newArr = twoSumTest1.twoSum0(arr,target);
        for (int i: newArr){
            System.out.println(i);
        }

    }
}
