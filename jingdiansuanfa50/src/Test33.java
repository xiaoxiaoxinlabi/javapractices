public class Test33 {

//  【程序33】题目：打印出杨辉三角形（要求打印出10行如下图）

//   程序分析：
//            1
//           1 1
//          1 2 1
//         1 3 3 1
//        1 4 6 4 1
//      1 5 10 10 5 1
//      1、二维数组的使用
//2、第一列的数都是1
//3、使用两个for循环，i控制行，j控制列；
//  从第二行第二列起arr[i][j]=arr[i-1][j-1]+arr[i-1][j]


  public static  void main(String [] args){

    int [][] arr = new int [10][10];
    for(int i = 0; i < arr.length; i ++){
      arr[i][0] = 1;
    }

    for(int i = 1; i < arr.length; i ++){
      for(int j = 1; j < arr.length; j ++){
        arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
      }
    }

    for(int i = 0; i < arr.length; i++){
      for(int k = 0; k < arr.length - i; k++){
        System.out.print(" ");
      }
      for(int j = 0; j < arr.length; j ++){
        if(arr[i][j] !=0){
              System.out.println(arr[i][j]);
        }
      }
      System.out.println();
    }
  }


}
