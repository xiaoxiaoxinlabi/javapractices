package en.maths;

import java.util.ArrayList;

public class BinaryGap_868 {
//    给定正整数N，以N的二进制表示形式找到并返回两个相邻的1之间的最长距离。
//    如果没有两个相邻的1，则返回0。

    public static int binaryGap(int N) {

        String binaryStr = Integer.toBinaryString(N);
        System.out.println(binaryStr);
        int count = 0;
        int max = 0;

        for(int i = 0; i < binaryStr.length(); i ++){
            if(binaryStr.charAt(i) == '1'){

                max = Math.max(max, count);
                count = 1;
            }else{

                count ++;

            }

        }
        return max;

    }

    public int binaryGap1(int N){
        int count = 0;
        int distance = 0;
        while(N > 0){
            int remainer = N % 2;
            if(remainer == 1){
                if(count != 0){
                    if(distance < count){
                        distance = count;
                    }
                    count = 0;
                    N = N * 2;
                }else{
                    count++;
                }
            }
            if(remainer == 0){
                if(count != 0){
                    count++;
                }
            }
            N = N / 2;
        }
        return distance;
    }
    public int binaryGap2(int N){
        int res = 0, tmp = 1;
        boolean flag = false;
//        如果N 不为0 ，则继续除2
        while(N != 0){
//            如果N对2 取余 不为0 ，并且 flag = false, 说明转为2进制之后为1
            if(N % 2 != 0 && !flag){
                flag = true;
//                如果N对2 取余 不为0 ，并且 flag = true, 则找出最大的距离，并设置tmp 为1
            }else if(N % 2 != 0 && flag){
                res = Math.max(tmp,res);
                tmp = 1;
//                如果转为2进制不为1 ，则tmp加加
            }else if(N % 2 == 0 && flag){
                tmp++;

            }
//            对2 取整
            N = N / 2;
        }
        return res;
    }

    public int binaryGap3(int N){
        String s = Integer.toBinaryString(N);
        ArrayList<Integer> list1 = new ArrayList();
//        找到1之后，将其所对应的索引添加到list中
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '1'){
                list1.add(i);
            }
        }

//        遍历list,找出相邻两个值之间的差的绝对值，将其添加到list2中
        ArrayList<Integer> list2 = new ArrayList();
        for(int i = 0; i < list1.size()-1;i++){
            list2.add(Math.abs(list1.get(i) - list1.get(i+1)));
        }
        int distance = 0;
//        遍历list2,如果找到最大的值，则将其赋给 distance
        for(int i = 0; i < list2.size(); i ++){
            if(distance < list2.get(i)){
                distance = list2.get(i);
            }
        }
        return distance;
    }

    public int binaryGap4(int N){
//        将其转换为二进制字符串
        String s = Integer.toBinaryString(N);
//        定义两个变量，max 用于记录最大的距离， prev 用于记录前一个1的位置
        int max = 0, prev = -1;
//        遍历字符串
        for(int i = 0; i < s.length(); i ++){
            char cur = s.charAt(i);
//            如果当前字符为1 ，并且前面一个存在的1的索引不为 -1 ，则 找出最大的距离
            if(cur == '1'){
                if(prev != -1){
                    max = Math.max(max, i - prev);
                }
//                将其i作为下一个1开始的索引起始位置
                prev = i;
            }
        }
        return max;
    }

    public static void main(String [] args){
        binaryGap(5);
    }
}
