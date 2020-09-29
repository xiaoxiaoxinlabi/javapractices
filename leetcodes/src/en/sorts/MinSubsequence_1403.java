package en.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence_1403 {

//    给定数组num，请获取其元素总和大于未包含的元素总和
//    如果存在多个解决方案，则返回最小长度的子序列
//    如果仍然存在多个解决方案，则以其所有元素的总和最大的形式返回子序列。
//    可以通过从数组中删除一些（可能为零）元素来获得数组的子序列。
//    注意，具有给定约束的解决方案保证是唯一的。还返回以非递增顺序排序的答案。

//    Example 1:
//
//    Input: nums = [4,3,10,9,8]
//    Output: [10,9]
//    Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements.
//

    public List<Integer> minSubsequence(int[] nums) {

        int sum = 0;
        for(int i: nums){
            sum+=i;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        int num = 0, idx = nums.length-1;
        while(num <= sum - num){
            list.add(nums[idx]);
            num+=nums[idx--];
        }
        return list;

    }

    public List<Integer> minSubsequence1(int [] nums){
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        int sum = 0, min = 0;
        for(int i : nums){
            sum+=i;
        }

        for(int i = nums.length-1; i >= 0; i--){
            sum = sum - nums[i];
            list.add(nums[i]);
            min+=nums[i];
            if(min > sum){
                break;
            }
        }
        return list;
    }

    public List<Integer>minSubsequence2(int [] nums){
        int n = nums.length;
        nums = countSort(nums,n);
        int prefixSum [] = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i ++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        int sum = 0;
        List<Integer> list = new ArrayList();
        for(int i = n - 1; i >= 0; i--){
            sum+=nums[i];
            list.add(nums[i]);
            if(i > 0 && prefixSum[i-1] < sum){
                break;
            }
        }

        return list;
    }

    private int [] countSort(int [] arr, int n){
        int count[] = new int[101];
        int output[] = new int[n];
        for(int val : arr){
            count[val]++;
        }

        for(int i = 1; i <101; i++){
            count[i]+=count[i-1];
        }

        for(int i = n-1; i>=0; i--){
            output[--count[arr[i]]] = arr[i];
        }
        return output;
    }
}
