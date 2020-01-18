package tests;

import java.util.ArrayList;
import java.util.List;

public class GenerateTest {

//    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//    在杨辉三角中，每个数是它左上方和右上方的数的和。

    public List<List<Integer>> generate(int numRows){

        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> rows = new ArrayList<Integer>();

        for (int i = 0; i < numRows; i ++){
            rows.add(0,1);
            for (int j = 1; j < rows.size() - 1; j ++){
                rows.set(j,rows.get(j) + rows.get(j + 1));
            }

            allrows.add(new ArrayList<Integer>(rows));
        }

        return allrows;

    }



    public List<List<Integer>> generate1(int numRows){
        List<List<Integer>> result = new ArrayList();

//        numRows 控制的是最外层的list的size
        for (int i = 0; i < numRows; i ++){
            List<Integer> list = new ArrayList();


            for (int j = 0; j <= i; j ++){
//                如果是第一个或者最后一个元素，则默认置为：1
                if (j == 0 || j == i){
                    list.add(1);
                }else {
//                    否则：当前值为 result中前一个index中的list中左右index的值相加
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);

                }
            }

            result.add(list);
        }

        return result;
    }





    public static void main (String [] args){
        GenerateTest generateTest = new GenerateTest();
        List<List<Integer>> newList = generateTest.generate1(3);
        for (List arr:newList) {
            System.out.println(arr);
        }
    }
}
