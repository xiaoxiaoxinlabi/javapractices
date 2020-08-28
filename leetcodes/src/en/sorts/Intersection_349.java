package en.sorts;

import java.util.*;

public class Intersection_349 {

//    找出两个数组的交集
//    Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2]
//
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]


//    使用两个set
    public int[] intersection(int[] nums1, int[] nums2) {

       HashSet<Integer> set1 = new HashSet<>();
       HashSet<Integer> set2 = new HashSet<>();

//       将第一个数组装入set1 中
       for(int i = 0; i < nums1.length; i ++){
           set1.add(nums1[i]);
       }

//       循环遍历数组2，如果set1 包含这个字符，则将其添加到 set2
       for(int i = 0; i < nums2.length; i ++){

           if(set1.contains(nums2[i])){

               set2.add(nums2[i]);

           }
       }

//       将set2 的值添加给 数组
       int res [] = new int[set2.size()];
       int i = 0;
       for(int x: set2){
           res[i++]=x;
       }
       return res;

    }

    public int [] intersection1(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> ans = new ArrayList();
//        遍历数组1， 将其添加到map中，如果key在map中不存在，则将其value 置为1
        for(int i = 0; i < nums1.length; i ++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }
        }
//        遍历数组2， 如果map中包含数组2 的元素，并且 包含的元素所对应的值为1，则其添加到list中之后，将其值置为0
        for(int i = 0; i < nums2.length; i ++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i])==1){
                    ans.add(nums2[i]);
                    map.put(nums2[i],0);
                }
            }
        }

//        循环遍历将list中的值，添加到数组中
        int [] res = new int[ans.size()];

        for(int i = 0; i < ans.size(); i ++){
            res[i]=ans.get(i);
        }
        return res;
    }


}
