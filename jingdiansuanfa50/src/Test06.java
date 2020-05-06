public class Test06 {
//  题目：输入两个正整数m和n，求其最大公约数和最小公倍数。


  public static  void fun1(int a, int b){

    int min = Math.min(a,b);
    int gy = 0 , gb;

    for(int i = min; i > 0; i --){
      if(a %i == 0 && b %i ==0){
        gy=i;
        break;
      }
    }

    gb = a*b / gy;

  }

}
