public class Dd01 {

//  将输入的字符串转换成数字



  public static void fun(String str){

    int res;
    if(str.equals(" ") || str.length() == 0){
      return;
    }

    char [] c = str.toCharArray();
    long sum = 0;

    int fh = 0;
    if(c[0] == '-'){
      fh = 1;
    }

    for(int i = fh; i < c.length; i ++){

      if(c[i] == '+'){
        return;
      }

      if(c[i] <48  || c[i] > 57){
        continue;
      }
        sum = sum * 10  + c[i]- 48;

      if((fh == 0 && sum > Integer.MAX_VALUE) || (fh ==1 &&  sum * fh < Integer.MIN_VALUE) ){
        return;
      }
    }



    res = fh == 0? (int)sum:(int) sum*-1;
    System.out.println(res);

  }


  public static void main(String [] args){

    fun("-12ab3c4");


  }
}
