package en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargeGroupPositions_830 {

//  在小写字母的字符串S中，这些字母形成相同字符的连续组。找出连续出现超过3次的字符串的起始，结束索引


public List<List<Integer>>  largeGroupPositions1(String s){

  List<List<Integer>> ans = new ArrayList<>();
  int left = 0, n = s.length();
  for(int j = 0; j < n; j ++){
//    如果不是最后一个元素，或者 前后元素不相等
    if(j == n - 1 || s.charAt(j)!=s.charAt(j+1)){
//      则判断起始索引，结束索引之间的差如果大于3，则添加到集合中
      if(j-left+1 >=3){
        ans.add(Arrays.asList(new Integer[]{left,j}));
      }
//      更新 起始索引为上一个结束索引+1
      left = j +1;
    }
  }
  return ans;

}

}
