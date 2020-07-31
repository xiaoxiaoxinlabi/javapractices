package en;

public class FindNumbers_1295 {

//  给定一个由整数组成的数组，返回其中有偶数位数的数字

  public int findNumbers1(int [] nums){

    if(nums.length == 0){
      return 0;
    }

    int count = 0;


    for(int i = 0; i < nums.length; i ++){
      if(String.valueOf(nums[i]).length() % 2 !=0){
        continue;
      }else{
        count++;
      }
    }
    return count;

  }

  //      Math.log10(10)   // 1
//      Math.log10(100)  // 2
//      Math.log10("100")// 2
  public int findNumbers2(int [] nums){
    int count = 0;
    for(int i = 0; i < nums.length; i ++){

//      Math.log10(): 返回以10为底的double的值, Math.floor():返回小于或等于一个给定数字的最大整数

      int digits = (int) Math.floor(Math.log10(nums[i])+1);
      if(digits % 2 ==0){
        count++;
      }
    }
    return count;
  }

  public int findNumbers3(int [] nums){
    int arr[] = new int[nums.length];
    int count = 0;

    for(int i = 0; i < nums.length; i ++){
      int val = nums[i];
      int count1 = 0;

      while(val > 0){
        count1++;
//        计算每个值的位数
        val = val / 10;
      }

      arr[i] = count1;
      if(arr[i] % 2 == 0){
        count++;
      }
    }
    return count;
  }

}
