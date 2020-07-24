package en;

import java.util.HashMap;
import java.util.Map;

public class FindLucky_1394 {

//    数组中的元素出现的次数与其值相同的时候，则为幸运数
//    如果存在多个幸运数，则返回最大的幸运数，
//    如果不存在幸运数，则返回-1

    public static int findLucky1(int [] arr){
        Map<Integer, Integer> map = new HashMap();
        int res = -1;

        for(int i = 0; i < arr.length; i ++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int i = 0; i < arr.length; i ++){
            if(map.get(arr[i]) != arr[i]){
                continue;
            } if(map.get(arr[i]) == arr[i]){
                res = Math.max(res, arr[i]);
            }
        }
       return res;
    }

    public int findLucky2(int [] arr){
//        设置一个数组，用来存储每个数字出现的次数，每个数组作为索引，出现次数作为值
        int [] temp = new int [501];
        int res = -1;
//        遍历数组，并将数组中每个值出现的次数存放到临时数组所对应的索引上
        for(int i = 0; i < arr.length; i ++){
            temp[arr[i]]++;
        }
//        再次遍历临时数组，如果碰到索引等于值，则赋给res
        for(int i = 1; i < 501;i ++){
            if(temp[i] == i){
                res = i;
            }
        }
        return res;
    }

    public static void main(String []args){
        int [] arr = {2,2,3,4};
        System.out.println(findLucky1(arr));
    }
}

