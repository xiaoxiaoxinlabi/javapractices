package en.hashTable;

import java.util.*;

public class SingleNumber_136 {

//    给定一个非空整数nums数组，每个元素出现两次，除了一个。找到那一个。
//    后续：您是否可以在不使用额外内存的情况下实现具有线性运行时复杂度的解决方案？

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> re: map.entrySet()){
            if(re.getValue() == 1){
                return re.getKey();
            }
        }
        return -1;

    }

//    public int singleNumber1(int [] nums){
//        int [] count = new int[40000];
//        int res = 0;
//        for(int i = 0; i < nums.length; i ++){
//            count[nums[i]]++;
//        }
//
//
//        for(int i = 0; i < count.length; i ++){
//            if(count[i] == 1){
//                res = i + 1;
//            }
//        }
//
//        return res;
//    }


    public int singleNumber2(int [] nums){
        int res = 0;
        for(int i : nums){
//            按位异或
            res = res ^ i;
        }
        return res;
    }

//    装进set，如果遇到重复的元素则，将其从set删除
    public int singleNumber3(int [] nums){
        Set<Integer> set = new HashSet();
        for(int i = 0; i < nums.length; i ++){
            if(! set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

//    对数组进行排序
    public int singleNumber4(int [] nums){
        Arrays.sort(nums);
        int val = 0, single = 0, j = 0;
        boolean singleChanged = false;

        for(int i = 1; i < nums.length; i+=2){
            val = nums[j];
//            如果相邻的两个相同，则跳过
            if(val == nums[i]){
                j+=2;
            }else{
//                否则就是找到了出现一次的 数
                single = val;
                singleChanged = true;
            }
        }
//        否则，返回数组最后一个数
        if(single == 0 && !singleChanged){
            single = nums[nums.length - 1];
        }
        return single;
    }

    public int singleNumber5(int [] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i +=2){
            if(i == nums.length - 1 || nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }



}
