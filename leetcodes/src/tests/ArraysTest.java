package tests;

public class ArraysTest {

    /*
    找出数组中最大的元素
     */
  public double findTheMax(double [] arr){
    double max = arr[0];
    for(int i = 0; i < arr.length; i++){
      if (arr[i] > max){
        max = arr[i];
      }
    }
    return max;

  }

/*
 计算数组元素的平均值
 */
    public double findTheAverage(double [] arr){
      int n = arr.length;
      double sum = 0.0;
      double average ;
      for (int i = 0; i < n; i ++){
        sum += arr[i];
      }
      average = sum / n;
      return average;
    }

  public double [] copyTheArrays(double [] arr){
    int n = arr.length;
    double [] b = new double[n];
    for (int i = 0; i < n; i ++){
      b[i] = arr[i];
    }
    return b;

  }

  /**
   * 反转数组
   * @param arr
   * @return
   */
  public double [] reverseTheArrays(double [] arr){
    int n = arr.length;
    for (int i = 0; i < n/2; i ++){
      double temp = arr[i];
      arr[i] = arr[n - 1 - i];
      arr[n - 1 - i] = temp;

    }
    return arr;
  }


  /**
   * 矩阵相乘 a [][] * b[][] = c[][]
   * @param arr1
   * @param arr2
   * @return
   */
  public double[][] Matrixmultip(double [][] arr1, double [][] arr2){
    int n = arr1.length;
    double [][] c = new double[n][n];
    for (int i = 0; i < n; i ++){
      for (int j = 0; j < n; j ++){
//        计算行i 和列 j的点乘
        for(int k = 0; k < n; k ++){
          c[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }
    return c;

  }


  /**
   * 打印结果
   * @param args ：调用的方法
   */
  public static void printResults(Object args){
    System.out.println(args);

  }


  public static void main(String [] args){
    ArraysTest arraysTest = new ArraysTest();
    double [] arrs =  {1,2,3,4,5,6,7,7,8,2,3,5555,0};
//    printResults(arraysTest.findTheMax(arrs));
    printResults(arraysTest.reverseTheArrays(arrs)[1]);


  }




}
