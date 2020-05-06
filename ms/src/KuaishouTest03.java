public class KuaishouTest03 {

//  给出一个数，求所有因子数的和的最大值的因子数

  public static void fun1(int n ){

    int sum = 0;
    int max = 0;
    for(int i = 1; i <=n; i ++){
      if(n % i == 0){

        sum = i + n/i;
        System.out.println(n+" = "+ i +"*"+ n/i);
        max = Math.max(sum, max);

      }

    }

    System.out.println(sum + "==="+max);

  }


  public static void fun2(int n){

    int k = 2;
    System.out.print(n + "=");
    while(k <=n){
      if(k == n){
        System.out.print(n);
        break;
      }else if(n % k == 0){
        System.out.print(k + "*");
        n = n / k;

      }else{
        k ++;
      }
    }
  }





  public static void main(String [] args){
    fun1(12);
//    fun2(12);

  }



}
