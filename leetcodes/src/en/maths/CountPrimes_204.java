package en.maths;

import java.util.Arrays;

public class CountPrimes_204 {

//    计算小于非负数n的质数个数
//    Example:
//    Input: 10
//    Output: 4
//    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.


    public static int countPrimes(int n) {

        if(n <= 2){
            return 0;
        }
        int count = 0;
        boolean flag ;
        for(int j = 2; j < n; j ++){
            flag = true;
            for(int i = 2; i < j; i++){
                if(j % i == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(j);
                count++;
            }

        }
        return count;

    }

    public int countPrimes1(int n){
        int num = 0, j;
        boolean flag;
        for(int i = 2; i <n; i ++){
            flag = true;
            for(j = 2; j <= i / 2; j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }if(flag){
                num++;
            }
        }
        return num;

    }

    public int countPrimes2(int n){
//        boolean 默认值为 false
        boolean [] visited = new boolean[n];
        int count = 0;

        for(int i = 2; i < n; i ++){
            if(visited[i] == false){
                count++;
                for(int j = 2; i * j < n; j ++){
                    visited[i*j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes3(int n){
        if(n < 2){
            return 0;
        }
        int count = n - 2;
        //false = prime
        boolean [] primes = new boolean[n];
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(!primes[i]){
                for(int j = i*i;j < n ; j+=i){
                    if(!primes[j]){
                        primes[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public int countPrimes4(int n){
        if(n <= 2){
            return 0;
        }
//        定义boolean数组判断其对应的n是否为质数
        boolean [] prime = new boolean[n];
//        将其全部设置为 true
        Arrays.fill(prime,true);
//        假设改从0 到 n共有质数 n - 2 个
        int count = n - 2;
//        便利n
        for(int i = 2; i * i < n; i++){
            for(int j = i; j * i < n; j++){
//                如果i * j 所对应的prime 为true, 则将其置位 false,然后质数个数减减
                if(prime[i*j]){
                    prime[i*j] = false;
                    count--;
                }
            }
        }
        return count;

    }

//    质数：只能被1和本身整数
    public int countPrimes5(int n){
//        通过prime 判断从0到n 是否为质数； false表示是，true表示否
        boolean [] prime = new boolean[n];
        int primeCount = 0;
        for(int i = 2; i * i < prime.length; i ++){
//            如果i 为质数
            if(!prime[i]){
//                则 i*j 所对应的数字为非质数（）
                for(int j = 2; j * i < prime.length; j ++){
                    prime[i*j] = true;
                }
            }
        }
//        再次遍历，如果 prime 为false,则数量加一
        for(int i = 2; i < prime.length; i ++){
            if(!prime[i]){
                primeCount++;
            }
        }
        return primeCount;
    }

    public int countPrimes6(int n){
        if(n < 2){
            return 0;
        }
        int count = 0;
        boolean arr[] = new boolean[n];
        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i *i < n; i++){
            if(arr[i] == false){
                for(int j = i*i; j < n; j+=i){
                    arr[j] = true;
                }
            }
            for(boolean b : arr){
                if(b == false){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String [] args){
        countPrimes(10);
    }
}
