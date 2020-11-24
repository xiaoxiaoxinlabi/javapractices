package en.maths;

public class MinCostToMoveChips_1217 {

//    我们有n个芯片，第i个芯片的位置是position [i]。
//    我们需要将所有筹码移动到同一位置。第一步，我们可以将第i个芯片的位置从position [i]更改为：
//    费用为0的position [i] + 2或position [i]-2。
//    费用= 1的位置[i] +1或位置[i]-1。
//    返回将所有芯片移至同一位置所需的最低成本


//    返回数组中的，偶数个数，奇数个数中最小的值

    public int minCostToMoveChips(int[] position) {

        int a[] = {0,0};
//        如果能被2 整除则需要挪2步，否则是1步
        for(int i : position){
            a[i % 2]++;
        }
        return Math.min(a[0],a[1]);

    }

    public int minCostToMoveChips1(int [] position){
        int evensum = 0, oddsum = 0;

        for(int i = 0; i < position.length; i ++){
            if(position[i] % 2 == 0){
                evensum = evensum + 1;
            }else{
                oddsum = oddsum + 1;
            }
        }
        return Math.min(oddsum, evensum);
    }
}
