package en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanBeEqual_1460 {

//    给定两个长度相同的数组，将第一个数组翻转多次，使得其与第二个数组值的顺序相同
    
        public boolean canBeEqual1(int [] target, int [] arr){

            int [] tmp = new int[1001];

            for(int i = 0; i < target.length; i ++){
                tmp[target[i]]++;
            }

            for(int i = 0; i < arr.length; i ++){
               if(tmp[arr[i]] == 0){
                   return false;
               }else{
                   tmp[arr[i]]--;
               }
            }

            return true;
        }

        public boolean canBeEqual11(int [] target, int [] arr){
            int[] current = new int[1001];
            for (int x : target)
                current[x]++;
            for (int x : arr)
                if (current[x] == 0)
                    return false;
                else
                    current[x]--;
            return true;
        }

        public boolean canBeEqual2(int [] target, int [] arr){
            Arrays.sort(target);
            Arrays.sort(arr);
            return Arrays.equals(target,arr);
        }

        public boolean canBeEqual3(int [] target, int [] arr){
            Map<Integer, Integer> map = new HashMap();

            for(int item: arr){
                map.put(item, map.getOrDefault(item, 0)+1);
            }
            for(int item: target){
                if(map.getOrDefault(item,0)==0){
                    return false;
                }else{
                    map.put(item, map.get(item)-1);
                }
            }
            return true;
        }
}
