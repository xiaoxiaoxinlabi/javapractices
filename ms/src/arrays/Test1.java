package arrays;

import java.util.ArrayList;

public class Test1 {

  public static void printMatrix(int [] [] arr, int start, int end){

    if(start > end || end < 0){
      return;
    }

//    打印第一行

    for(int i = start; i <=end; i ++){
      System.out.println(arr[start][i]);
    }

//    打印最后一列

    for(int i=start+1; i <=end; i++){
      System.out.println(arr[i][end]);
    }

//    打印最后一行

    for(int i = end-1; i>= start; i --){
      System.out.print(arr[end][i]);
    }

//    打印第一列

    for(int i = end - 1; i>=start+1; i--){
      System.out.print(arr[i][start]);
    }

//    递归调用
    printMatrix(arr, start+1, end-1);
  }


//  从外圈到内圈顺序的依次打印，我们就可以把矩阵想象成若干个圈
//  我们可以用一个循环来打印矩阵，每一次打印矩阵中的一个圈
//  于是可以在矩阵中选取左上角为（start，start）的一圈作为我们的分析的目标

//  可以看出可以把问题划分为每次打印一个圈，每个圈的起始坐标为[0,0]，[1,1]，[2,2]
  public static ArrayList<Integer> printMatrixClockwisely(int [] [] arr){
    ArrayList <Integer> arrayList = new ArrayList<>();
    int rows = arr.length;
    int cols = arr[0].length;
    if(arr == null || cols <= 0 || rows <= 0){
      return null;
    }

    int start = 0;
//    可以通过条件(rows > 2 * index && cols > 2 * index) 来判断是否打印结束
    while(cols > start * 2 && rows > start *2){
      prints(arrayList, arr, cols, rows, start);
      ++start;
    }
    return arrayList;
  }

//  第一步肯定是必须的
//  第二步：至少要有两行，即终止行号大于起始行号
//  第三步：至少要有两行两列，即终止行号大于起始行号 且 终止列号大于起始列号
//  第四步：至少要有三行两列，即终止行号—起始行号 >=2 且 终止列号大于起始列号
  public static void prints(ArrayList<Integer> list , int [][] arr, int cols, int rows, int starts){

    int endX = cols - 1 - starts;
    int endY = rows - 1 - starts;

//    从左到右打印一行
    for(int i = starts; i <= endX; ++i){
      list.add(arr[starts][i]);
    }
//    从上倒下打印一列
    if(starts < endY){
      for(int i = starts + 1; i<=endY; ++i){
        list.add(arr[i][endY]);
      }
    }

//    从右向左打印一行
    if(starts < endX && starts < endY){
      for(int i = endX - 1; i >= starts; --i){
        list.add(arr[endY][i]);
      }
    }

//    从下向上打印一列
    if(starts < endX && starts < endY-1){
      for(int i = endY-1; i>=starts +1; --i){
        list.add(arr[i][starts]);
      }
    }

  }

  public static void main(String [] args){


  }

}
