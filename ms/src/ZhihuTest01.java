public class ZhihuTest01 {

//  整型数组，无序
//  实现前半部分的所有数 ，大于后半部分的所有数

//  解题思路：快排分治思想


  public static void fun1(int [] arr){


    int left = 0;
    int right = arr.length - 1;
    int pivot = arr[0];

    while(left <= right){

      while(left < right && arr[right] <= pivot){
        right--;
      }
      while(left < right && arr[left] >=pivot){
        left++;
      }

      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;



    }

    arr[0] = arr[left];
    arr[left] = pivot;

  }

  public static void main(String [] args){
    int [] arr = {9,3,5,6,70,10,4};

    fun1(arr);

    for(int i = 0; i < arr.length; i ++){
      System.out.print(arr[i]+ " ");
    }

  }

}
