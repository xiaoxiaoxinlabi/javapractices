package en;

public class FindTheDistanceValue_1385 {


//    给定两个整数数组arr1和arr2，以及整数d，返回两个数组之间的距离值。
//    距离值被定义为元素arr1 [i]的数量，使得不存在任何元素arr2 [j]，其中| arr1 [i] -arr2 [j] | <= d。


    public int findTheDistanceValue1(int [] arr1, int [] arr2, int d){
        int k = 0;
//        开始的数量为 arr1, 的所有数量
        int count = arr1.length;
//        依次循环遍历arr1， arr2,
        for(int m = 0; m < arr2.length && k < arr1.length; m++){
//            如果arr1 的第一个值 依次与arr2 的所有值进行差值比较
            if(Math.abs(arr1[k] - arr2[m]) <= d){
//                如果小于等d, 则k 前进
                k++;
//                m 则从头开始
                m = -1;
//                count 则减一
                count--;
            }
//            如果到达了 arr2 的最后
            if(m == arr2.length - 1){
//                k 加1
                k++;
//                m 初始化
                m = -1;
            }
        }

        return count;
    }

//    反向思维
    public int findTheDistanceValue2(int [] arr1, int [] arr2, int d){
        int distance = arr1.length;

        outer:
        for(int n1: arr1){
            for(int n2:arr2){
                if(Math.abs(n1 - n2) <=d){
                    distance--;
                    continue outer;
                }
            }
        }
        return distance;
    }

//    正向思维

    public int findTheDistanceValue3(int [] arr1, int [] arr2, int d){
        int count = 0;
        for(int i = 0; i < arr1.length; i ++){
            boolean flag = false;
            for(int j = 0; j < arr2.length; j ++){
                if(Math.abs(arr1[i] - arr2[j]) <=d){
                    flag = true;
                }
            }
            if(!flag){
                count++;
            }

        }
        return count;
    }
}
