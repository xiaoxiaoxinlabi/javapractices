package chars;

public class CharTest {

//  char 获取ascii

  public static void main(String [] args){


//   char 运算

//    加法运算

//    数字相加
    char c1 = '1',  c2 = '2';

//    结果为，其字母对应的ascii 相加  字符 ‘1’ 的 对应的ascii  为：49 ； 字符‘2’ 对应的ascii 为 ： 50
    System.out.println("字符 c1 的 ascii 值为："+Character.hashCode(c1));
    System.out.println("字符 c2 的 ascii 值为："+Character.hashCode(c2));
//    此处为，将字符直接拼接为字符串 因此： 会打印： c1 + c2 = 12
    System.out.println("c1 + c2 = "+c1 + c2);
//    计算两个字符对应的ascii的值，因此打印：99
    System.out.println(c1 + c2);
//    计算字符转为数字之后的和，因此打印为：3
    System.out.println(c1-'0' + c2-'0');


//    相减计算两个字符转换为数字之后的差
    System.out.println(c1 - '0' -( c2 - '0'));

  }

}
