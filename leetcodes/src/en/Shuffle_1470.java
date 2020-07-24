package en;

public class Shuffle_1470 {

//    给定由2n个元素组成的数组num，格式为[x1，x2，...，xn，y1，y2，...，yn]。
//    返回格式为[x1，y1，x2，y2，...，xn，yn]的数组。
//    Input: nums = [2,5,1,3,4,7], n = 3
//    Output: [2,3,5,4,1,7]
//    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

    public int [] shuffle1(int [] nums, int n){
        int [] res = new int[2*n];
//        遍历n 偶数则值为当前值，否则为当前索引+n 的值
        for(int i = 0; i< n; i ++){
           res[2*i] = nums[i];
           res[2*i+1]=nums[i+n];
        }
        return res;
    }
}
