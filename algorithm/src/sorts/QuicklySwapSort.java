package sorts;

public class QuicklySwapSort {

  public int [] quicklySort(int [] a, int low, int high){

    if (low >= high){
      return null;
    }

    int left, right, pivot, tmp;

     pivot = a[low];
     left = low;
     right = high;

    while (right > left){

      while (right > left && a[right] >= pivot){
        right --;
      }

      while (right > left && a[left] <=  pivot){

        left ++;
      }

       tmp = a[right];
      a[right] = a[left];
      a[left] = tmp;
    }

    //将基准位与 left和right相遇位置的元素交换
    a[low] = a[left];
    a[left] = pivot;
    System.out.println(low +"=="+ left);

//    quicklySort(a, low, right - 1);
//    quicklySort(a, right+ 1, high);

    return a;
  }



}
