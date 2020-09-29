package en.dynamicprogramming;

public class Rob_198 {

//    您是计划在街道上抢房屋的专业强盗。每栋房屋都藏有一定数量的钱，阻止您抢劫每座房屋的唯一限制是相邻房屋都已连接了安全系统，如果在同一晚闯入两栋相邻房屋，它将自动与警方联系。
//    给定代表每个房屋的金额的非负整数列表，请确定您今晚可在不通知警察的情况下抢走的最大金额

//    即：找到数组中相隔元素的最大值

//    Example 1:
//
//    Input: nums = [1,2,3,1]
//    Output: 4
//    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//    Total amount you can rob = 1 + 3 = 4.

    public int rob(int[] nums) {

        int dp1 = 0, dp2 = 0, max_acount = 0;
        for(int num: nums){
            max_acount = Math.max(dp2, num+dp1);
            dp1 = dp2;
            dp2 = max_acount;
        }
        return max_acount;

    }

    public int rob1(int [] nums){
        if(nums.length == 0){
            return 0;
        }
        int incl = nums[0],excl = 0;
        for(int i = 1; i < nums.length; i ++){
            int temp = incl;
            incl = Math.max(incl, excl+nums[i]);
            excl = temp;
        }
        return Math.max(incl, excl);
    }

    public int rob2(int [] nums){
        if(nums.length == 0){
            return 0;
        }
        if(nums.length== 1){
            return nums[0];
        }
        // {从上上个房子之前可以偷到的最多钱，从上个房子之前可以偷到的最多钱}
        int [] value = {0,0};
        int temp = 0;
        for(int i = 0; i < nums.length; i ++){
            if(i == 0){
                value[i] = nums[i];
            }
            if(i == 1){
                value[i] = Math.max(nums[0],nums[1]);
            }
            if(i > 1){
                // 如果偷第 i 个房子赚钱多：上个房子 变成 上上个房子，i 房子变成 上个房子
                if(nums[i]+value[0] > value[1]){
                    temp = nums[i] + value[0];
                    value[0] = value[1];
                    value[1] = temp;
                }else{
                    // 如果偷第 i 个 房子赚钱不多，就不偷了，第 i 个房子的最多钱 = 上个房子的最多钱，i 房子变成 上个房子
                    value[0] = value[1];
                }
            }
        }
        return value[1];

    }

    public int rob3(int [] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int evenHouse = 0, oddHouse = 0;
        for(int i = 0; i < nums.length; i ++){
            if(i % 2 == 0){
                evenHouse+= nums[i];
                evenHouse = evenHouse > oddHouse ? evenHouse:oddHouse;
            }else{
                oddHouse+=nums[i];
                oddHouse = evenHouse > oddHouse ? evenHouse:oddHouse;
            }
        }
        return evenHouse > oddHouse ? evenHouse : oddHouse;
    }

    public int rob4(int [] nums){

//        如果长度为 0 则返回0
        if(nums.length == 0){
            return 0;
        }
//        如果长度为1 ，则返回改元素
        if(nums.length == 1){
            return nums[0];
        }
//        如果长度为2 ，则返回最大的元素
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

//        定义一个数组，其中 索引0 存放 nums[0], 索引1存放 nums[0],Nums[1]中最大的值

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

//        从索引2 处遍历数组nums
        for(int i = 2; i < nums.length; i ++){
//            找出dp[i-1]，与dp[i-2]+nums[i] 中最大的值，付给dp[i]
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
//        返回dp中的最后一个值
        return dp[nums.length-1];
    }


}
