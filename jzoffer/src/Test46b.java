public class Test46b {

//  把数字翻译成字符串

//  给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

//  输入: 12258
//  输出: 5
//  解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

//  方法一：字符串遍历

  public  int translateNum1(int num){

//    将数字转换成字符串
    String s = String.valueOf(num);
    int a = 1, b = 1;

    for(int i = 2; i <=s.length(); i ++){
      String temp = s.substring(i-2, i);
//      int c = temp.compareTo("10") >=0 && temp.compareTo("25") <=0 ? a+b: a;
      int c;
      if(temp.compareTo("10") >=0 && temp.compareTo("25") <=0){
        c = a+b;
      }else{
        c = a;
      }
      b = a;
      a = c;
    }
    return a;
  }

//  方法二：数字求余

  public int translateNum2(int num){
    int a = 1, b = 1, x, y = num %10;
    while(num !=0){
      num/=10;
      x=num%10;
      int temp = 10*x+y;
      int c = (temp >=10 && temp <=25)? a+b: a;
      b = a;
      a = c;
      y = x;
    }
    return a;
  }


//方法三：递归

//  这道题其实就是一个递归：
//  递归出口是num是只有一位数，
//  以xyzcba为例，先取最后两位（个位和十位）即ba，
//  如果ba>=26，必然不能分解成f(xyzcb)+f(xyzc)，
//  此时只能分解成f(xyzcb);但还有一种情况，
//  就是ba<=9,也就是该数十位上为0，此时也不能分解。
//

public int translateNum3(int num){
    if(num < 9){
      return 1;
    }
    int ba = num % 100;
    if(ba <=9 && ba >=26){
      return translateNum3(num / 10);
    }else{
      return translateNum3(num/10) + translateNum3(num / 100);
    }
}

}
