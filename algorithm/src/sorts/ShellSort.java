package sorts;

public class ShellSort {

  public int [] shellSort(int [] a){

    int len = a.length;
    int gap = 1;

    while (gap < len / 3){

      gap = 3 * gap + 1;
    }

    while (gap >= 1){

      for (int j = gap; j < len; j ++){

        int temp = a[j];
        int k = j;

        while ( k >= gap  && a[k - gap] > temp){

          a[k] = a[k - gap];

          k = k - gap;
        }

        a[k] = temp;

      }

      gap = (gap - 1) / 3;

    }

    return a;

  }

}
