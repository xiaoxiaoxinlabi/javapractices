public class Test27 {

//  题目：求100之内的素数

  public static void  fun(int n){

    boolean flag = true;
    for(int i = 3; i < 100; i ++){
      for(int j = 2; j <= Math.sqrt(i); j ++){
        if(i % j == 0){
          flag = false;
          break;
        }else{
          flag = true;
        }
      }if(flag == true){
        System.out.println(i);
      }
    }

  }
}
