package sorts;

public class CommonTest {


  
  public static void print(int [] args){

    for (int i = 0; i < args.length; i ++){

      System.out.println(args[i]);
    }


  }



  public static void main(String [] args){


//    int [] a =  {10,4,1,2,5,7,0,1};

    int [] a = {7,3,5,6,2,4,1};
//    print(new SimpleSort().simpleSort(a));

//    print(new StraightInsertionSort().straightInsertSort(a));

//    print(new ShellSort().shellSort(a));

//    print(new BucketSort().bucketSort(a));

//    print(new BucketSort1().bucketsSort(a));

    print(new QuicklySwapSort().quicklySort(a, 0, a.length - 1));
//    print(new QuickSort().quickSort(a, 0, a.length - 1));
//    print(new BubbleSort().bubbleSort(a));

  }
}
