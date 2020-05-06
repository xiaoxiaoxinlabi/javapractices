public class Test46a {

  public static int getTranslation(int number){

    if(number < 0){
      return  0;
    }
    if(number == 1){
      return 1;
    }
    //动态规划，从右到左计算。
    //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    //如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
    String str = Integer.toString(number);

    int f1 = 0, f2 = 1, g = 0;
    int temp = 0;
    for(int i = str.length()-2; i >=0; i--){
      if(Integer.parseInt(str.charAt(i)+ ""+str.charAt(i+1))< 26){
        g = 1;
      }else{
        g = 0;
      }

      temp = f2;
      f2 = f2 + g*f1;
      f1 = temp;
    }
    return f2;
  }

  public static void main(String [] args){
    System.out.println(getTranslation(-10));
    System.out.println(getTranslation(1234));
    System.out.println(getTranslation(123456));
    System.out.println(getTranslation(12558));
  }

}
