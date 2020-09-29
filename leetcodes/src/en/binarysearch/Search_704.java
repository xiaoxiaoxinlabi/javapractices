package en.binarysearch;

public class Search_704 {

//    给定一个排好序的数组，和一个目标值，查找目标值是否在数组中存在，如果存在返回其索引，如果不存在，则返回-1

//    Input: nums = [-1,0,3,5,9,12], target = 9
//    Output: 4
//    Explanation: 9 exists in nums and its index is 4

    public int search(int[] nums, int target) {

            int left = 0, right = nums.length;
            while(left < right){
                int mid = left + (right - left)/2;

                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid] > target){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            return -1;

    }
}
