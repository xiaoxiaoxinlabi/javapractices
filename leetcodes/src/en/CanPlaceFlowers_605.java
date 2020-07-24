package en;

public class CanPlaceFlowers_605 {

//  假设您有一个长长的花坛，其中种植了一些地块，有些则没有。但是，不能在相邻的地块上种花，因为它们会争夺水，而两者都会死亡。
//  给定一个花坛（表示为包含0和1的数组，其中0表示空，1表示不空）和一个数字n，如果可以在其中种植n个新花而不违反不相邻花规则，则返回


//  Single Scan [Accepted]
  public boolean canPlaceFlowers1(int [] flower, int n){
    int i = 0, count = 0;
    while(i < flower.length){
//      (如果当前元素等于 0) && (第一个元素 或者 当前索引的前一个元素为0) && (是最后一个元素 或者当前元素的后一个元素为0)

      if(flower[i] == 0 && (i == 0 || flower[i-1] == 0) && (i == flower.length-1 || flower[i+1] == 0)){
//        则当前元素可以置为1
        flower[i] = 1;
//        数量增加
        count++;
      }
      i++;
    }
    return count >=n;
  }

  public boolean canPlaceFlowers2(int [] flower, int n){
    int i = 0, count = 0;
    while(i < flower.length){

      if(flower[i] == 0 && (i == 0 || flower[i - 1] == 0) && (i == flower.length-1 || flower[i+1] == 0)){
        flower[i++]=1;
        count++;
      }
      if(count >=n){
        return true;
      }
      i++;

    }
    return false;
  }

}
