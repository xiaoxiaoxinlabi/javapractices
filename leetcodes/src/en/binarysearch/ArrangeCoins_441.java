package en.binarysearch;

public class ArrangeCoins_441 {
//    共有n 个硬币，组成楼梯形状 ，其中第k行必须恰好有k个硬币。
//    给定n，找到可以形成的完整楼梯的行的总数。
//    n是一个非负整数，适合32位有符号整数的范围

    public int arrangeCoins(int n) {

        int ctr = 0;
        while(true){
            if((n-=ctr+1) >= 0){
                ctr++;
            }else{
                break;
            }
        }
        return ctr;

    }

    public int arrangeCoins1(int n){
        int i = 0;
        while(i++ < n){
            n = n - i;
        }
        return i - 1;
    }

    public int arrangeCoins2(int n){
        if(n == 1){
            return 1;
        }
        int count = 1;
        while(n >= count){
            n = n - count;
            count++;
        }
        return count - 1;
    }
}
