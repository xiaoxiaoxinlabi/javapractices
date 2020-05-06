import java.util.regex.Matcher;

public class Test03 {
//  题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花数

  public static  void main(String [] args){

    int g, s,b;
    for(int i =100; i < 1000; i ++){

//      百位
      b = i / 100;
//      十位
      s = i / 10 % 10;
//      个位
      g = i % 10;

      if(Math.pow(b,3) + Math.pow(s,3) + Math.pow(g,3) == i){
          System.out.println(i);
      }

    }
  }
}
