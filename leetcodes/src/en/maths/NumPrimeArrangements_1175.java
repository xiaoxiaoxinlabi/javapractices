package en.maths;

import java.util.Arrays;

public class NumPrimeArrangements_1175 {

//    返回1到n的排列数，以使素数处于素数索引（1索引）。
//            （请记住，当且仅当整数大于1时，它才是质数，并且不能将其写为两个均小于它的正整数的乘积。）
//    由于答案可能很大，因此请以10 ^ 9 + 7为模返回答案。
//    Example 1:
//
//    Input: n = 5
//    Output: 12
//    Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.

//    Example 2:
//    Input: n = 100
//    Output: 682289015


    public int numPrimeArrangements(int n) {

        int mod = 1000000007;
        long cnt = 1;
        int prime = 0;
        int nprime = 0;
        for(int i = 1; i <= n; ++i){
            if(!isPrime(i)){
                ++nprime;
                cnt = cnt * nprime % mod;
            }else{
                ++prime;
                cnt = cnt * prime % mod;
            }
        }

        return (int)cnt;

    }

    private boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i * i <n; i ++){
            if(n % i == 0){
                return false;
            }

        }
        return true;
    }

    public int numPrimeArrangements1(int n){
        int mod = 1000000007;
        int [] primes = new int [] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int primeCount = Math.abs(Arrays.binarySearch(primes,n)+1);
        int nonprimes = n - primeCount;

        long pp = 1, np = 1;
        while(primeCount > 1){
            pp = (pp * primeCount--) % mod;
        }
        while(nonprimes > 1){
            np = (np * nonprimes--) % mod;
        }
        return (int)((pp * np) % mod);
    }
}
