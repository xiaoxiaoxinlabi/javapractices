package en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RelativeSortArray_1122 {

//  给定两个数组arr1和arr2，arr2的元素是不同的，并且arr2中的所有元素也都在arr1中。
//  对arr1的元素进行排序，以使arr1中项目的相对顺序与arr2中的相同。不在arr2中出现的元素应按升序放置在arr1的末尾。

  public int []  relativeSortArray1(int [] arr1, int [] arr2){

    int [] res = new int [arr1.length];
    int index = 0;
//    TreeMap是一个有序的key-value集合,他是通过红黑树实现的
    Map<Integer, Integer> map = new TreeMap<>();
//    遍历arr1 中每个元素出现的次数，存储在map中
    for(int i: arr1){
      map.put(i, map.getOrDefault(i, 0) +1);
    }

//    遍历数组arr2 ，并判断arr2中的每个元素在arr1中出现的次数，然后写到res数组中
    for(int i :arr2){
      for(int j = 0; j < map.get(i); j ++){
        res[index++] = 1;
      }
//      与此同时，将该元素从map中删除
      map.remove(i);
    }

//    遍历map,然后将map中剩余的元素存储在res中
    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//      map中每个key出现的次数为value
      for(int i = 0; i < entry.getValue(); i ++){
        res[index++] = entry.getKey();
      }
    }
    return res;
  }

  public int [] relativeSortArray2(int [] arr1, int [] arr2){
    List<Integer> ans = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap();
    Set<Integer> set = new HashSet<>();

//    将数组arr1 中每个元素出现的次数存储在map中
    for( int i = 0; i < arr1.length; i ++){
      map.put(arr1[i], map.getOrDefault(arr1[i],0) +1);
    }

//    循环遍历数组arr2, 如果map中包含arr2中的元素，则判断每个元素出现的次数，并且将该元素添加到list集合中
    for(int i = 0; i < arr2.length; i ++){
      if(map.containsKey(arr2[i])){
        for(int j = 0; j < map.get(arr2[i]); j ++){
          ans.add(arr2[i]);
        }
      }
//      并且将元素添加到set中
      set.add(arr2[i]);
    }

//    对arr1 进行排序
    Arrays.sort(arr1);
//    遍历数组arr1,如果元素在set中不存在，则将其添加到list中
    for(int i = 0; i < arr1.length; i++){
      if(!set.contains(arr1[i])){
        ans.add(arr1[i]);
      }
    }

//    创建一个和list大小一样的数组，将list中的值赋给新数组
    int [] new1 = new int[ans.size()];
    for(int i = 0; i < new1.length; i ++){
      new1[i] = ans.get(i);
    }

    return new1;

  }

}
