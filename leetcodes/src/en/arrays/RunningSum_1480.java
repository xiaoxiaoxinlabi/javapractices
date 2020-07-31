package en;

public class RunningSum_1480 {

//
//    给定一个数组nums。我们将数组的运行总和定义为runningSum [i] = sum（nums [0]…nums [i]）。
//    返回数字的运行总和。

    public int [] runningSum1(int [] nums){
        int [] res = new int[nums.length];
//        定义一个sum ,用于计算前i 项的和
        int sum = 0;
//        遍历数组，一次计算前i项的和，然后赋值给res
        for(int i = 0; i <nums.length; i ++){
            sum+=nums[i];
            res[i] = sum;
        }
        return res;
    }

    public int [] runningSum2(int [] nums){
//        从索引i = 1,遍历数组，然后第i 项的值，等于前i-1 项的和加当前项
        for(int i = 1; i < nums.length; i ++){
            nums[i] = nums[i-1]+nums[i];
        }
        return nums;
    }

    public int [] runningSum3(int [] nums){
        int presum = 0;
//        在原数组的基础上，改变原始的值
        for(int i = 0; i < nums.length; i ++){
            nums[i] = presum + nums[i];
            presum = nums[i];
        }

        return nums;
    }
}
