package en.sorts;

import java.util.*;
import java.util.stream.Collector;

public class RelativeSortArray_1122 {

//    给定两个数组arr1和arr2，arr2的元素是不同的，并且arr2中的所有元素也位于arr1中。
//    对arr1的元素进行排序，以使arr1中项目的相对顺序与arr2中的相同。不在arr2中出现的元素应按升序放置在arr1的末尾。

//    Example 1:
//
//    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//    Output: [2,2,2,1,4,3,3,9,6,7,19]

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap();
        int index = 0;
        for(int i = 0; i < arr1.length; i ++){
            map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
        }


        for(int i = 0; i < arr2.length; i ++){
            if(map.containsKey(arr2[i])){
                int idx = map.get(arr2[i]);
                int newidx = idx + index;
                while(index < newidx){
                    arr1[index++] = arr2[i];
                    map.put(arr2[i], map.get(arr2[i])-1);
                }

            }
        }
        TreeMap<Integer,Integer> tm = new TreeMap();
        tm.putAll(map);
        for(Map.Entry<Integer,Integer> res: tm.entrySet()){

            int val = res.getValue();
            while(val > 0){
                arr1[index] = res.getKey();
                val--;
                index++;
            }
        }

        return arr1;

    }

    public int [] relativeSortArray1(int [] arr1, int [] arr2){
        int out [] = new int[arr1.length];
        int ind [] = new int[1001];

//        将数组1 进行排序，并统计每个元素出现的次数
        for(int i = 0; i < arr1.length; i ++){
            ind[arr1[i]]++;
        }
        int k = 0;
//        遍历数组2
        for(int i = 0; i < arr2.length; i ++){
//            找出数组2中的元素，在数组1中出现的次数
            int times = ind[arr2[i]];
//            然后根据次数进行赋值
            for(int j = 0; i < times; j ++){
                out[k++] = arr2[i];
            }
//            并将赋值之后的次数设置为0
            ind[arr2[i]] = 0;
        }

//        循环遍历统计次数的数组
        for(int i = 0; i < ind.length; i ++){
//            查找每个元素出现的次数
            int times = ind[i];
//            并将其添加到输出的数组
            for(int j = 0; j < times; j ++){
                out[k++] = i;
            }
        }
        return out;
    }

    public int [] relativeSortArray2(int [] arr1, int [] arr2){
        int [] temp = new int[1001];
        for(int i : arr1){
            temp[i]++;
        }
        int [] result = new int[arr1.length];
        int ctr = 0;
        for(int i : arr2){
            while (temp[i] -- > 0){
                result[ctr++] = i;
            }
        }

        for(int i = 0; i < temp.length; i ++){
            while (temp[i]-- > 0){
                result[ctr++] = i;
            }
        }
        return result;
    }

}
