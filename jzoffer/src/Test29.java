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
    if(nums.length == 0){
      return new int [0];
    }
    int left = 0, right = nums[0].length-1, top = 0, bottom = nums.length-1, x=0;
    int [] res = new int[(right+1) * (bottom + 1)];
    while(true){

//      left to right
      for(int i = 1; i <=right; i++){
        res[x++]=nums[top][i];

      }
      if(++top > bottom){
        break;
      }
//      top to bottom
      for(int i = top; i < bottom; i ++ ){
        res[x++]=nums[i][right];
      }
      if(left > --right){
        break;
      }
//      right to left
      for(int i = right; i >=left; i --){
        res[x++]=nums[bottom][i];
      }
      if(top > --bottom){break;}

//      bottom to top
      for(int i = bottom; i >=top; i --){
        res[x++] = nums[i][left];

      }
      if(++left > right){break;}

    }
    return res;


  }

}
