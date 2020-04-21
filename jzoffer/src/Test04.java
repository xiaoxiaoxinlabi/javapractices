public class Test04 {

//  二维数组中的查找
//  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数

//  方法一：暴力

//  如果不考虑二维数组排好序的特点，则直接遍历整个二维数组的每一个元素，判断目标值是否在二维数组中存在。
//
//  依次遍历二维数组的每一行和每一列。如果找到一个元素等于目标值，则返回 true。如果遍历完毕仍未找到等于目标值的元素，则返回 false。

  public boolean findNumberIn2DArray1(int[][] nums, int target) {
    if (nums == null || nums.length == 0 || nums[0].length == 0) {
      return false;
    }

    int rows = nums.length, cloumns = nums[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cloumns; j++) {
        if (nums[i][j] == target) {
          return true;
        }
      }
    }

    return false;
  }

//方法二:线程查找
//
// 利用二叉树的原理（左子节点小，右子节点大）
//  从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。

  public boolean findNumberIn2DArray2(int[][] nums, int target) {

//    若数组为空，返回 false
    if (nums == null || nums.length == 0 || nums[0].length == 0) {
      return false;
    }

    int rows = nums.length, columns = nums[0].length;
//    初始化行下标为 0，列下标为二维数组的列数减 1
    int row = 0, column = columns - 1;

//    重复下列步骤，直到行下标或列下标超出边界
//    获得当前下标位置的元素 num
    while (row < rows && column >= 0) {
      int num = nums[row][column];
      //    如果 num 和 target 相等，返回 true
      if (num == target) {
        return true;
        //    如果 num 大于 target，列下标减 1
      } else if (num > target) {
        column--;
      } else {
        //    如果 num 小于 target，行下标加 1
        row++;
      }

    }

    return false;
  }

}