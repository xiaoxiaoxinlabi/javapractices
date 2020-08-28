package en.sorts;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class SortByBits_1356 {

//    给定一个整数数组arr。您必须按其二进制表示形式中的1的数目按升序对数组中的整数进行排序，并且如果两个或多个整数具有相同的1的个数，则必须按升序对它们进行排序。
//    返回排序后的数组。
//
//    Example 1:
//
//    Input: arr = [0,1,2,3,4,5,6,7,8]
//    Output: [0,1,2,4,8,3,5,6,7]
//    Explantion: [0] is the only integer with 0 bits.
//[1,2,4,8] all have 1 bit.
//[3,5,6] have 2 bits.
//[7] has 3 bits.
//    The sorted array by bits is [0,1,2,4,8,3,5,6,7]

    public int[] sortByBits(int[] arr) {

//        将数组进行升序排列
        Arrays.sort(arr);
//        max 为数组最后一个元素
        int max = arr[arr.length - 1];
//        定义数组dp 用于统计数字转换为2进制之后的1的个数
        int [] dp = new int[max+1];

//        二位数组sum 每一行都是： 数组转换为二进制之后其1 出现的个数；
        int[][] sum = new int[arr.length][2];
//        统计从0 到 max的所有数字转换为二进制之后，的所有位数上的数字之和，也就知道了有几个1
        for(int i = 0; i < max + 1; i++){
            dp[i] = dp[i/2] + i % 2;
        }

//        遍历数组arr, 对数组sum进行赋值
        for(int i = 0; i < arr.length; i++){
//            第i行第一列为 该元素中的二进制的1的个数； 第二列为：改元素的十进制
            sum[i][0] = dp[arr[i]];
            sum[i][1] = arr[i];
        }

//        对数组进行排序
        Arrays.sort(sum,(arr1, arr2) ->Integer.compare(arr1[0],arr2[0]));

//        将sum的第二列赋给最终输出的数组
        int [] output = new int[arr.length];
        for(int i = 0; i < arr.length; i ++){
            output[i] = sum[i][1];
        }
        return output;

    }

    public int[] sortByBits1(int [] arr){
       boolean sorted = false;
       while(!sorted){
           sorted = true;
//           循环遍历数组
           for(int i = 0; i < arr.length - 1; i++){
//               如果当前元素的1个数大于下一个元素的1 个数； 则交换
               if(numOnes(arr[i]) > numOnes(arr[i+1])){
                   int temp = arr[i];
                   arr[i] = arr[i+1];
                   arr[i+1] = temp;
                   sorted = false;
//                   如果前后两个元素的1的个数相等，则比较两个元素的大小，交换将大的放在前面
               }else if(numOnes(arr[i]) == numOnes(arr[i+1])){
                   if(arr[i] > arr[i+1]){
                       int temp = arr[i];
                       arr[i] = arr[i+1];
                       arr[i+1] = temp;
                       sorted = false;
                   }
               }
           }
       }
       return arr;
    }

//    将数字转换为2进制，并统计其中的1的个数
    private int numOnes(int num) {
        int ctr = 0;
//        统计数组对2 求余的 1 的个数
        while(num != 0){
            if(num % 2 == 1){
                ctr++;
            }
            num /= 2;
        }
        return ctr;
    }
}
