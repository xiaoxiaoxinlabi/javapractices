public class Test32 {

//  题目：取一个整数a从右端开始的4～7位。

  public static void  fun(int n){

    String str = String.valueOf(n);

    if(str.length() < 7){
      return;
    }else{
     System.out.println(str.substring(str.length()-7,str.length()-3));
    }

  }
}
