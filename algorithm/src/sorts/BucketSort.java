package sorts;

import java.util.ArrayList;

public class BucketSort {

  public int [] bucketSort(int [] a){

    final int BUCKETS = 256;
    ArrayList<Integer>[] buckets = new ArrayList[BUCKETS];

    for (int i = 0; i < BUCKETS; i ++){

      buckets[i] = new ArrayList<>();
    }


    for (int pos = a.length - 1; pos >= 0; pos --){

      for (int newA :a){

        buckets[newA].add(newA);
      }



      int idx = 0;
      for (ArrayList<Integer> thisBucket: buckets){

        for (int  newA: thisBucket){

          a[idx ++] = newA;

        }

        thisBucket.clear();
      }
    }


    return a;


  }
}
