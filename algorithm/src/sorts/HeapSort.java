package sorts;

/**
 * @author ：mmzs
 * @date ：Created in 2019/12/13 18:55
 * @description： 堆排序
 * @modified By：
 * @version: 1.0.0$
 */




//选择排序--对排序
public class HeapSort {


//  选择排序--堆排序--大顶堆（升序）
  public int [] heapMax(int [] a){

    //创建大顶堆
    createMaxHeap(a);

    int len = a.length;

    while(len > 1){

      //将最顶端的元素和最末尾元素交换位置，交换之后，最末尾的元素不在参与排序
      int temp = a[0];
      a[0] = a[len - 1];
      a[len - 1] = temp;

      len --;

      //将剩余的元素再次构建大顶堆
      createMaxHeapByOther(a, 0, len);
    }

    return a;
  }



  //构建大顶堆
  public void createMaxHeap(int [] a){

    for (int i = 0; i < a.length; i ++){

      //定义当前节点，父节点
      int currentIndex = i;
      int parentIndex = currentIndex / 2;


      //如果当前节点大于父节点，则交换两者的位置
      while (a[currentIndex] > a[parentIndex]){


        int temp = a[currentIndex];
        a[currentIndex] = a[parentIndex];
        a[parentIndex] = temp;

        //当前指针指向父节点的指针，
        currentIndex = parentIndex;
        //父节点的指针为，交换后的新指针
        parentIndex = currentIndex / 2;
      }
    }
  }


  //l将剩余的元素再次构建大顶堆
  public void createMaxHeapByOther(int [] a,  int index,  int size){

    //定义左右子节点，并将当前节点作为最大值
    int leftChild = 2 * index;
    int rightChild = 2 * index + 1;
    int max = index;

//    比较左右子节点中的最大值，进行交换
    if (rightChild < size && a[rightChild] > a[max]){

      max = rightChild;
    }
    if (leftChild < size &&  a[leftChild] > a[max]){

      max = leftChild;
    }

    //如果当前节点不等于最大值，那么和最大值进行交换
    if (index != max){

      int temp = a[max];
      a[max] = a[index];
      a[index] = temp;



      //再次构建大顶堆
      createMaxHeapByOther(a, max, size);
    }
  }


//  选择排序--小顶堆（降序）

public int [] heapMin(int [] a){

    //构建小顶堆
    createMinHeap(a);

    int length = a.length;


    while (length > 1){

      //将最顶端的元素和最末尾的元素进行交换
      int temp = a[0];
      a[0] = a[length - 1];
      a[length - 1] = temp;

      length --;

      //将剩余的元素再次构建小顶堆
      createMinHeapByOther(a, 0, length);
    }

    return a;
}


//构建小顶堆
public void createMinHeap(int [] a){

    for (int i = 0; i < a.length; i ++){

      int currentIndex = i;
      int parentIndex = currentIndex / 2;

//      如果当前节点小于父节点，则交换
      while (a[currentIndex] < a[parentIndex]){

        int temp = a[currentIndex];
        a[currentIndex] = a[parentIndex];
        a[parentIndex] = temp;


        currentIndex = parentIndex;
        parentIndex = currentIndex / 2;

      }

    }
}

//将剩余的元素构建小顶堆
public void createMinHeapByOther(int [] a, int index, int size){

    int leftChild = 2 * index;
    int rightChild = 2 * index + 1;
    int min  = index;
    if (rightChild < size && a[rightChild] < a[min]){

      min = rightChild;
    }
    if (leftChild < size && a[leftChild] < a[min]){

      min = leftChild;
    }

    if (min != index){

      int temp = a[index];
      a[index] = a[min];
      a[min] = temp;



      createMaxHeapByOther(a, min, size);

    }

}







  public static void main(String [] args){

    HeapSort  hs = new HeapSort();
    int [] a = {33,3,1,5,6,1,0,1,9};


//    print(ms.mergUpToDown(a, 0, a.length - 1));
    print(hs.heapMax(a));

    System.out.println("===========");
    print(hs.heapMin(a));
  }



  public static void print(int [] a){

    for (int i = 0; i < a.length; i ++){
      System.out.println(a[i]);
    }
  }



}
