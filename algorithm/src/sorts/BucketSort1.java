package sorts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BucketSort1 {


  public int [] bucketsSort(int []  a){

//    基本思路：
//        1，设置桶
//        2，分发元素到桶
//        3，针对桶中的元素进行排序
//        4，将桶中有序的元素，pull 出来赋给输出数组


//    决定桶的数量，创建桶集合并将所有桶装到集合中

    final int numberOfBuckets = (int)Math.sqrt(a.length);
    List<List<Integer>> bucktes   = new ArrayList<>(numberOfBuckets);

    for (int i = 0; i < numberOfBuckets; i ++){

      bucktes.add(new ArrayList<>());
    }


//确定放入桶中的策略
    int max = findMax(a);

//    将元素放入合适的桶中（分发元素）
    for (int j = 0; j < a.length; j ++){

      bucktes.get(hash(a[j], max, numberOfBuckets)).add(a[j]);
    }


//    将桶中的元素排序
    Comparator<Integer> comparator = Comparator.naturalOrder();

   for (List<Integer> bucket: bucktes){

     bucket.sort(comparator);


   }



    //    将桶中的元素全部取出来，并放入到a中输出
  int idx = 0;
    for (List<Integer> thisBuckte: bucktes){

      for (int newA: thisBuckte){

        a[idx ++] = newA;
      }

    }

    return a;


  }


//每个元素放入那个桶中的策略
  private int hash(int i , int max, int numberOfBuckets){

    return  (int) ((double)i / max * (numberOfBuckets - 1));
  }



  private int findMax (int [] a){
    int m = Integer.MIN_VALUE;

    for (int i = 0; i < a.length; i ++){

      m = Math.max(m, a[i]);
    }

    return m;
  }



}
