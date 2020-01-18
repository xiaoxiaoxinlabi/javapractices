package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetRowTest {

//    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 在杨辉三角中，每个数 = 它正上方 + 左上方的。
//    eg: input:3  ; output:[1,3,3,1]

    public List<Integer> getRow(int rowIndex){
        Integer [] arr = new Integer[rowIndex + 1];
//        Arrays.fill(arrname,value):填充arrname数组中的每个元素都是value
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for (int i = 1; i <= rowIndex; i ++){
            for (int j = i; j > 0; j --){
                arr[j] = arr[j] + arr[j - 1];
            }
        }

        return Arrays.asList(arr);



    }


    public List<Integer> getRow1(int rowIndex){
        List <Integer> list = new ArrayList();
//        首先在list中存入：1
        list.add(1);

//        如果传入的rowindex为0，则直接返回：list
        if (rowIndex == 0) return list;

        int pre = 1;

        for (int j = 1; j <= rowIndex; j ++){
            for (int i = 1; i < j; i ++){

                int temp = list.get(i);
                list.set(i,pre + temp);
                pre = temp;
            }
            list.add(1);
        }

        return list;
    }



    public List<Integer> getRow2(int rowIndex){
        List<Integer> list = new ArrayList();
        int i = 0;
        while(i <= rowIndex){
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < i + 1; j ++){

//                如果是第一个或者最后一个，则为1
                if (j == 0 || j == i){
                    curr.add(1);
                }else {

//                    正上方的索引的值 + 左上方的索引的值
                    curr.add(list.get(j) + list.get(j - 1));
                }


            }

            list = curr;
            i ++;


        }

        return list;
    }

    public static void main(String [] args){
        GetRowTest getRowTest = new GetRowTest();
        List<Integer> result = new ArrayList();
        result = getRowTest.getRow(4);

        for (Integer arr: result){
            System.out.println(arr);
        }

    }
}
