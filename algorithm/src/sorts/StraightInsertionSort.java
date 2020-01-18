package sorts;

public class StraightInsertionSort {


  public int [] straightInsertSort(int [] a){

    for (int i = 1; i < a.length; i ++){

      int temp = a[i];
      int j = i;

     while (j > 0 && a[j - 1] > temp){

       a[j] = a[j - 1];

       j --;

     }

     a[j] = temp;
    }


    return a;



  }

}
