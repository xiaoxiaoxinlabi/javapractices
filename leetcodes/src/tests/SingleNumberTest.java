package tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumberTest {

//    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

//    方法一：去处重复的元素
//    遍历整个数组，如果之前未遇到过某个数，将其暂时保存起来；如果之前遇到过这个数，则删除之前保存的。那么，遍历完一遍之后，必然有一个数字剩余下来，这个数就是本题的解。
    public int singleNumber(int [] nums){

        Set<Integer> set = new HashSet<Integer>();
        for (int i: nums){

            if (set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }

        return set.iterator().next();


    }

//    方法二：要求出一个数组中未重复的那一个数字，可以先对这个数组进行排序，那么所有的重复的数字必然是连续的，所以，只要找到第一个落单的数字，它必然就是解。
    public int singleNumber1(int [] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2){
            if (nums[i] != nums[i - 1]){
                return nums[i-1];
            }
        }

        return nums[nums.length - 1];
    }

//    方法三：异或求解
//    看如下公式：
//
//    a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b，即异或操作满足交换律，那么，如果将整个数组进行异或的话，因为交换律，必然有n1 ^ n2 ^ ... ^ nn = (n1 ^ ni) ^ (n2 ^ nj) ^ ... ^ nn = nn，其中 nn 为非重复数字，所以，只需要一次遍历，将所有的数字异或运算即可。
//    异或运算有两个特性：
//
//            1、一个数异或本身恒等于0，如5^5恒等于0；
//
//            2、一个数异或0恒等于本身，如5^0恒等于5。
//
//    交换两个整数a和b,无非是a=b和b=a这两个操作，当然，你不能直接这么做。该怎么变呢？
//
//    算式一：a=b^(a^a)=a^(a^b);
//
//    算式二：b=a^(b^b)^(a^a)=a^(a^b)^(a^b);
//
//    注意上面算式二中的a还是原来的a，不要认为是改变后的a。
//
///    至此完成了两个整数的交换。

//      1、一个数异或本身恒等于0，如5^5恒等于0；(相同的两个数异或的结果为0)
//      2、一个数异或0恒等于本身，如5^0恒等于5。
    public int singleNumber2(int [] nums){
        int result = 0;
        for (int n: nums){
            result = result ^ n;
        }
        return result;
    }

    public static void main(String [] args){

        SingleNumberTest singleNumberTest = new SingleNumberTest();
        int [] arr = {2,2,1};
        int [] arr1 = {4,1,2,1,2};
        System.out.println(singleNumberTest.singleNumber2(arr));

    }
}


//
//            Iterator <Integer> itea = map.keySet().iterator();
//            while(itea.hasNext()){
//                if (map.get(itea.next()).equals(1)){
//                    temp = itea.next();
//                }
//            }