package en;

public class IsMonotonic_896 {

//  如果数组是单调递增或单调递减的，则它是单调的。
//
//  如果对于所有i <= j，A [i] <= A [j]，数组A是单调递增的。如果对于所有i <= j，A [i]> = A [j]，数组A是单调递减的。
//
//  当且仅当给定数组A为单调时，才返回true。


  public static boolean isMonotonic1(int[] A) {

    boolean increasing = true;
    boolean decreasing = true;

    for (int i = 0; i < A.length - 1; i++) {

//      两个if 都会执行
      if (A[i] > A[i + 1]) {
        increasing = false;
      }
      if (A[i] < A[i + 1]) {
        decreasing = false;
      }
    }
    return increasing || decreasing;

  }


  public  boolean isMonotonic2(int[] A) {

    return increasing(A) || decreasing(A);

  }

//  升序
  private boolean increasing(int [] arr){
    for(int i = 0; i < arr.length-1; i++){
      if(arr[i] > arr[i+1]){
        return false;
      }
    }
    return true;
  }

//  降序
  private boolean decreasing(int [] arr){
    for(int i = 0; i < arr.length-1; i ++){
      if(arr[i] < arr[i+1]){
        return false;
      }
    }
    return true;
  }

  public boolean isMonotonic3(int [] A){

    int store = 0;
    for(int i = 0; i < A.length-1; i++){
//      将两者的比较结果存储为c
      int c = Integer.compare(A[i], A[i+1]);

//      如果两者不相等
      if(c!=0){
//        如果 两者比较结果不等于 store, 并且 store 不等于 0 ，则返回 false
        if(c != store && store !=0){
          return false;
        }
//        将两者的比较结果赋值给store
        store = c;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    int[] arr = {1, 3, 2};
    System.out.println(isMonotonic1(arr));
  }

}
