package en.hashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPrimes_204 {

//    计算小于非负数n的质数。
    public int countPrimes(int n) {

      boolean [] arr = new boolean[n];
      int count = 0;
      for(int i = 2; i < n; i ++){
          if(arr[i]){
              continue;
          }
          count++;
          for(int j = 2; i * j < n; j ++){
              arr[i * j] = true;
          }
      }
      return count;
    }

    public int countPrimes1(int n){
        if(n <= 1){
            return 0;
        }
        boolean [] sieve = new boolean[n];

//        先将所有的i所对应的boolean值设为true
        for(int i = 0; i < n; i ++){
            sieve[i] = true;
        }
//        循环遍历n
        for(int i = 2; i * i < n; i ++){
//            如果当前值对应的boolean为true
            if(sieve[i]){
//                则校验 i是否有其他的乘数，如果有则设置为false
                for(int j = i * i; j < n; j+=i){
                    sieve[j] = false;
                }
            }
        }

        int cnt = 0;
        for(int i = 2; i < n; i ++){
            if(sieve[i]){
                cnt++;
            }
        }
        return cnt;
    }

    public int countPrimes2(int n){
        if(n < 0){
            return 0;
        }
        boolean [] primes = new boolean[n];
//        给数组赋值
        Arrays.fill(primes,true);
        for(int i = 2; i * i < primes.length; i ++){
            if(primes[i]){
                for(int j = i; j * i < primes.length; j ++){
                    primes[j * i] = false;
                }
            }
        }
        int primesCnt = 0;
        for(int i = 2; i < primes.length; i ++){
            if(primes[i]){
                primesCnt++;
            }
        }
        return primesCnt;
    }

    public int countPrimes3(int n){
        boolean [] visited = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i ++){
            if(visited[i] == false){
                count++;

                for(int j = 2; i * j < n; j ++){
                    visited[i * j] = true;
                }
            }
        }
        return count;
    }
}
