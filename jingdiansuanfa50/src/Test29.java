public class Test29 {

//  题目：求一个3*3矩阵对角线元素之和

  public static void  fun1(){

    int [][] arr = new int[3][3];
    int sum = 0;

    for(int i = 0; i <3; i ++){
      for(int j = 0; j < 3; j ++){

        if(i == j){

          sum+=arr[i][j];
        }
      }
    }

  }


}
