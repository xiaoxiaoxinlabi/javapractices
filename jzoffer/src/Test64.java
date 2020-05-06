public class Test64 {

//  求1+2+…+n
//  求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

//  例 1：
//  输入: n = 3
//  输出: 6

//  示例 2：
//  输入: n = 9
//  输出: 45

//  逻辑运算符的短路效应：

//  常见的逻辑运算符有三种，即 “与 \&\&&& ”，“或 ||∣∣ ”，“非 !! ” ；而其有重要的短路效应，如下所示：
//  if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
//if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true


//  本题需要实现 “当 n = 1n=1 时终止递归” 的需求，可通过短路效应实现。
//  n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
//方法1：逻辑效应
  public int sumNums1(int n){
    int res = 0;
//    n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
    boolean x = n > 1 && sumNums1(n - 1) > 0;
    res +=n;
    return res;
  }

  //方法12：逻辑效应
  public int sumNums2(int n){

    boolean x = n  > 1 && (n +=sumNums2(n-1)) > 0;
    return n;

  }

//  方法3：递归

  public int sumNums3(int n){
    if(n == 1) {
      return 1;
    }
    n +=sumNums3(n - 1);
    return n;
  }

//方法4：迭代

  public int sumNums4(int n){
    int res = 0;
    for(int i = 1; i <=n; i ++){
      res+=i;
    }
    return res;
  }

//  方法5：平均计算
  public int sumNums5(int n){
    return (1+n) * n / 2;
  }

}
