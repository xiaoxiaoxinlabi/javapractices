package en.hashTable;

import java.util.*;

public class Intersection_349 {
//    给定两个数组，编写一个函数来计算它们的交集
//    Example 1:
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2]
//    Example 2:
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
    public int[] intersection(int[] nums1, int[] nums2) {


        int [] largeArr = nums1.length < nums2.length ? nums2 : nums1;
        int [] smallArr = nums1.length < nums2.length ? nums1 : nums2;
        Set<Integer> set = new HashSet();

        for(int i = 0; i < smallArr.length; i ++){
            set.add(smallArr[i]);
        }

        int idx = 0;
        for(int j = 0; j < largeArr.length; j ++){
            if(set.contains(largeArr[j])){
                smallArr[idx ++] = largeArr[j];
                set.remove(largeArr[j]);
            }
        }
        return Arrays.copyOfRange(smallArr, 0, idx);

    }

    public int[] intersection1(int [] nums1, int[] nums2){
        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }

        Set<Integer> set = new HashSet<>();
        int len = Math.min(nums1.length, nums2.length);
        int [] res = new int[len];

        for(int i = 0; i < nums1.length; i ++){
            set.add(nums1[i]);
        }

        int idx = 0;
        for(int j = 0; j < nums2.length; j ++){
            if(set.contains(nums2[j])){
                res[idx ++] = nums2[j];
                set.remove(nums2[j]);
            }
        }
        return Arrays.copyOfRange(res,0,idx);
    }

    public int[] intersection2(int [] nums1, int [] nums2){
        Set<Integer> set1 = new HashSet();
        for(int i = 0; i < nums1.length; i ++){
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet();
        for(int i = 0; i < nums2.length; i ++){
            set2.add(nums2[i]);
        }
//        取交集，但是效率不高
        set1.retainAll(set2);
        int [] res = new int[set1.size()];
        int idx = 0;
        for(Integer i : set1){
            res[idx++] = i;
        }
        return res;
    }

    public int[] intersection3(int[] nums1, int [] nums2){
        List<Integer> l1 = new ArrayList();
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums1.length; i ++){
            if(!l1.contains(nums1[i])){
                l1.add(nums1[i]);
            }
        }
        for(int i = 0; i < nums2.length; i ++){
            if(l1.contains(nums2[i])){
                res.add(nums2[i]);
                l1.remove(new Integer(nums2[i]));
            }
        }

        int [] arr = new int[res.size()];
        int idx = 0;
        for(Integer i : res){
            arr[idx] = i;
            idx++;
        }
        return arr;

    }

}
