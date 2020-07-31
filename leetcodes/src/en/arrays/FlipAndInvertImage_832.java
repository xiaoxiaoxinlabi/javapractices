package en;

public class FlipAndInvertImage_832 {

//  给定一个二进制矩阵A，我们想水平翻转图像，然后将其反转，然后返回结果图像。
//
//  水平翻转图像意味着图像的每一行都反转了。例如，水平翻转[1，1，0]会得到[0，1，1]。
//
//  反转图像意味着将每个0替换为1，并将每个1替换为0。例如，将[0，1，1]求反将得到[1，0，0]。

//  Input: [[1,1,0],[1,0,1],[0,0,0]]
//  Output: [[1,0,0],[0,1,0],[1,1,1]]
//  Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//  Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]


  public int[][] flipAndInvertImage1(int[][] arr) {


    int b[][] = new int[arr[0].length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {

//      定义一个一维数组用于存放 每个一维临时变量，k为一维数组中的索引变量
      int a[] = arr[i], k = 0;
      for (int j = a.length - 1; j >= 0; j--) {

//        循环倒序遍历每个一维数组，如果遇到值为0，则将对照着二维数组中的位置的值变为1
        if (a[j] == 0) {
          b[i][k] = 1;

//          否则存 0
        } else {
          b[i][k] = 0;
        }

        k++;
      }
    }

    return b;

  }

  public int [][] flipAndInvertImage2(int [][] arr){
    if(arr == null || arr.length == 0){
      return arr;
    }
    int rows = arr.length;
    for(int i = 0; i < rows; i++){
//      一维数组翻转
      reverse(arr[i]);
//      一维数组中的具体的值翻转
      invertrow(arr[i]);
    }

    return arr;
  }

  private void reverse(int [] input){
    int start = 0;
    int end = input.length - 1;
    while(start < end){
      int temp = input[start];
      input[start] = input[end];
      input[end] = temp;
      start++;
      end--;
    }
  }

  private void invertrow(int [] input){
    for(int i = 0; i < input.length; i ++){
      if(input[i] == 0){
        input[i] = 1;
      }else{
        input[i] = 0;
      }
    }
  }



}
