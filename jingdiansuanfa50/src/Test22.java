public class Test22 {

  public static int   fun(int n){
    if(n == 1){
      return n;
    }else{
      return n*fun(n-1);
    }

  }

}
