package en.maths;

public class MaxCount_598 {

//    给定一个m * n矩阵，M初始化为全0，并进行了几次更新操作。
//    运算由2D数组表示，每个运算由具有两个正整数a和b的数组表示，这意味着M [i] [j]对于所有0 <= i <a和0 <= j <b。
//    执行所有操作后，您需要计算并返回矩阵中最大整数的数量。

    public int maxCount(int m, int n, int[][] ops) {

        int c = m, r = m;
        for(int [] op : ops){
            c = Math.min(c,op[1]);
            r = Math.min(r, op[0]);
        }
        return r * c;

    }

    public int maxCount1(int m , int n, int [][] ops){
        if(ops == null || ops.length == 0){
            return m * n;
        }
        int minrow = m, mincol = n;

        for(int i = 0; i < ops.length; i ++){
            int [] mat = ops[i];

            int rows = mat[0];
            int cols = mat[1];

            if(rows < minrow){
                minrow = rows;
            }
            if(cols < mincol){
                mincol = cols;
            }
        }
        return minrow * mincol;
    }
}
