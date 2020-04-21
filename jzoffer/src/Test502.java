public class Test502 {

//  写一个方法，把字符串转为数字，比如 str="1234"，变成 int 1234。并且测试这个程序
//将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。

//  ASCII码从0到127，即（2的0次方减1）到（2的7次方减1）.
//      - 字符’0’对应的ASCII码值是48（转化为int类型）；
//      - 字符’9’对应的ASCII码值是57 (48+10-1=57)；
//      - 字符‘A’对应的ASCII码值是65；
//      - 字符‘Z’对应的ASCII码值是90（65+26-1=90）；
//      - 字符‘a’对应的ASCII码值是97；
//      - 字符‘z’对应的ASCII码值是122（97+26-1=122）；
//      - 字符‘NULL(null)’对应的ASCII码值是0，‘NULL(null)’解释为空字符；
//      - 字符‘ (space)’对应的ASCII码值是40，‘ (space)’解释为空格；


//  重点考察边界条件：
//
//  数据上下溢出
//      空字符串
//  只有正负号
//      有无正负号
//  错误字符串的输出

//  复杂度分析：
//  时间复杂度：O(n)。
//  空间复杂度：O(n)。

//  思路：
//  将字符串转换成整数首先就应该确定字符串是整数字符串，第一位可以是符号位，可以是除0~9之外的’+’,’-'字符


  public static int strToInt(String str){

//    判断是否为空
    if(str.equals("") || str.length() == 0){
      return 0;
    }

    char [] a = str.toCharArray();
    //数字的第一位可以是+/-/或者是数字，先判断字符串第一位字符
//    negative 用来判断正负
    int negative = 0;
    if(a[0] == '-'){
      negative = 1;
    }
    long sum = 0;

    for(int i = negative; i < a.length; i ++){
      if(a[i] == '+'){
        continue;
      }
//      非数字（0~9）
      if(a[i] < 48 || a[i] > 57){
        return 0;
      }
//      把a[i]转换成0-9的数字
      //  对于整数字符从高位向低位遍历时，将获得的高位数字*10再加上当前字符包含的数字所得到的结果就是当前的位得到的整数。
      sum = sum *10 + a[i] - 48;

      if((negative == 0 && sum > Integer.MAX_VALUE) || negative == 1 && (sum * negative < Integer.MIN_VALUE)){
        return 0;
      }
    }
    return negative == 0? (int)sum: (int)sum*-1;

  }


  public static void main(String [] args){

    System.out.println(strToInt("skjdkasjk"));




  }

}
