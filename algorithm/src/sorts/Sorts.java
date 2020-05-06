package sorts;

import java.util.Arrays;

public class Sorts {

  //交换排序--冒泡(在每一轮只把一个元素冒泡到数列的一端)
  public int[] fun1(int[] a) {

    //比较N个数的大小并排序的话,要比较N-1遍。
    for (int i = 0; i < a.length - 1; i++) {
      //每轮两辆相邻的元素进行比较，如果左边的比右边的大，那么交换位置
      for (int j = 0; j < a.length - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }

    return a;

  }

  //交换排序--快速排序 1
// 整体思路： 选取基准值，移动元素（填坑法，指针交换法）
// 1,取第一个元素作为切分元素，即基准元素： a[low];
//2,设定一个左指针：left，指向第一个元素； 然后从数组的左端开始向右扫描，直到找到一个大于等于a[low]的元素
//3，设定一个右指针：right，指向最后一个元素；再从数组的右端开始向左扫描，直到找到一个小于等于a[low]的元素
//4，交换这两个元素的位置；如此就可以保证，左指针left的左侧元素都不大于切分元素a[low],右指针right的右侧的元素都不小于a[low];
//5，当两个指针相遇（left ，right 指向同一个元素）时，只需要将切分元素a[low]和左子数组最右边的元素a[right]交换后返回right即可；

  public int [] fun2(int [] a, int low, int hight){
    //如果两指针相遇，则停止
    if (low >= hight){
      return null;
    }

    int left, right, pivot;
    //将第一个元素作为基准值
     pivot = a[low];
    //指定左指针，右指针
     left = low;
     right = hight;

    //如果两个指针没有相遇则继续
    while(left < right){

      //先从基准元素对立的方向开始
      //右指针左移动，直到遇到小于基准元素的值，然后停止
      while(left < right && a[right] >= pivot){
        right --;
      }

      //左指针右移，直到遇到大雨基准元素的值，然后停止
      while (left < right && a[left] <= pivot){
        left ++;
      }

      //此时，两端指针停止之后，将两个指针所指向的元素交换位置

        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;

    }

    //当两个指针相遇的时候，将基准值和左子数组最右边的元素交换位置

    a[low] = a[right];
    a[right]=pivot;

    //对基准值左边的元素开始递归操作
//    fun2(a,low ,right - 1);
    //对于基准值右边的元素开始递归操作
//    fun2(a,right + 1, hight);

    return a;
  }


  //交换排序--快速排序 2
  public int []  fun3(int [] a){
    return fun3(a,0,a.length - 1);

  }

  public int []  fun3(int [] a, int low, int hight){

    //如果左指针大于等于右指针，则排序完成
    if (low >= hight){
      return null;
    }
    //获取切分的元素下标
    int right = getPivot(a,low,hight);
    //针对切分元素左边的左子数组进行排序
    fun3(a,low,right - 1);
    //针对切分元素右边的右子数组进行排序
    fun3(a,right + 1, hight);
    return a;
  }


  public int getPivot(int [] a, int low ,int hight){


    int  i = low;
    int j = hight + 1;
    int   pivot = a[low];

    while(true){
      while(a[++i] <= pivot){
        if (i == hight){
          break;
        }
      }
      while(a[--j] >= pivot){
        if(j == low){
          break;
        }
      }
      if(i >= j){
        break;
      }
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }


    //交换的时候，a[low] 在之前已经给临时变量(pivot)赋值了，所以直接借用临时变量（pivot）就行
    a[low] =a[j];
    a[j] = pivot;


    return j;


  }


  //插入排序--直接插入排序
  public int [] fun4(int [] a){
    int j;
    //从下标为1的元素开始选择合适的位置插入，下标为0 的元素默认是有序的
    for (int i = 1; i < a.length; i ++){
      //记录要插入的数据
      int temp = a[i];
      //将待插入的数据与已经排好序的序列从最右边元素开始依次向左比较，找到比其小的数
      //即将a[i] 插入到 a[i - 1],a[i - 2],a[i - 3] 中
      j = i;
      while( j >0 && a[j - 1] > temp){
        //当前元素大于待插入元素，则将当前元素:a[j - 1]向后挪
        a[j] = a[j - 1];
        //继续向左比较
        j --;
      }
      //插入位置找到后，立即插入
      a[j] = temp;
    }
    return a;

  }

  //插入排序--希尔排序
  public int [] shellSort(int [] a){
    int len = a.length;
    //定义最初的间隔为：1
    int h = 1;
    //递增获取间隔序列
    while(len/3 > h){
      h = h * 3 + 1; //1, 4
    }

    while(h >= 1){
      //分别对每个增量间隔h进行排序
      //当h = 1 的时候，一定是直接插入排序
      for (int i = h; i < len; i ++){
        int temp = a[i];
        int j;
        //将a[i]插入到a[i-h],a[i - 2*h],a[i - 3*h]之中
        for( j = i; j >= h  && a[j - h] > temp; j = j - h){
          a[j] = a[j - h];
        }
        a[j] = temp;
        System.out.println("h:" + h + "a:" + Arrays.toString(a));
      }

      h = (h - 1) / 3;
    }
    return a;
  }


  //选择排序--简单选择排序
  //1，找到数组中的最小元素
// 2,将它和数组的第一个元素交换（如果第一个元素值是最小元素，则和自己交换）
  //3,从第二个元素开始到n-1 个元素再选出最小的记录与第二个记录交换
  //4,以此类推，第i趟，则从第i个记录开始到n - i + 1 个记录中选出最小的元素，与第i个交换
  public int [] fun5(int [] a){
    //交换次数n
    for ( int i = 0; i < a.length; i ++){
      //记录最小元素的下标
      int min = i;
      //将a[i]与a[i + 1],a[i + 2]....a[i + n] 中的最小元素交换
      for (int j = i + 1; j < a.length; j ++){
        //如果当前比较的元素比最小元素小，则将比较的元素作为最小元素
        if (a[min] > a[j]){
          //记录目前找到的最小元素的下标
          min = j;
        }
      }
      //确定最小元素之后，和a[i]进行交换
      int temp = a[i];
      a[i] = a[min];
      a[min] = temp;
    }
    return a;

  }


//选择排序--堆排序
//  大顶堆（升序排列）
//堆排序
public int [] heapSort(int [] a){

    //构造大顶堆
  heapInsert(a);
  int length = a.length;
  while (length > 1){
//    不断排除最大元素
    int temp = a[0];
    a[0] = a[length - 1];
    a[length - 1] = temp;
    length --;
//    利用剩余的元素再次构造大顶堆
    heapify(a, 0, length);
  }
  return a;
}







  //构造大顶堆（通过新插入的数上升）
  //新插入的数据与直接父节点进行比较，最大的值交换到顶端
  public void heapInsert(int [] a){
    for (int i = 0; i < a.length; i ++){
      //当前插入的节点
      int currentIndex = i;
      //记录当前节点的父节点
      int fatherIndex = (currentIndex - 1) / 2;
      //如果当前插入的值大于其父节点的值，则交换值，并且将索引指向父节点，重新计算父节点
      //然后继续和上面的父节点进行比较，直到不大于父节点，退出循环
      while( a[currentIndex] > a[fatherIndex]){
        //交换当前节点与父节点的值
        int temp = a[currentIndex];
        a[currentIndex] = a[fatherIndex];
        a[fatherIndex] = temp;

        //将当前节点指向父节点
        currentIndex = fatherIndex;
        //重新计算父节点
        fatherIndex = (currentIndex - 1) / 2;
      }
    }
  }

  //将剩余的数构造成大顶堆（通过顶端的数下降）
  //顶端的数依次与左右子节点进行比较，如果顶端数据小就下沉
  public void heapify(int [] a, int index, int size){
    //当前节点的左，右子节点
    int leftChild = index *2 + 1;
    int rightChild = index * 2 + 2;


    while (leftChild < size){
      //临时记录最大值
      int largestIndex;
      //判断左右子节点中较大的值
      if(a[leftChild] < a[rightChild]  && rightChild < size){
        largestIndex = rightChild;
      }else{
        largestIndex = leftChild;
      }
      //将子节点中的最大值与父节点进行比较，确定最大值
      if (a[index] > a[largestIndex]){
        //如果子节点大，则将当前节点指向最大值的索引
        largestIndex = index;

      }
      //如果父节点是最大值，则已经到了大顶堆的根了，则退出循环
      if (index == largestIndex){
        break;
      }
      //父节点不是最大的值，则与孩子中最大的值交换，将父节点下沉
      int temp = a[largestIndex];
      a[largestIndex] = a[index];
      a[index] = temp;

      //将索引指向孩子中较大值的索引
      index = largestIndex;

      //重新计算交换之后的孩子的索引
      leftChild = 2 * index + 1;
      rightChild = 2 * index + 2;
    }
  }





public int [] bigHeapSort(int [] a){
    int parentIndex = (a.length - 1) / 2;
    //将最大的顶部与最后一个交换
    for (int i = parentIndex; i >= 0; i --){
      maxHeap(a, i, a.length);
    }

    //第一个跟最后一个调整
    for (int i = a.length - 1; i >= 0; i --){
      int temp = a[0];
      a[0] = a[i];
      a[i] = temp;
      maxHeap(a, 0, i);
    }
    return a;
}




public void maxHeap(int [] a, int index, int size){
    int leftChild = 2 * index + 1;
    int rightChild = 2 * index + 2;
    int max = index;
    if (leftChild < size && a[leftChild] > a[max]){
      max = leftChild;
    }
    if (rightChild < size && a[rightChild] > a[max]){
      max = rightChild;
    }

    if (max != index){
      int temp = a[index];
      a[index] = a[max];
      a[max] = temp;

      maxHeap(a, max, size);
    }
}




  //交换排序--堆排序（小顶堆--降序排序）
//将最小的顶部与最后一个交换
  public int []  littleHeapSort(int [] a ){
    //开始位置最后一个非叶子节点（最后一个叶子节点的父节点）
    int parentIndex = (a.length - 1) /2;
    for (int i = parentIndex; i >= 0; i--){
      //构建小顶堆
      minHeap(a,i,a.length);

    }

    //最后一个跟第一个进行调整
    for (int i = a.length - 1; i > 0; i --){
      int temp = a[0];
      a[0] = a[i];
      a[i] = temp;
      minHeap(a, 0, i);
    }

    return a;
  }

  //将剩余的数再次构建小顶堆
  public void minHeap(int [] a, int index, int size){
    int leftChild = 2 * index + 1;
    int rightChild = 2 * index + 2;
    //假设当前节点最小
    int min = index;
    //分别比较左右子节点，找到最小值
    if (leftChild < size && a[leftChild] < a[min]){
      //如果左子节点小于min,将最小位置改为左子节点
      min = leftChild;

    }
    if (rightChild < size && a[rightChild] < a[min]){
      //如果右子节点小于Min,将最小位置改为右子节点
      min = rightChild;
    }

    //如果不相等，就交换
    if (min != index){
      int temp = a[index];
      a[index] = a[min];
      a[min] = temp;
      //如果下面还有叶子节点，并破坏了原有的堆，则需要从新调整
      minHeap(a, min, size);
    }

  }





  public void print(int a[]) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }

  }




  public static void main(String[] args) {
   Sorts st = new Sorts();
    int [] a = {6,1,2,7,9,3,4,5,10,85};
//    int[] a = {4, 7, 6, 5, 3, 2, 8, 1,3,12,4,53};
//    int[] newa = st.fun2(a, 0, a.length - 1);
    int [] newa = st.littleHeapSort(a);
//    st.print(st.fun2(a, 0, a.length - 1));
    st.print(st.fun3(a));

  }


}
