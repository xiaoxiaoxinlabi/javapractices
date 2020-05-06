public class ZhishuTest {

//  第一种：双重for循环 使除数与被除数个个计算，效率极低
  public void test1(int n){

    int num = 0;
    boolean sign;
    for(int i = 2; i <= n; i ++){

        sign = true;
        for(int j = 2; j < i; j ++){
          if(i % j == 0){
            sign = false;
            break;
          }
        }
        if(sign){
          System.out.println(i);
          num++;
        }
      }

  }


//  第二种：主要考虑2 ~ i/2之间的数 ，效率比第一种提高一半
  public void test2(int n){
    int num = 0, j;
    boolean sign;
    for(int i = 2; i <=n; i ++){

      sign = true;
      for(j = 2; j <= i/2; j++){
        if(i % j == 0){
          sign = false;
          break;
        }
      }if(sign){
        System.out.println(i);
        num++;
      }
    }
  }


//  第三种：使用开方去过滤 Math.sqrt(i)

  public void test3(int n){
    int num = 0, j;
    boolean sign;
    for(int i = 2; i <=n; i ++){
      sign = true;
      for(j = 2; j <= Math.sqrt(i); i ++){
        if(i % j == 0){
          sign = false;
          break;
        }
      }
      if(sign){
        num++;
      }
    }
  }

  public static void main(String [] args){


  }


}
