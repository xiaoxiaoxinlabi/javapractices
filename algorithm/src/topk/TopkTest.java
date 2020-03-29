package topk;

import java.util.List;

public class TopkTest {

//  现有一组千万级别的数，找出其中最大（小）的K个数。


//  已知几个递减有序的m个数组，求这几个数据前k大的数

  //1,合并法
//  *适合采用Merge的方法,时间复杂度(O(k*m);

  public int [] getTopk(List<List<Integer>> input , int k){
//    保存每个数组下标扫描的位置
    int index [] = new int[input.size()];

    int result [] = new int[k];

    for(int i = 0; i < k ; i++){
      int max = Integer.MIN_VALUE;
      int maxIndex = 0;

      for(int j = 0; j < input.size(); j++){
        if(index[j] < input.get(j).size()){
          if(max < input.get(j).get(index[j])){
            max = input.get(j).get(index[j]);
            maxIndex=j;
          }
        }
      }
      if(max == Integer.MIN_VALUE){
        return  result;
      }
      result[i] = max;
      index[maxIndex]+=1;
    }
    return result;
  }



//  *利用快速排序的过程来求最小的k个数

  //  2 快速排序法
//  快排过程法利用快速排序的过程来求Top k.平均时间复杂度为(O(n)).适用于无序单个数组。具体java实现如下：
//  Quick Select的目标是找出第k大元素，所以
//
//  选取一个基准元素pivot，将数组切分（partition）为两个子数组，
//
//

//  若上述两个条件均不满足，则第k大元素必出现在右子数组中。



  public int partion(int a[], int left, int right){

    int i = left, j = right+1;
    int pivot = a[left];
    while(true){
      while(i<right && a[++i]<pivot){

      }
      while(j >0 && a[--j] > pivot){

      }
      if(i>=j){
        break;
      }else{
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
      }
    }

    int tmp = a[left];
    a[left] =a[j];
    a[j]=tmp;
    return j;

  }


  public void getTopKBySort(int a[] , int left, int right , int k){
    if(left < right){
      int partionIndex = partion(a, left, right);
      if(partionIndex == k-1){
        return ;
      }else if(partionIndex > k-1){
//        若切分后的左子数组的长度 > k，则第k大元素必出现在左子数组中；
        getTopKBySort(a, left, partionIndex - 1, k);

      }else{
        //  若切分后的左子数组的长度 = k-1，则第k大元素为pivot；
        getTopKBySort(a, partionIndex+1, right, k);
      }
    }
  }


//求最大k个采用小根堆


//  求最大K个的步奏：
//
//  根据数据前K个建立K个节点的小根堆。
//  在后面的N-K的数据的扫描中，
//  如果数据大于小根堆的根节点，则根节点的值覆为该数据，并调节节点至小根堆。
//  如果数据小于或等于小根堆的根节点，小根堆无变化。


//  构建堆
  public int [] createHeap(int a[], int k){
    int [] result = new int[k];
    for(int i = 0; i < k; i ++){
      result[i] = a[i];
    }
    for(int i = 1; i< k; i++){
      int child = i;
      int parent = (i-1)/2;
      int temp = a[i];
      while(parent>=0 && child!=0 && result[parent] > temp){
        result[child]=result[parent];
        child=parent;
        parent = (parent-1)/2;

      }
      result[child]=temp;
    }
    return result;
  }


//  调整堆
  public void insert(int a[], int value){
    a[0]=value;
    int parent = 0;

    while(parent<a.length){
      int leftChild = 2*parent+1;
      int rightChild = 2*parent+2;
      int minIndex = parent;

      if(leftChild<a.length && a[parent] > a[leftChild]){
        minIndex=leftChild;
      }
      if(rightChild<a.length && a[parent] > a[rightChild]){
        minIndex = rightChild;
      }

      if(minIndex == parent){
        break;
      }else{
        int temp=a[parent];
        a[parent] = a[minIndex];
        a[minIndex] = temp;
        parent = minIndex;
      }
    }
  }


  public int [] gettopByheap(int input[], int k){
    int heap[] = createHeap(input, k);
    for(int i=k; i < input.length; i ++){
      if(input[i] > heap[0]){
        insert(heap, input[i]);
      }
    }
    return heap;
  }



  public static void main(String [] args){

    int a[] = {2,20,3,7,9,1,17,18,0,4};
    int k = 6;
//    new TopkTest().getTopKBySort(a, 0, a.length-1, k);
    int res [] = new TopkTest().gettopByheap(a, 4);

    for(int i = 0; i < res.length; i++){
      System.out.println(res[i]);
    }

  }

}
