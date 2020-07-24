package en;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers_1380 {

//    给定一个m * n个不同数字的矩阵，以任意顺序返回矩阵中的所有幸运数字。
//    幸运数字是矩阵的一个元素，因此它是行中的最小元素，列中的最大元素

    public List<Integer> luckyNumbers1(int [][] matrix){

        List<Integer> list = new ArrayList();
        int row = 0;
        while(row < matrix.length){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int index = -1;
            boolean b = true;
//            循环遍历列，找出列中最大元素
            for(int i = 0; i < matrix[0].length; i ++){

                if(min > matrix[row][i]){
                    min = matrix[row][i];
                    index = i;
                }

            }

            for(int i = 0; i < matrix.length; i ++){
                if(row == i){
                    continue;
                }
                if(matrix[row][index] < matrix[i][index]){
                    b = false;
                }
            }
            if(b){
                list.add(matrix[row][index]);
            }
        }
        return list;


    }

    public List<Integer> luckyNumbers2(int [][] maritx){
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        List<Integer> list3 = new ArrayList();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
//        找出行中的最小值
        for(int i = 0; i < maritx.length;i++){
            min = Integer.MAX_VALUE;
            for(int j = 0; j < maritx[0].length; j ++){
                if(maritx[i][j] < min){
                    min = maritx[i][j];
                }
            }
            list1.add(min);
        }

//        找出列中的最大值
        for(int i = 0; i < maritx[0].length; i ++){
            max = Integer.MIN_VALUE;
            for(int j = 0; j < maritx.length; j ++){
                if(maritx[j][i] > max){
                    max = maritx[j][i];
                }
            }
            list2.add(max);
        }

//        遍历list1， 如果list2中包含list1中的值，则说明是幸运数
        for(Integer i : list1){
            if(list2.contains(i)){
                list1.add(i);
            }
        }
        return list3;

    }


}
