public class Test67 {

//  写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。


//  输入: "42"
//  输出: 42

//  输入: "   -42"
//  输出: -42
//
//  输入: "words and 987"
//  输出: 0
//  解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//  因此无法执行有效的转换。




  public int strToInt1(String str){

//    首部空格： 删除之即可；
    char [] c = str.trim().toCharArray();

    if(c.length == 0){
      return 0;
    }
    long res = 0;

    int i = 1;
    //    符号位： 三种情况，即 ''++'' , ''-−'' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可
//    sign = 1 默认符号位为 ‘+’
    int sign = 1;

//    如果第一位是-，则说明是‘-’，将sign 置为 -1
    if(c[0] == '-'){
      sign = -1;

//      如果第一位是不是 ‘+’ ，则说明是无符号位，将i 置为0
    }else if (c[0] != '+'){
      i=0;
    }
    for(int j = i; j < c.length; j ++){
//      非数字字符： 遇到首个非数字的字符时，应立即返回。
      if(c[j] < '0' || c[j] >'9'){
        break;
      }
//      字符转数字： “此数字的 ASCII 码” 与 “ 00 的 ASCII 码” 相减即可；
//      数字拼接： 若从左向右遍历数字，设当前位字符为 cc ，当前位数字为 xx ，数字结果为 resres ，则数字拼接公式为：
      res = res * 10 + (c[j] - '0');

//      在每轮数字拼接后，判断数字结果 resres 是否超过 2^{31} - 1，若超过则加上符号位直接返回。
      if(res > Integer.MAX_VALUE){
        return sign==1? Integer.MAX_VALUE: Integer.MIN_VALUE;
      }
    }
    return sign*(int)res;
  }

}
