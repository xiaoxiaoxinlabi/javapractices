package en;

public class CountNegatives_1351 {

//  给定一个多维数组，返回数组中的负数的个数

  public int countNegatives1(int [][] gird){
    int count = 0;
    for(int i = 0; i < gird.length; i ++){
      for(int j = 0; j < gird[i].length; j ++){
        if(gird[i][j] < 0){

          count ++;
        }
      }
    }
    return count;
  }


//  /从左下角开始。由于行和列以降序排序
//可以使用它在每一行中搜索负数。我们一直往前走，直到我们
//查找连续的第一个负数。每次遇到连续第一个负数时，我们都知道
//之后的每个数字也将为负数。减去行的长度和当前
//列索引以找出还剩下多少个负数。然后将列上移至行
//直到找到第一个正数，然后执行与刚才相同的减法运算
//遇到的每个负数。一旦找到第一个正数，我们就会开始向右移动
//搜索第一个负数。直到到达矩阵的顶部或右侧边框为止。

  public int countNegatives2(int [][] gird){
    int n = gird[0].length, row = gird.length - 1, col = 0, negs = 0;
    while(row>=0 && col < n){
      if(gird[row][col] < 0){
        negs+=(n - col);
        row--;
      }else{
        col++;
      }
    }
    return negs;
  }
}
