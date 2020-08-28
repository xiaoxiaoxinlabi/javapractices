package en.sorts;

import java.util.Arrays;

public class LargestPerimeter_976 {
//    给定一个正长度的数组A，返回由三个长度组成的面积不为0 的三角形的最大周长。
//
//    Example 1:
//
//    Input: [2,1,2]
//    Output: 5
//    Example 2:
//
//    Input: [1,2,1]
//    Output: 0
//    Example 3:
//
//    Input: [3,2,3,4]
//    Output: 10
//    Input: [3,6,2,3]
//    Output: 8

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--){
            if(A[i-2] + A[i-1] > A[i]){
                return A[i]+A[i-1]+A[i-2];
            }
        }
        return 0;

    }

    public int largestPerimeter1(int [] A){
        Arrays.sort(A);
        int idx = A.length - 1;
        while (idx - 2 >= 0){
            if(A[idx] < A[idx-1]+A[idx-2]){
                return A[idx]+A[idx-1]+A[idx-2];
            }
            idx--;
        }
        return 0;
    }
}
