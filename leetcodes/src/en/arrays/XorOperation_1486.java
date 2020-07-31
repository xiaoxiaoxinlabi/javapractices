package en;

public class XorOperation_1486 {
//
//    定义一个数组nums，其中nums [i] =开始+ 2 * i（0索引），n == nums.length。
//    返回所有num元素的按位异。

    public int xorOperation(int n, int start){

        int res = 0;
//        依次遍历数组，按照公式计算
        for(int i = 0; i < n; i ++){
            res ^= start + 2 * i;

        }

       return res;
    }

    public int xorOperation1(int n, int start){
        int ans = start,count = 1;
        for(int i = start+2; count!=n; i = i+2){
            ans = ans^i;
            count++;
        }
        return ans;
    }

//    递归思想
    public int xorOperation2(int n, int start){
        if(n == 0){
            return 0;
        }
        return xorOperation2(n - 1, start+2)^start;
    }

}
