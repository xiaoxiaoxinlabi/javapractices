public class Test16 {

//  题目：输出9*9口诀。

  public static void main(String [] args){
    int res = 0;
    for(int i = 1; i < 10; i ++){
      for(int j = 1; j <=i; j ++){

        System.out.print(i +"x"+j + "=" + i *j + "   ");
//        System.out.print("  ");

      }
      System.out.println("  ");
    }
  }

}
