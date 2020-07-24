package en;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray_1389 {
//    给定一个数组，和索引所组成的数组
//    返回索引所指的数组中的元素的重新排列

    public int [] createTargetArray1(int [] nums, int [] index){

        int [] target = new int[nums.length];
        target[0] = nums[index[0]];

        for(int i = 1; i < index.length; i ++){
            int idx = index[i];
            if(index.length - 1 - idx >=0){
                System.arraycopy(target, idx, target, idx+1, index.length-1-idx);
                target[idx] = nums[i];
            }
        }
        return target;

    }

    public int [] createTargetArray2(int [] nums, int [] index){

        List<Integer> target = new ArrayList();
//        先将数组中的值按照key, value 的形式放入list
        for(int i = 0; i < nums.length; i ++){
            target.add(index[i], nums[i]);
        }
//        定义一个数组，遍历数组，并将数组中的值全部赋给新的数组
        int [] t = new int[nums.length];
        for(int i = 0; i <nums.length; i ++){
            t[i] = target.get(i);
        }
        return t;
    }
}

