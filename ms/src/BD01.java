public class BD01 {

//  有一组1 和 0 的乱序字符串，需要将0排在左边，1 排在右边
//  什么算法最快，占用内存较少

  public static void fun(int [ ] nums){
    int left = 0;
    int right = nums.length - 1;


    while(left <= right){

      while( nums[right] !=0){
        right--;
      }
      while(nums[left] != 1){
        left++;
      }

//      if(left <= right){

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
//      }



    }

  }

  public  static  void main(String [] args){

    int [] arr = {1,0,1,1,0,0};
    fun(arr);

    for(int i = 0; i < arr.length ; i ++){
      System.out.println(arr[i]);
    }
  }

}
