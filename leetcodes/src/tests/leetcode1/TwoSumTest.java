package tests.leetcode1;

public class TwoSumTest {


    public int[] twoSum(int[] nums, int target) {


        int newArray[] = new int[2];
        boolean isLook = false;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j <= nums.length - 1; j++) {

                if (nums[i] + nums[j] == target) {

                    newArray[0] = i;
                    newArray[1] = j;
                    isLook = true;
                    break;
                }
            }
            if (isLook) {
                break;
            }

        }
        System.out.println(newArray[0] + ":" + newArray[1]);
        return newArray;
    }


    public static void main(String[] args) {

        int nums[] = {1, 2, 17, 11, 15, 34, 55, 4, 30};
        int target = 45;
        TwoSumTest t = new TwoSumTest();
        t.twoSum(nums, target);


    }


}
