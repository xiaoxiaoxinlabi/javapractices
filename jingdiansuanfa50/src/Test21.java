public class Test21 {

//  题目：求1+2!+3!+...+20!的和

  public static void main(String [] args){
    long sum = 0, ver = 1;

    for(int i = 0; i <=20; i ++){

      ver = ver * i;
      sum+=ver;
    }
    System.out.println(sum);
  }


}
