import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test61 {

//  扑克牌中的顺子
//  从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。


//  输入: [1,2,3,4,5]
//  输出: True
//  输入: [0,0,1,2,5]
//  输出: True

//  方法一：集合 Set + 遍历
//  遍历五张牌，遇到大小王（即 00 ）直接跳过。
//  判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 O(1)O(1) ；
//  获取最大 / 最小的牌： 借助辅助变量 mama 和 mimi ，遍历统计即可。

  public boolean isStraight(int [] nums){
    Set<Integer> set = new HashSet<>();

    int min = 0, max = 14;
    for(int num: nums){
//      跳过大小王
      if(num == 0){
        continue;
      }
//      找出最大值，最小值
      max = Math.max(max, num);
      min = Math.min(min, num);

//      判断集合中是否有已经存在，如果有提前返回false
      if(set.contains(num)){
        return false;
      }
//      否则，添加到set中
      set.add(num);
    }
//    如果最大减去最小的小于5则true, 否则false
    return max - min < 5;

  }

//  方法二：排序+遍历

//  先对数组执行排序。

//  判别重复： 排序数组中的相同元素位置相邻，因此可通过遍历数组，判断 nums[i] = nums[i + 1]是否成立来判重。
//  获取最大 / 最小的牌： 排序后，数组末位元素 nums[4]为最大牌；元素 nums[joker]为最小牌，其中 joker 为大小王的数量

public boolean isStraight1(int [] nums){

/// 数组排序
  Arrays.sort(nums);
  int joker = 0;
  for(int i = 0; i <4; i ++){

    // 统计大小王数量
    if(nums[i] == 0){
      joker++;
      // 若有重复，提前返回 false
    }else if(nums[i] == nums[i+1]){
      return false;
    }

  }
  // 最大牌 - 最小牌 < 5 则可构成顺子
  return nums[4]-nums[joker] < 5;
}

}
