package en.maths;

import java.util.Arrays;

public class MinMoves_453 {
//    给定大小为n的非空整数数组，请找到使所有数组元素相等所需的最小移动数，其中移动将n-1个元素增加1。
//    关键思想：将n-1个元素加1以使所有元素相等具有与将1个元素减1使其相等相等的效果。因此，问题被转换为：每次我们选择一个元素并将其减少1。我们需要多少步才能使所有元素相等？
//    答案是，我们需要多少步才能使所有元素等于最小元素。

//    m = sum - min * n
    public int minMoves(int[] nums) {

        int sum = nums[0];
        int minValue = nums[0];
//        int minValue = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i ++){
            sum+=nums[i];
            if(nums[i] < minValue){
                minValue = nums[i];
//                minValue = Math.min(min, nums[i]);
            }
        }

        return sum - (minValue * nums.length);


    }

    public int minMoves1(int [] nums){
        if(nums == null || nums.length < 1){
            return 0;
        }
        if(nums.length == 2){
            return Math.abs(nums[1] - nums[0]);
        }
        Arrays.sort(nums);
        int [] moves = new int[nums.length];
        for(int i = 1; i < nums.length; i ++){
            moves[i] = nums[i] - nums[0];
        }
        int sum = 0;

        for(int i = 0; i < nums.length; i ++){
            sum+=moves[i];
        }
        return sum;
    }

    public int minMoves2(int [] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = nums[0];
        for(int i : nums){
            if(i < min){
                min = i;
            }
        }
        int steps = 0;
        for(int i : nums){
            steps = steps + (i-min);
        }
        return steps;
    }
}
