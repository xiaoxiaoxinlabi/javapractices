package sorts;

public class QuickSort {

  public int [] quickSort(int [] a, int low, int high){

    if (low >= high){
      return null;
    }

    int j = partition(a, low, high);
    quickSort(a, low, j - 1);
    quickSort(a, j + 1, high);

    return a;
  }


  public int  partition(int [] a, int left, int right){

    int i = left, j = right + 1;
    int pivot = a[left];

    while (true){
      while (i < right && a[++i] < pivot){

      }
      while (j > 0 && a[--j] > pivot){

      }

      if (i >= j){
        break;
      }
      else{

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

      }

    }

    int temp = a[left];
    a[left] = a[j];
    a[j] = temp;

    return j;
  }




}
