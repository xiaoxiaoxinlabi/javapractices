package tests;

public class SearchInsertTest {

//    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    public int searchInsert(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int m = (i + j) / 2;
            if (target > nums[m]) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return j;
    }

    public int searchInsert1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (target > nums[mid]) {
                i = mid + 1;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return i;

    }

    public static void main(String[] args) {

        SearchInsertTest se = new SearchInsertTest();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(se.searchInsert(nums, target));


    }
}
