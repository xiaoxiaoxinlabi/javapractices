package practise.pra1;

public class Test1 {

//  将一个正整数N用二进制表示并转换为一个String 类型的值 s

  public String fun1(int N){
    String s = "";

    for (int n = N; n > 0; n /= 2){
      s = (n % 2) + s;
    }

    return s;
  }

//  有序数组中相邻两个元素之差的最大值
//   1,先排序
//  2，在求差

  public int fun2(int [] a){

    a = quickSort(a, 0, a.length - 1);

    int max = Math.abs(a[0] - a[1]);

    for (int i = 1; i < a.length; i ++){

      if (a[i] - a[i - 1] > max){

        max = a[i] - a[i - 1];
      }
    }
    return max;



  }

  public  int []   quickSort(int [] a, int low, int high){

    if (low >= high){
      return  null;
    }

    int privot = a[low];
    int left = low;
    int right = high;

    while(left < right){

      while (left < right && a[right] >= privot){
        right --;
      }
      while(left < right && a[left] <= privot){
        left++;
      }

      int tmp = a[right];
      a[right] = a[left];
      a[left] = tmp;

    }


//      a[right] = privot;(此种交换会导致数据被覆盖)
//      a[low] = a[right];

    a[low] = a[right];
    a[right] = privot;


    quickSort(a, low, right - 1);
    quickSort(a, right + 1, high);
    return a;


  }




  public static void main(String [] args){
    Test1 test1 = new Test1();
    int [] a = {1,2,6,5};
//    System.out.println(test1.fun1(2));
    System.out.println(test1.fun2(a));



  }
}
