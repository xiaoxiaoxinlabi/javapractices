public class Test29 {

//  顺时针打印矩阵
//  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

//  解题思路：

//  根据题目示例 matrix = [[1,2,3],[4,5,6],[7,8,9]]的对应输出 [1,2,3,6,9,8,7,4,5]可以发现，顺时针打印矩阵的顺序是 “从左向右、从上向下、从右向左、从下向上”循环。;

//  算法流程：
//  空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
//  初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
//  循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
//  根据边界打印，即将元素按顺序添加至列表 res 尾部；
//  边界向内收缩 11 （代表已被打印）；
//  判断是否打印完毕（边界是否相遇），若打印完毕则跳

  public int [] spiralOrder(int [] []nums){

//    当nums为空时，返回空
    if(nums.length == 0){
      return new int [0];
    }
//    初始化边界：左（left）,右（right）,上（top）,下（bottom）
    int left = 0, right = nums[0].length-1, top = 0, bottom = nums.length-1, x=0;

//    初始化需要存储数据的数组
    int [] res = new int[(right+1) * (bottom + 1)];
    while(true){

//      left to right：从左到右打印: top是不变的;
//
      for(int i = 1; i <=right; i++){
        res[x++]=nums[top][i];

      }
//      边界向内收缩：上边界 + 1； 如果 top > bottom 则打印完毕
      if(++top > bottom){
        break;
      }
//      top to bottom  从上向下打印： right 不变

      for(int i = top; i < bottom; i ++ ){
        res[x++]=nums[i][right];
      }

//      边界向内收缩：右边界减1； 如果左边界 > 右边界 则打印完毕
      if(left > --right){
        break;
      }
//      right to left 从右向左打印： bottom不变
      for(int i = right; i >=left; i --){
        res[x++]=nums[bottom][i];
      }

//      边界向内收缩：下边界-1； 如果 上边界 > 下边界  则打印完毕
      if(top > --bottom){break;}

//      bottom to top 从下向上打印： left 不变
      for(int i = bottom; i >=top; i --){
        res[x++] = nums[i][left];

      }

//      边界向内收缩：左边界+1  ； 如果左边界 > 右边界 则打印完毕
      if(++left > right){break;}

    }
    return res;


  }

}
