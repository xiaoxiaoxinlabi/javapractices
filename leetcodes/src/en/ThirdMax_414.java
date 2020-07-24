package en;

public class ThirdMax_414 {

//  给定一个非空整数数组，返回此数组中的第三个最大数字。如果不存在，则返回最大元素。时间复杂度必须为O（n）。

  public static int thirdMax1(int [] nums){
    long firstMax = Long.MIN_VALUE;
    long secondMax = Long.MIN_VALUE;
    long thirdMax = Long.MIN_VALUE;
    int count = 0;
//    循环遍历
    for(int num : nums){
//      如果当前元素大于最大元素
      if(num > firstMax){
        count += 1;
//        则将第二个大元素赋值给第三个大元素
        thirdMax = secondMax;
//        第一个大元素赋值给第二大元素
        secondMax = firstMax;
//        第一大元素则为当前元素
        firstMax = num;

      }
//      如果当前元素大于第二大元素，并且不等于第二大元素
      else if(num > secondMax && num != firstMax){
        count += 1;
//        则将第二大元素赋值给第三大元素
        thirdMax = secondMax;
//        当前元素赋值给第二大元素
        secondMax = num;

      }
//      如果当前元素大于第三大元素，并且不等于第二大元素，不等于第三大元素
      else if(num > thirdMax && num != firstMax && num != secondMax){
        count += 1;
//        则将当前元素赋给第三大元素
        thirdMax = num;

      }
    }
//    如果第三大元素不等于最小值，或者 元素数量大于2 ，则返回第三大元素
    if(thirdMax != Long.MIN_VALUE || count > 2){
      return (int)thirdMax;
    }
//    不满足条件，则返回第一大元素
    return (int)firstMax;
  }

}
