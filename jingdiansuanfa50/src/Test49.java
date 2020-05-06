public class Test49 {

//  【程序49】 题目：计算字符串中子串出现的次数


  public static void main(String [] args){
    String str = "I come from County DingYuan Province AnHui.";
    char [] ch = str.toCharArray();
    int count = 0;
    for(int i = 0; i < ch.length; i ++){
      if(ch[i] == ' '){
        count++;
      }
      count++;
    }

  }

}
