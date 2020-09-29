package en.maths;

import javax.print.attribute.IntegerSyntax;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindErrorNums_645 {

//    集S最初包含从1到n的数字。但是不幸的是，由于数据错误，集合中的一个数字被复制到集合中的另一个数字，这导致一个数字的重复和另一个数字的丢失。
//    给定一个表示错误后此集合的数据状态的数组nums。您的任务是首先查找出现两次的号码，然后查找丢失的号码。以数组形式返回它们。

//    Example 1:
//    Input: nums = [1,2,2,4]
//    Output: [2,3]
    public int[] findErrorNums(int[] nums) {

        Map<Integer, Integer> map = new HashMap();
        int [] res = new int[2];

        int sum = 0;

        for(int i = 0; i < nums.length; i ++){

            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

       for(int i = 0; i < nums.length; i ++){

           if(map.containsKey(nums[i]) && map.get(nums[i]) == 2){
               res[0] = nums[i];
           }
           if(!map.containsKey(i)){
               res[1] = i;
           }
       }
//
//       for(Integer key: map.keySet()){
//           sum+=key;
//       }
//       res[1] = (nums.length*(nums.length+1))/2 - sum;

       return res;

    }

    public int [] findErrorNums1(int [] nums){
        int n = nums.length;
        int sum = 0;
        int [] ans = new int[2];
        HashSet<Integer> hs = new HashSet();
        for(int i = 0; i < n; i++){
            if(hs.contains(nums[i])){
                ans[0] = nums[i];
            }else{
                hs.add(nums[i]);
                sum+=nums[i];
            }
        }
//        前n项和减去 存入 set中的和，就是剩余的数字
        ans[1] = (n*(n+1))/2 - sum;
        return ans;
    }

    public int [] findErrorNums2(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        int x = -1, y = -1;
        for(int i = 0; i < nums.length; i ++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                x = nums[i];
            }
        }

        for(int i = 1; i <= nums.length; i ++){
            if(!set.contains(i)){
                y = i;
                break;
            }
        }
        return new int []{x,y};
    }

//    用时 1ms
    public int [] findErrorNums3(int [] nums){
        int [] arr = new int[nums.length+1];
        int x = -1, y = -1;

        for(int i = 0; i < nums.length; i ++){
            arr[nums[i]]++;
        }
        for(int i = 1; i <= nums.length; i ++){
            if(arr[i] == 2){
                x = i;
            }
            if(arr[i] == 0){
                y = i;
            }
        }
        return new int[]{x,y};
    }

    public int [] findErrorNums4(int [] nums){
        int x = -1, y = -1;
        for(int i = 0; i < nums.length; i ++){
            if(nums[Math.abs(nums[i])-1] < 0){
                x = Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i])-1] *=-1;
            }
        }

        for(int i = 1; i <= nums.length; i ++){
            if(nums[i-1] > 0){
                y = i;
            }
        }
        return new int[]{x,y};
    }

    public int [] findErrorNums5(int [] nums){
        int res[] = new int[2];
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            int newIndex = Math.abs(nums[i])-1;
            sum = sum + i + 1 - Math.abs(nums[i]);

            if(nums[newIndex] > 0){
                nums[newIndex] = nums[newIndex]* -1;
            }else{
                res[0] = Math.abs(nums[i]);
            }
        }
        res[1] = sum + res[0];
        return res;
    }

}
