package en.maths;

public class SmallestRangeI_908 {

//    给定一个整数数组A，对于每个整数A [i]，我们可以选择-K <= x <= K的任意x，并将x加到A [i]。
//    完成此过程后，我们得到了一些数组B。
//    返回B的最大值和B的最小值之间的最小可能差。

    public int smallestRangeI(int[] A, int K) {

        int min = A[0];
        int max = -1;
        for(int i = 0; i < A.length; i ++){
//            循环数组，找到最大的值与最小的值
            if(A[i] < min){
                min = A[i];
            }
            if(A[i] > max){
                max = A[i];
            }
        }
//        如果最大的值减去 K 小于等于 最小的值加K;则返回0
        if(max - K <= min + K){
            return 0;
        }else{
//            否则返回两者之差
            return (max - K) - (min + K);
        }

    }

    public int smallestRangeI1(int [] A, int K){
        int smallestRange = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
//        循环遍历找到数组中的最小值，最大值
        for(int i = 0; i < A.length; i ++){
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
//        将最小值加上K,最大值加上 -k
        int back = min + K;
        int front = max - K;

//        如果最大的与最小的差值为负则返回 0
        if(front <= back || back > front){
            smallestRange = 0;
        }else{
//            否则返回最小差值
            smallestRange = front - back;
        }
        return smallestRange;
    }
}
