package practise.pra1;

public class StaticApis {

//  计算整数的绝对值

  public static int absInt(int x){
    if (x < 0) {
      return -x;
    }else {
      return x;
    }
  }


//  计算浮点数的绝对值

  public static double absDouble(double a){
    if (a < 0.0){
      return -a;
    }else{
      return a;
    }
  }


//  判断一个数是否是素数(数学上指在大于1的整数中只能被1和它本身整除的数)

  public static boolean isPrimeInt(int a){

    if (a < 2){
      return false;
    }
    for (int i = 2; i * i <= a; i++){
      if (a % i == 0){
        return false;
      }
    }
    return true;

  }

//  计算平方根(牛顿迭代法)?? 了解什么是牛顿迭代法

  public static double sqrtDouble(double c){
    if (c < 0){
      return Double.NaN;
    }
//    1乘以10的负15次方；科学计数法
    double err = 1e-15;
    double t = c;

    while(Math.abs(t - c/t) > err * t){
      t = (c/t + t) / 2.0;

    }
    return t;

  }


//  计算直角三角形的斜边
  public static double hypotenuseDouble(double a, double b){
    return Math.sqrt(a*a + b*b);
  }



//  计算调和级数(如果An是全部不为0的等差数列，则1/An就称为调和数列，求和所得即为调和级数:)
//  计算公式：1 +1/2+1/3 +1/4 + 1/5+ 1/6+1/7+1/8 +...1/n
  public static double hInt(int n){
    double sum = 0.0;
    for (int i =1; i <= n; i ++){
      sum+= 1.0 / i;
    }
    return sum;
  }







public static void main(String [] args){



  System.out.println(absInt(11));
  System.out.println(absDouble(-9.8));
  System.out.println(isPrimeInt(9));
  System.out.println(sqrtDouble(9));
  System.out.println(hypotenuseDouble(2, 4));
  System.out.println(hInt(2));
}

}