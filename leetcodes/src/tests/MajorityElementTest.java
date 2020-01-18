package tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementTest {

//    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//    你可以假设数组是非空的，并且给定的数组总是存在众数。

    public int majorityElement(int[] nums) {
        int temp = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);

            }

            if (map.get(nums[i]) > temp) {
                return nums[i];
            }

        }

        return 0;


    }

//    排好序之后，中间的数即使众数
    public int majorityElement1(int [] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int [] nums){
        int majorityElement = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            //If count is 0, keep the current element as majority (No majority found till now)
            if (count == 0){
                majorityElement = i;
            }
            //If current element as same as Majority till now, inc the count
            if (majorityElement == i){
                count++;
                //If not, decrease the count to keep track of other numder coming along
            }else{
                count --;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        MajorityElementTest majorityElementTest = new MajorityElementTest();
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
//        int[] arr = {3,2,3};
        System.out.println(majorityElementTest.majorityElement(arr));

    }
}
