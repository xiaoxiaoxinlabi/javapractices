public class AddStrings_415 {

//  415. 字符串相加
//  给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//  注意：
//
//  num1 和num2 的长度都小于 5100.
//  num1 和num2 都只包含数字 0-9.
//  num1 和num2 都不包含任何前导零。
//  你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

//  算法流程： 设定 i，j 两指针分别指向 num1，num2 尾部，模拟人工加法；
  public static String addStrings(String num1, String num2){

    StringBuilder res = new StringBuilder();
    int i = num1.length() - 1, j = num2.length()-1, carry = 0;
    while(i >=0 || j >=0){
//      / 判断是否越界 越界就是0 不越界的话就取那个数
      int n1 = i >=0? num1.charAt(i) - '0' : 0;
      int n2 = j >=0 ? num2.charAt(j) - '0' : 0;
//      求和
      int temp = n1+n2+carry;
//      计算进位： 计算 carry = tmp /10，代表当前位相加是否产生进位；
      carry = temp/10;

//     ，拼接
      res.append(temp%10);
      i--;
      j--;
    }
//    当遍历完 num1，num2 后跳出循环，并根据 carry 值决定是否在头部添加进位 1，最终返回 res 即可。
    if(carry == 1){
      res.append(1);

    }
//    最后将结果翻转
    return res.reverse().toString();


  }


}
