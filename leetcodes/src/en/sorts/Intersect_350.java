package en.sorts;

import java.util.*;

public class Intersect_350 {


//    给定两个数组，编写一个函数来计算它们的交集
//    Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [4,9]

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
//        统计数组1中每个元素出现的次数
        for(int i = 0; i < nums1.length; i ++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
//        遍历数组2，如果map包含当前元素，则将map中当前的元素（key）对应的值-1
        for(int i = 0; i < nums2.length; i ++){
            if(map.get(nums2[i])!=null && map.get(nums2[i])>0){
                map.put(nums2[i],map.get(nums2[i])-1);
//                将交集的值存放在nums1中，并用count计算交集的数量
                nums1[count] = nums2[i];
                count++;
            }
        }

//        遍历数组1，将交集元素赋给新数组
        int a [] = new int[count];
        for(int i = 0; i < count; i ++){
            a[i] = nums1[i];
        }
        return a;

    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list1 = new ArrayList();

        for(int i = 0; i < nums1.length; i ++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }

        for(int j = 0; j < nums2.length; j ++){
            if(map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
                list1.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j])-1);
            }
        }

        int [] res = new int[list1.size()];
        for(int i = 0; i < list1.size(); i++){
            res[i] = list1.get(i);
        }
        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList();
//        先将两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

//        分别定义两个数组的指针之后，遍历数组
        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length){
//            如果相等，则将其添加到list中
            if(nums1[i] == nums2[j]){
                arr.add(nums1[i]);
                i++;
                j++;
//                如果nums1的元素大于nums2的元素，则 j继续往前；否则i 继续往前
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
//        最后将结果赋给一个新数组
        int [] res = new int[arr.size()];
        for(int m = 0; m < arr.size(); m++){
            res[m] = arr.get(m);
        }
        return res;

    }

    public int [] intersect3(int [] nums1, int [] nums2){
        Map<Integer,Integer> map = new HashMap();
        int n = Math.min(nums1.length, nums2.length);
        int[] res = new int[n];
        int k = 0;
        for(int x : nums1){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(int y: nums2){
            if(map.get(y) > 0){
                res[k++] = y;
                map.put(y, map.get(y)-1);
            }
        }
        return Arrays.copyOf(res,k);
    }
}
