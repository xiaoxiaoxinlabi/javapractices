public class Test11 {


//  旋转数组的最小数字
//  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//  输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 

//  输入：[3,4,5,1,2]
//  输出：1


//  如下图所示，寻找旋转数组的最小元素即为寻找 右排序数组 的首个元素 numbers[x] ，称 xx 为 旋转点 。
//  排序数组的查找问题首先考虑使用 二分法 解决，其可将遍历法的 线性级别 时间复杂度降低至 对数级别 。

//  设置 i, j指针分别指向 numbers 数组左右两端，m = (i + j) //2 为每次二分的中点（ "//" 代表向下取整除法，因此恒有 i <= m < j ），可分为以下三种情况：

  public int minArray(int[] numbers){
    int i = 0, j = numbers.length-1;
    while(i < j){
      int m = (i+j)/2;
      //  当 numbers[m] > numbers[j]时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m + 1, j]闭区间内，因此执行 i = m + 1
      if(numbers[m] > numbers[j]){
        i = m +1;
        //  当 numbers[m] < numbers[j] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[i, m] 闭区间内，因此执行 j = m
      }else if (numbers[m] < numbers[j]){
        j = m;
      }else{
        //  当 numbers[m] == numbers[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [i, m] 还是 [m + 1, j] 区间中。解决方案： 执行 j = j - 1 缩小判断范围 （分析见以下内容）

        j--;
      }
    }

    return numbers[i];

  }

}
