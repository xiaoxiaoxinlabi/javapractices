package en.maths;

import java.util.ArrayList;

public class NthUglyNumber_264 {

//    编写程序以查找输出第n个丑数。
//    丑数是正数，其主要因子仅包括2、3、5。

//    Example:
//
//    Input: n = 10
//    Output: 12
//    Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

    // dp bottom up
    // time complexity=O(n)
    // space complexity=O(n)
    // 3 arrays store the result*[2,3,5]
    // UglyNumbers: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
    // dp[0] 1×2, 2×2, 3×2, 4×2, 5×2, …
    // dp[1] 1×3, 2×3, 3×3, 4×3, 5×3, …
    // dp[2] 1×5, 2×5, 3×5, 4×5, 5×5, …
    // subproblem=min(dp[0][a],dp[1][b],dp[2][c])
    // then a++ or b++ or c++
    // imaging they are three queues
    // every time will choose the smallest one in top of the 3 queues
    // then the smallest one will pop out from that queue

    public int nthUglyNumber(int n) {

//        定义一个3行n的数组用于统计所有的 丑数
        int [][] dp = new int[3][n+1];
        int result = 1;
        int a = 0;
        int b = 0;
        int c = 0;

        for(int i = 0; i < n - 1; i ++){
            dp[0][i] = result * 2;
            dp[1][i] = result * 3;
            dp[2][i] = result * 5;
//            找到三行中最小的值
            result = Math.min(Math.min(dp[0][a], dp[1][b]), dp[2][c]);

            if(result == dp[0][a]){
                a++;
            }
            if(result == dp[1][b]){
                b++;
            }
            if(result == dp[2][c]){
                c++;
            }
        }
        return result;
    }

    public int nthUglyNumber1(int n){
        ArrayList<Integer> uglynums = new ArrayList();
        uglynums.add(1);

        int indexOf2 = 0, indexOf3 = 0, indexOf5 = 0;
        while(uglynums.size() <= n){
            int productBy2 = uglynums.get(indexOf2) * 2;
            int productBy3 = uglynums.get(indexOf3) * 3;
            int productBy5 = uglynums.get(indexOf5) * 5;

            int min = Math.min(Math.min(productBy2, productBy3),productBy5);

            if(productBy2 == min){
                uglynums.add(productBy2);
                indexOf2++;
            }
            if(productBy3 == min){
                if(productBy3 != productBy2){
                    uglynums.add(productBy3);
                }

                indexOf3++;
            }
            if(productBy5 == min){
                if(productBy5 != productBy2 && productBy5 != productBy3){
                    uglynums.add(productBy5);
                }

                indexOf5++;
            }
        }
        return uglynums.get(n-1);
    }

    public int nthUglyNumber2(int n){
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return 1;
        }
        int p2 = 0, p3 = 0, p5 = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i ++){
            dp[i] = Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));
            if(dp[i] == dp[p2]*2){
                p2++;
            }
            if(dp[i] == dp[p3]*3){
                p3++;
            }
            if(dp[i] == dp[p5]*5){
                p5++;
            }

        }
        return dp[n-1];
    }
}
