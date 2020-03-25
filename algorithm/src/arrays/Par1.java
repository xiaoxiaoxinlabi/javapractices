package arrays;

public class Par1 {


//  查找数组中的第二个大数

//  思想：维护一个max 存放最大值， secondmax 存放第二大数
  public static void findSecondMax(int [] arr){
    int max = arr[0];
    int secondMax = 0;

    for (int i = 1; i < arr.length; i++){

//      当arr[i] 大于max时，将max赋值给secondmax, 将arr[i] 赋值给最大值
      if(arr[i] > max){
        secondMax = max;
        max = arr[i];

//        当arr[i] 大于secondmax 并且 arr[i] 小于max, 将arr[i] 赋值给secondmax
      }else if (arr [i] > secondMax && arr[i] < max){
        secondMax = arr[i];
      }
    }

    System.out.println("第二大数为：" + secondMax);

  }

  public static void main(String [] args){

    int [] a = {3,4,5,2,2 , 5};
    findSecondMax(a);

  }
}

