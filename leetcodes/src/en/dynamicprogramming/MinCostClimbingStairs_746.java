package en.dynamicprogramming;

public class MinCostClimbingStairs_746 {

//    在楼梯上，第i步分配了一些成本cost [i]（索引为0）。
//    一旦你支付了费用，你可以爬上一或两级台阶。你需要找到到达顶层的最小代价，你可以从索引0的步骤开始，或者从索引1的步骤开始。


    public int minCostClimbingStairs(int[] cost) {

        int size = cost.length;
//        从索引2 遍历数组
        for(int i = 2; i < size; i++){

            cost[i] = cost[i] + Math.min(cost[i-1], cost[i-2]);
        }

        return Math.min(cost[size-1], cost[size-2]);

    }

    public int minCostClimbingStairs1(int[] cost){
        int step1 = 0;
        int step2 = 0;

        for(int i = cost.length-1; i >= 0; i--){
            int step0 = cost[i] + Math.min(step1,step2);
            step2 = step1;
            step1 = step0;
        }
        return Math.min(step1, step2);
    }

    public int minCostClimbingStairs2(int[] cost){
        final int [] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        dp[2] = Math.min(dp[0] + cost[2], dp[1]+cost[2]);

        for(int i = 3; i < dp.length; i ++){
            final int currcost = i < cost.length ? cost[i] : 0;
            dp[i] = Math.min(dp[i-1] + currcost, dp[i-2]+currcost);
        }
        return dp[dp.length-1];
    }

}
