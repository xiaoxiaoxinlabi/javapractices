public class Test14a {

//  剪绳子

//  给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

//  输入: 2
//  输出: 1
//  解释: 2 = 1 + 1, 1 × 1 = 1

//  输入: 10
//  输出: 36
//  解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

//  解题思路：
//  最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况
//  次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1。
//  最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 1 替换为 2 + 2，因为  2×2>3×1。

//  尽可能将绳子以长度 33 等分为多段时，乘积最大。
  public int cuttingRope1(int n){
    if(n <= 3){
      return n-1;
    }
    int a = n/3, b = n%3;

//    直接返回 3^a3
    if(b == 0){
      return (int)Math.pow(3,a);
    }
    if(b == 1){
//      要将一个 1 + 3 转换为 2+2，因此返回 Math.pow(3,a-1)*4

      return (int)Math.pow(3,a-1) * 4;
    }
//    当b=2时，返回 Math.pow(3,a)*2

    return (int)Math.pow(3,a)*2;
  }

}