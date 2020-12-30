package en.hashTable;

import java.util.*;

public class RepeatedNTimes_961 {
//在一个大小为2N的数组a中，有N+1个不同的元素，并且其中一个元素重复N次。
//返回重复N次的元素。

    public int repeatedNTimes(int[] A) {

        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < A.length; i ++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> re: map.entrySet()){
            if(re.getValue() == A.length/2){
                return re.getKey();
            }
        }
        return 0;

    }

    public int repeatedNTimes1(int[] A){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i ++){
            if(map.containsKey(A[i])){
                return A[i];
            }
            map.put(A[i],A[i]);
        }

        return 1;

    }

    public int repeatedNTimes2(int [] A){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i ++){
            // Try inserting element in set : If duplicate found, set will return false and we return the value i
            if(set.contains(A[i])){
                return A[i];
            }
            set.add(A[i]);
        }
        return 1;

    }

    public int repeatedNTimes3(int [] A){
        Arrays.sort(A);
        int temp = 0;
        for(int i = 1; i < A.length; i ++){
            if(A[i] == A[i-1]){
                temp = A[i];
            }
        }
        return temp;
    }

//但是如果你仔细阅读问题，这里有一个技巧
//你可以推导出总共有2n个元素的信息
//唯一的n+1个元素
//该函数只使用一个元素
//该元素存在n次，大于1次
    //即使值大于1，我们仍然得到我们的结果
    public int repeatedNTimes4(int [] A){
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int i = 0; i < A.length; i ++){
            int val = map.getOrDefault(A[i],0) + 1;
            map.put(A[i],val);
            if(val == 2){
                res = A[i];
                break;

            }
        }
        return res;
    }

    public static void main(String [] args){
        int [] a = {1,2,3,3};
        System.out.println(new RepeatedNTimes_961().repeatedNTimes1(a));
    }
}
