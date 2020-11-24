package en.hashTable;

import java.util.*;

public class DistributeCandies_575 {
//    爱丽丝有n个糖果，第i个糖果的类型为candyType [i]。爱丽丝注意到她开始发胖，这就是为什么她去看医生。
//    医生建议爱丽丝只吃n / 2的糖果（n总是偶数）。爱丽丝非常喜欢她的糖果。她想吃最大数量的不同类型的糖果。
//    给定长度为n的整数数组candyType，返回她可以吃的不同类型的糖果的最大数量，达到医生的建议。
//    Input: candyType = [1,1,2,2,3,3]
//    Output: 3
//    Input: candyType = [1,1,2,3]
//    Output: 2
//    Input: candyType = [6,6,6,6]
//    Output: 1

    public int distributeCandies(int[] candyType) {

        Map<Integer,Integer> map = new HashMap();
        int num = candyType.length;

        for(int i = 0; i < num; i ++){
            map.put(candyType[i], map.getOrDefault(candyType[i], 0) + 1);

        }
        int res = map.size();
        if(num / 2 <= map.size()){
            res = num / 2;
        }
        return res;
    }

    public int distributeCandies1(int [] candyType){
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < candyType.length; i ++){
            if(!set.contains(candyType[i])){
                set.add(candyType[i]);
            }
        }
        int typecandys = set.size();
        if(typecandys > candyType.length / 2){
            typecandys = candyType.length / 2;
        }
        return typecandys;

    }

    public int distributeCandies2(int [] candyType){
        Set<Integer> distinct = new HashSet(candyType.length / 2);
        for(int candy : candyType){
            if(distinct.size() >= candyType.length / 2){
                break;
            }
            distinct.add(candy);
        }
        return distinct.size();
    }
    public int distributeCandies3(int [] candyType){
        int half = candyType.length / 2;
        Set<Integer> set = new HashSet(candyType.length);
        for(int type : candyType){
            set.add(type);
            if(set.size() >= half){
                return half;
            }
        }
        return set.size();
    }
    public int distributeCandies4(int [] candyType){
        return (int) Math.min(candyType.length / 2, Arrays.stream(candyType).distinct().count());
    }
}
