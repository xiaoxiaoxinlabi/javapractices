package en.hashTable;

import java.util.*;

public class Intersect_350 {

//    给定两个数组，编写一个函数来计算它们的交集。
//    Example 1:
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    Example 2:
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [4,9]
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list1 = new ArrayList();
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0; i < nums1.length; i ++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0) + 1);
        }

        for(int i = 0; i < nums2.length; i ++){

            if(!map.containsKey(nums2[i])){
                continue;
            }else{
                list1.add(nums2[i]);
                int count = map.get(nums2[i]);
                count--;
                if(count == 0){
                    map.remove(nums2[i]);
                }else{
                    map.put(nums2[i], count);
                }
            }
        }

        int [] res = new int[list1.size()];
        int idx = 0;
        for(int ans : list1){
            res[idx++] = ans;

        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList();
        for(int i : nums2){
            if(map.getOrDefault(i,0) == 0){
                continue;
            }
            map.put(i, map.get(i) - 1);
            arr.add(i);
        }

        int res [] = new int[arr.size()];
        int idx = 0;
        for(int i : arr){
            res[idx++] = i;
        }
        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2){
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int [] ans = new int[list.size()];
        int idx = 0;
        for(int re : list){
            ans[idx++] = re;
        }
        return ans;
    }
}
