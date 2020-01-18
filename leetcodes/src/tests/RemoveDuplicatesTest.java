package tests;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesTest {

//    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    public int removeDuplicates(int[] nums) {

        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        return s.size();
    }


    public int removeDuplicates1(int [] nums){

        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length ; i ++){

            if (nums[i] != nums[j]){
                j ++;

                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {

        RemoveDuplicatesTest r = new RemoveDuplicatesTest();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(r.removeDuplicates1(nums));


    }
}
