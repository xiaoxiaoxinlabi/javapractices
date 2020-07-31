package en;

public class Fib_509 {


//斐波那契数通常表示为F（n）形成一个称为斐波那契数列的序列，这样每个数都是从0和1开始的两个前一个数的和。
//  F(0) = 0,   F(1) = 1
//  F(N) = F(N - 1) + F(N - 2), for N > 1.
//  Given N, calculate F(N).

//  斐波那契 数列 --迭代

  public int fib1(int N){

    if(N < 2){
      return N;
    }

//    首先定义变量 first,表示第一个变量，second 表示第二个变量， third 为前两个的和
    int first = 0;
    int seconde = 1;
    int cur = 0;

    for(int i = 2; i <=N; i++){
//      计算前两个的和
      cur = first + seconde;

//      first 指向下一个 second
      first = seconde;
      seconde = cur;
    }
    return cur;

  }

//  迭代2
  public int fib11(int N){
    if(N <=1){
      return N;
    }
    if(N ==2){
      return 1;
    }

    int current = 0;
    int prev1 = 1;
    int prev2 = 1;
    for(int i = 3; i <=N; i++){

//      将当前值设置为fib（N-1）+ fib（N-2）
      current = prev1 + prev2;
//      将prev2值设置为fib（N-1）。
      prev2 = prev1;
//      将prev1值设置为current_value
      prev1 = current;
    }

    return current;

  }

  public int fib12(int N){
    if(N==0){
      return 0;
    }
    int pre = 0;
    int cur = 1;
    for(int i = 2; i <=N; i ++){
      int tmp = cur;
      cur=cur + pre;
      pre = tmp;
    }
    return cur;
  }

//  采用递归的方式
  public int fib2(int N){
    if(N < 2){
      return N;
    }
    return fib2(N-1) + fib2(N-2);
  }

//  采用dp
//  Time complexity : O(N) 每个数字（从2开始直到N，包括N）都将被访问，计算和存储，以便以后进行O（1）
//  Space complexity : O(N) 数据结构的大小与N成正比
  public int fib3(int N){

    if(N <=1){
      return N;
    }

    int [] cache = new int[N+1];
    cache[1] = 1;
    for(int i = 2; i <=N; i++){
      cache[i] = cache[i-1] + cache[i-2];
    }

    return cache[N];

  }


}
