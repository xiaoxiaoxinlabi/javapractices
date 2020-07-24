package en;

public class CheckStraightLine_1232 {

//  给定一个数组判断数组中的点是否可以连成一条直线

//  为了确定这些点是否形成直线，我们需要使用以下公式找到两个点[x1，y1]和[x2，y2]的斜率。

//  slope = (y2 - y1) / (x2 - x1)

//  Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//  Output: true

//  Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//  Output: false

  public static boolean checkStraightLine1(int [][] arr){

    if(arr.length == 2){
      return true;
    }
    for(int i = 1; i < arr.length - 1; i ++){
      int x1 = arr[i-1][0], y1 = arr[i-1][1];
      int x2 = arr[i][0], y2 = arr[i][1];
      int x3 = arr[i+1][0], y3 = arr[i+1][1];

//      (y2-y1)/(x2-x1) == (y3-y2)/(x3-x2)
      if((y2 - y1) *(x3-x2) !=(y3-y2) * (x2-x1)){
        return false;
      }
    }
    return true;

  }

  public static boolean checkStraightLine2(int [] []arr){
    if(arr.length   <=1){
      return true;
    }
    for(int i = 2; i < arr.length; i ++){
      double x1 = arr[i-2][0];
      double x2 = arr[i-1][0];
      double x3=arr[i][0];

      double y1 = arr[0][i-2];
      double y2 = arr[0][i-1];
      double y3=arr[0][i];

      double prvrun = x2 - x1;
      double run = x3 - x2;
      double prvrise = y2 - y1;
      double rise = y3 - y2;

      if(run == 0 && prvrun == 0 || rise == 0 && prvrise == 0){
        continue;
      }else if((prvrise / prvrun) != (rise / run)){
        return false;
      }
      }
    return true;
    }
  }


