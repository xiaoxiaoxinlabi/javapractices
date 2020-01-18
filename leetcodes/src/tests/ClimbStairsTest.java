package tests;

import java.util.HashMap;

public class ClimbStairsTest {

//    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//    规律：下一项的和是前两项的和

    public int climbStairs(int n){

        int [] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i = 2; i <= n; i ++){

            steps[i] = steps[i - 1]+steps[i - 2];

        }

        return steps[n];


    }

    public int climStairs1(int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        map.put(2,2);
        if (n < 3) return map.get(n);
        for (int i = 3; i < n ; i ++){
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }

        return map.get(n - 1) + map.get(n - 2);
    }

    public int climbStairs2(int n){
        if (n == 0 || n == 1 || n == 2)return n;
        int [] steps = new int [n];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i ++){
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n - 1];

    }

    public int climbStairs3(int n){
        if (n < 3)return n;
        int n1 = 1;
        int n2 = 2;
        int result = 2;
        for(int i = 3; i <= n; i ++){
            result = n2 + n1;
            n1 = n2;
            n2 = result;
        }
        return  result;
    }


    public static void main(String [] args){

        ClimbStairsTest cl = new ClimbStairsTest();
        int result = cl.climbStairs3(10);
        System.out.println(result);


    }
}
