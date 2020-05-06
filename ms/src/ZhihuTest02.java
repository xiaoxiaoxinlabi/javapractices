import java.util.Arrays;

public class ZhihuTest02 {

//  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半

  public static void fun1(int [] arr){

    int left = 0;
    int right = arr.length - 1;
    int tmp = 0;

    while(left <=right){

      if(arr[left] % 2 == 1 && arr[right]%2 == 0){
        left++;
        right --;
      }else if(arr[left] % 2 ==1 && arr[right] %2 ==1){
        left++;
      }else if(arr[left]%2==0 && arr[right]%2==0){
        right--;
      }else if(arr[left]%2==0 && arr[right]%2==1){
        tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        left++;
        right--;
      }


    }

    System.out.println(Arrays.toString(arr));


  }


  public static void main(String [] args){

    int [] arr = {1,2,3,4,5,6,7,8,9};

    fun1(arr);



  }


}
