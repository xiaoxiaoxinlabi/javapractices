public class Test20 {

//  表示数值的字符串

//  请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//  例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是


  public boolean isNumber(String s){

    if(s == null || s.length() == 0){
      return false;
    }
//    标记是否遇到相应情况
    boolean numSeen = false;//是否是数据
    boolean dotSeen = false;//是否是标点符号
    boolean eSeen = false;//是否是e

//    将字符串去掉前后空格，并转换成数组
    char [] str = s.trim().toCharArray();
    for(int i = 0; i < str.length; i++){

//      如果在0 ~ 9 之间 则是数字
      if(str[i] >= '0' && str[i] <= '9'){

//        判断为数字，则numseen = true
        numSeen = true;

//        如果遇到的是 . 号
      }else if(str[i] == '.'){

//        则说明是 点号
        if(dotSeen || eSeen){
          return false;
        }
        dotSeen = true;

//        如果遇到的是 e , E
      }else if(str[i] == 'e' || str[i] == 'E'){
        if(eSeen || !numSeen){
          return false;
        }
        eSeen = true;
        numSeen = false;
      }else if(str[i] == '-' || str[i] == '+'){
        if(i !=0 && str[i-1] !='e' && str[i-1] !='E'){
          return false;
        }
      }else {
        return false;
      }
    }

    return numSeen;

  }

}

