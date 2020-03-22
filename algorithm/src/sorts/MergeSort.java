package sorts;


//归并排序
public class MergeSort {


//归并排序--自顶向下
  public  int [] mergUpToDown(int [] a, int lo, int hi){

//    已经排好序
    if (lo >= hi){
      return null;
    }

    int mid = lo + (hi - lo) / 2;

    //对左子数组进行排序
    mergUpToDown(a, lo, mid);
//    对右子数组进行排序
    mergUpToDown(a, mid + 1, hi);

    //两端排序之后，将子数组合并
    mergeAll(a, lo, mid, hi);

    return a;

  }

  //归并
  public void mergeAll(int [] a, int lo, int mid, int hi){

    int i = lo,  j = mid + 1, tmp = lo;
    int [] tmpArr = new int [a.length];


//    比较左右子数组中最小的值
    while ( i <= mid && j <= hi){

      //        将最小的存入到临时数组中
      if (a[i] < a[j]){


        tmpArr[tmp ++] = a[i++];

      }else{

        tmpArr[tmp++] = a[j ++];
      }

    }

//    如果右子数组已经排完序，则将左子数组中剩余的元素依次存入到临时数组中
    while(i <= mid){

      tmpArr[tmp++] = a[i++];
    }

    //如果左子数组已经排完序，则将右子数组中剩余的元素依次存入到临时数组中
    while(j <= hi){
      tmpArr[tmp++] = a[j++];
    }


//    将临时数组中的元素存储到a[]中
    for ( tmp = lo;  tmp <= hi; tmp ++){
      a[tmp] = tmpArr[tmp];
    }


  }


//  归并排序--自底向上

  public int [] mergeDownToUp(int [] a){

    int length = a.length;

    //gap = 1表示，一个一个的归并，归并后的长度为2,2表示两个两个的归并，归并后的长度为4,以此类推
    //让其以2的倍数增加（2,4,8,16）
    for (int gap = 1; gap < length ; gap = gap * 2){

      //因为每次是两个小段的合并，所以lo的跨度为两个小段的长度
      for (int lo = 0; lo < length - gap; lo = lo + gap * 2){

        // 在进行归并之前，先判断当数组是否已经有序，如果有序就不用进行归并处理
        if (a[lo + gap - 1] > a[lo + gap]){

          //将数组a[lo, lo+sz-1] 与a[lo+sz, Math.min(lo+sz+sz-1, len-1)] 归并
          ////只有此时前一个小段最后一个数大于后一个小段第一个数字时才需要排序
          //对于数组长度不满足2的x次幂的数组，mid可能会大于end
          mergeAll(a, lo, lo + gap - 1, Math.min(lo + gap + gap - 1, length - 1));
        }
      }
    }

    return  a;


  }




  public static void main(String [] args){

    MergeSort  ms = new MergeSort();
    int [] a = {33,3,1,5,6,1,0,1,9};


//    print(ms.mergUpToDown(a, 0, a.length - 1));
    print(ms.mergeDownToUp(a));
  }



  public static void print(int [] a){

    for (int i = 0; i < a.length; i ++){
      System.out.println(a[i]);
    }
  }




}
