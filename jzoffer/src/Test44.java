import java.util.Arrays;

public class Test44 {

//  题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。

  // 做三件事
  // 1.对数组进行排序
  // 2.统计数组中0的个数
  // 3.统计排序之后的数组中相邻数字之间的空缺总数

  public static boolean isContinuousCards(int [] arr){
    if(arr == null || arr.length == 0){
      return false;
    }

//    排序
    Arrays.sort(arr);

//算连续的牌空缺的数量
    int countEmpty = 0,

        //算王牌的数量
        count0=0;

//    计算0的个数
    for(int i = 0; i < arr.length; i ++){
      if(arr[i] == 0){
        count0++;
      }
    }


    if(count0 == 4){
      return true;
    }


    //算连续的牌空缺的数量
    for(int i = count0; i < arr.length-1; i++){
      if(arr[i]+1 == arr[i+1]){
        continue;
      }else if(arr[i] == arr[i+1]){
        return false;
      }else if(arr[i] + 1 < arr[i+1]){
        countEmpty +=(arr[i+1]-arr[i]-1);
      }else{
        return false;
      }
    }
    if(countEmpty == count0){
      return true;
    }
    return false;


  }

  public static void main(String [] args){

    int [] arr = {1,2,3,4,5,6};
    System.out.println(isContinuousCards(arr));

  }
}
