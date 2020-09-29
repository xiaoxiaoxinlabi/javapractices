package en.maths;

import java.util.HashSet;

public class IsHappy_202 {


//    一个快乐的数字是由以下过程定义的数字：
//    从任何正整数开始，用该数字的平方和代替该数字，然后重复该过程，直到该数字等于1（它将停留在该位置），
//    否则它就会循环在不包含1的循环中无休止地循环。以1结尾的那些数字是快乐数字。
//    如果是快乐数则返回 true, 否则返回false
//    Input: 19
//    Output: true
//    Explanation:
//            12 + 92 = 82
//            82 + 22 = 68
//            62 + 82 = 100
//            12 + 02 + 02 = 1
//

    public boolean isHappy(int n){

        HashSet<Integer> hashSet = new HashSet();
        while(true && n != 1){
            n = happy(n);
            if(hashSet.contains(n)){
                return false;
            }else{
                hashSet.add(n);
            }
        }
        if(n == 1){
            return true;
        }else{
            return false;
        }

    }

    private int happy(int n){
        int sum = 0;
        while(n!= 0){
            int digit = n % 10;
            n = n / 10;
            sum = sum + digit*digit;
        }
        return sum;
    }

    public boolean isHappy1(int n){
        if(n < 1){
            return false;
        }
        HashSet<Integer> number = new HashSet();
        while(number.add(n)){
            int sum = 0;
            while(n > 0){
                int rem = n % 10;
                sum+=rem*rem;
                n/=10;
            }
            if(sum == 1){
                return true;
            }
            n = sum;
        }
        return false;
    }

    public boolean isHappy2(int n){
        int res ;
        HashSet<Integer> h = new HashSet();
//        判断n 是否在hashset中
        while(!h.contains(n)){
//            如果不在将其添加到hashset中去
            h.add(n);
            res = 0;
//            如果n 大于0 ，则计算当前n 的每一位数字的平方和
            while(n > 0){

                res+=Math.pow(n%10,2);
                n/=10;
            }
//            如果 和为1 则返回true
            if(res == 1){
                return true;
            }
//            将res 赋值给 n
            n = res;
        }
        return false;
    }



}
