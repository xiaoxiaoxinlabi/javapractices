package en.hashTable;

import java.util.HashMap;
import java.util.Map;

public class FindLength_718 {

//    给定两个整数数组A和B，返回两个数组中出现的子数组的最大长度
//    Example 1:
//    Input:
//    A: [1,2,3,2,1]
//    B: [3,2,1,4,7]
//    Output: 3
//    Explanation:
//    The repeated subarray with maximum length is [3, 2, 1].

//                1 2 3 2 1
//               3 0 0 1 0 0
//               2 0 1 0 2 0
//               1 1 0 0 0 3
//               4 0 0 0 0 0
//               7 0 0 0 0 0

//    这是一个动态规划问题的模式。我们创建了一个2d dp数组，并采用了自底向上的方法。
//    当我们看到A[i] = B[j]时，我们更新dp[i][j] = dp[i+1][j+1] +1。

    public int findLength(int[] A, int[] B) {

//        采用分散矩阵
        int dp[][] = new int[A.length][B.length + 1];
        int ans = 0;

        for(int i = 1; i <= A.length; i ++){
            for(int j = 1; j <= B.length; j ++){
//                如果A与B有相同的元素，则将两者相交的位置设置为 1
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;

    }

    public int findLength1(int [] A, int [] B){
        int dp[][] = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for(int i = A.length - 1; i >= 0; i --){
            for(int j = B.length - 1; j >= 0; j --){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1]+1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public int findLength2(int [] A, int [] B){
        int sizeA = A.length;
        int sizeB = B.length;
        // dp1 is previous dp array
        int [] dp1 = new int[Math.max(sizeA,sizeB)];
        // dp2 is current dp array
        int [] dp2 = new int[Math.max(sizeA,sizeB)];

        int max = 0;

        for(int i = 0; i < sizeA; i ++){
            for(int j = 0; j < sizeB; j ++){
                if(A[i] == B[j]){
                    if(j == 0){
                        dp2[j] = 1;
                    }else{
                        dp2[j] = dp1[j - 1] + 1;
                    }
                    max = Math.max(max, dp2[j]);
                }else{
                    dp2[j] = 0;
                }
            }
            dp1 = dp2.clone();
        }
        return max;
    }

    public int findLength3(int [] A, int [] B){
        int rows = A.length, cols = B.length;
        int [][] dp = new int[rows][cols];
        int max = 0;

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(i - 1 >= 0 && j - 1 >= 0 && A[i] == B[j] && A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else if(A[i] == B[j]){
                    dp[i][j] = 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


}
