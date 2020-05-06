public class XiaomiTest01 {

//  打印1-1000的水仙花数

//定义标记，水仙花数起始值位0
  //要找出1000以内的水仙花数，先要遍历其每个数字；因为水仙花数是三位数所以从100开始

  public static void getflowerNums(){
    int count = 0;
    for(int i = 100; i < 1000; i ++){
      int g = i % 10;
      int s = i /10%10;
      int b = i / 100;

      if(g*g*g + s*s*s + b*b*b == i){
        count++;
        System.out.println(i);
      }
    }

System.out.println(count);
  }


  public static void getflowerNums1(){

    for(int i = 1; i < 1000; i ++){

      if(i < 10){
        if(Math.pow(i,3) == i){
          System.out.println(i);
        }
      }else if( i >=10 && i < 100){

        int s = i / 10, g = i % 10;
        if(Math.pow(s,3) + Math.pow(g,3) == i){
          System.out.println(i);
        }

      }else if( i >=100 && i < 1000){
        int b = i / 100, s = i / 10%10 , g = i %10;
        if(Math.pow(b,3)+Math.pow(s,3)+Math.pow(g,3) == i){
          System.out.println(i);
        }
      }
    }


  }

  public static void main(String [] args){
//    getflowerNums();


    getflowerNums1();
  }




}
