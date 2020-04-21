import java.util.ArrayList;
import java.util.List;

public class Test57b {
//  和为s的连续正数序列

//  输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//  序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//  输入：target = 9
//  输出：[[2,3,4],[4,5]]

//  要用滑动窗口解这道题，我们要回答两个问题：
//  第一个问题，窗口何时扩大，何时缩小？
//
//  当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
//  当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
//  当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)[i,j)，那么我们已经找到了一个 ii 开头的序列，也是唯一一个 ii 开头的序列，接下来需要找 i+1i+1 开头的序列，所以窗口的左边界要向右移动


  public int [][] findContinuousSequence(int target){
//滑动窗口的左边界
    int i = 1;
//    滑动窗口的右边界
    int j = 1;
//    滑动窗口中数字的和
    int sum = 0;
    List<int []> res = new ArrayList<>();

    while(i <=target / 2){

//      如果当前数字的和小于目标值，则窗口右边界向右移动
      if(sum < target){
        sum+=j;
        j++;

//        如果当前数字的和大于目标值，则窗口左边界向右移动
      }else if(sum > target){
        sum-=i;
        i++;
      }else{

//        如果相等，则记录结果
        int [] arr = new int[j-i];
        for(int m = 0; m <j; m++){
          arr[m-i]=m;
        }
        res.add(arr);

//        左边界向右移动
        sum-=i;
        i++;
      }
    }

//    将集合转换成数组
    return res.toArray(new int [res.size()][]);


  }

}
