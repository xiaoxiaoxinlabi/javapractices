package arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//找出数组中的最大值
public class ArrayDoSomeThing {

  public int findMax(int[] a) {

    int max = a[0];

    for (int i = 0; i < a.length; i++) {

      if (a[i] > max) {
        max = a[i];
      }
    }

    return max;
  }


//计算数组元素的平均值
  public double getAverage(double [] a){

    double sum = 0.0;
    int N = a.length;
    for (int i = 0; i < N; i ++){
      sum += a[i];
    }

    double average = sum / N;

    return  average;

  }



//复制数组
  public double [] copyArray(int [] a){

    int N = a.length;
    double  [] b = new double[N];
    for (int i = 0; i < N; i ++){
      b[i] = a[i];
    }

    return b;
  }


//  颠倒数组元素的顺序

  public int [] reverseArray(int [] a){

    int N = a.length;
    for (int i = 0; i < N/2; i ++){

      int temp = a[i];
      a[i] = a[N - i - 1];
      a[N - i - 1] = temp;
    }

    return a;
  }

  public double [][] matrix(double [][] a){

    int N = a.length;
    double c [][] = new double[N][N];

    for(int row = 0; row < N; row ++){
      for (int col = 0; col < N; col ++){

        for (int k = 0; k < N; k ++){

          c[row][col] += a[row][k] * a[k][col];

        }

      }
    }

    return c;
  }



//  将结果打印输出
  public static void prints(Object obj) {

    if (obj instanceof int[]) {

      int[] a = (int[]) obj;

      for (int i = 0; i < a.length; i++) {

        System.out.println(a[i]);
      }
    } else if (obj instanceof double[]) {
      double[] a = (double[]) obj;

      for (int i = 0; i < a.length; i++) {
        System.out.println(a[i]);
      }

    } else if (obj instanceof double[][]) {

      double[][] a = (double[][]) obj;

      for (int i = 0; i < a.length; i++) {

        for (int j = 0; j < a[i].length; j ++){

          System.out.println(a[i][j]);
        }


      }
    }

  }

//  遍历二维数组

  public static void iteaArray(int[][] arr) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.println(arr[i][j] + ", ");
      }
    }

  }

  //  遍历二维数组: 使用 deepToString()
  public static void iteaArray1(double[][] arr) {

    System.out.println(Arrays.deepToString(arr));

  }

//  遍历一维数组:  转换成string

  public static void iteaArray0(int [] arr){
    System.out.println(Arrays.toString(arr));
  }




  public static void main(String [] args) {

    ArrayDoSomeThing arrayDoSomeThing = new ArrayDoSomeThing();
    int [] a = {1,2,3,8,0,0,23};

    double [] da = {1,2,3,9.9};

    double [][] doublea = {{1,2,1},{4,3,1}};

    Map map = new HashMap<Integer, Integer>();
    map.put(1,1);

    iteaArray1(doublea);
    iteaArray0(a);





//    System.out.println(arrayDoSomeThing.findMax(a));
//    System.out.println(arrayDoSomeThing.getAverage(da));
//    prints(arrayDoSomeThing.copyArray(a));
//    prints(arrayDoSomeThing.reverseArray(a));
//    prints(arrayDoSomeThing.matrix(doublea));
//    prints(doublea);








  }




}