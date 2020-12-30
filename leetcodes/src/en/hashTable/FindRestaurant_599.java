package en.hashTable;

import java.util.*;

public class FindRestaurant_599 {
//    找到两个数组中共同值得索引最小之和，如果有多个则全部输出

    public String[] findRestaurant(String[] list1, String[] list2) {

        int bestSum = Integer.MAX_VALUE;
        List<String> answer = new ArrayList();

        Map<String, Integer> map = new HashMap();

        for(int idx = 0; idx < list1.length; idx++){
            map.put(list1[idx],idx);
        }

        for(int idx = 0; idx < list2.length; idx ++){
            Integer otherIdx = map.get(list2[idx]);

            if(otherIdx != null){
                int sum = otherIdx + idx;

                if(sum < bestSum){
                    answer.clear();
                    bestSum = sum;
                }

                answer.add(list2[idx]);

            }
        }

        return answer.toArray(new String[answer.size()]);

    }

    public  String[] findRestaurant1(String[] list1, String[] list2){
        ArrayList<String> list = new ArrayList();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i ++){
            for(int j = 0; j < list2.length; j ++){
                if(list1[i].equals(list2[j])){
                    map.put(list1[i], i + j);
                }
            }
        }

        int sum_min_idex = Collections.min(map.values());
        for(Map.Entry<String, Integer> set : map.entrySet()){
            if(set.getValue() == sum_min_idex){
                list.add(set.getKey());
            }
        }
        return list.toArray(new String[0]);

    }
}
