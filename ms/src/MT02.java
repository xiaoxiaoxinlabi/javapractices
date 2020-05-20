public class MT02 {

//  将数组[1,-1,1,-1,-1] 中的-1 挪到前面，1挪到后面（即：前半部分小于后半部分）

//  方法一：通过查找
  public static void fun1(int [] arr){
    int j = 0;
    for(int i= 0; i < arr.length; i ++){

      if(arr[i] == -1){
        arr[j] = arr[i];
        j++;
      }
    }

    for(int k = j; k <arr.length; k ++){
      arr[k] = 1;
    }

    for(int m = 0; m < arr.length; m++){
      System.out.println(arr[m]);
    }
  }

//  方法二：利用快排思想

  public static void fun2(int [] arr, int low, int high){

    if(low >= high){
      return;
    }

    int left = low;
    int right = arr.length-1;
    int p = arr[low];

    while(left < right){
      while(left < right && arr[right] >= p){
        right--;
      }
      while(left < right && arr[left] <=p){
        left++;
      }

      int t = arr[left];
      arr[left] = arr[right];
      arr[right] = t;
    }

    arr[low] = arr[left];
    arr[left] = p;

    fun2(arr, low, left-1);
    fun2(arr, left+1, high);

  }



  public static void fun3(int [] arr){
    int j = arr.length - 1;
    int i = 0;
    int temp;

    while(i <=j){

      while(arr[j] != -1 ){
        j--;

      }
      while(arr[i] != 1){
        i++;
      }
      if(i <=j){
         temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }

    }


  }



  public static void main(String [] args){
    int [] arr = {1,-1,1,-1,-1,1};
//    fun1(arr);

//    fun2(arr, 0, arr.length);

    fun3(arr);

    for(int i = 0; i < arr.length; i ++){
      System.out.println(arr[i]);
    }


  }



}
