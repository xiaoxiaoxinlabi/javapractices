public class CheckRecord_551 {

//  给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
//
//      'A' : Absent，缺勤
//      'L' : Late，迟到
//      'P' : Present，到场

//  如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
//  你需要根据这个学生的出勤记录判断他是否会被奖赏。
//  示例 1:
//
//  输入: "PPALLP"
//  输出: True
//  示例 2:
//
//  输入: "PPALLL"
//  输出: False

  public static boolean checkRecord1(String s){

    int numA = 0;
    for(int i = 0; i < s.length(); i ++){
      if(s.charAt(i) == 'A'){
        numA++;
      }else if(i <= s.length() - 3 && s.charAt(i) == 'L' && s.substring(i,i+3).equals("LLL")){
        System.out.println(s.substring(i,i+3));
        return false;
      }
    }
    if(numA > 1 ){
      return false;
    }
    return true;

  }

  public static boolean checkRecord2(String s){
    int numA = 0;
    for(int i = 0; i < s.length(); i ++){
      if(s.charAt(i) == 'A'){
        numA++;
      }
    }
    if(numA > 1 ||  s.indexOf("LLL") != -1){
      return  false;
    }
    return true;

  }

  public static void main(String [] args){

    String s = "PPALLL";
    System.out.println(checkRecord1(s));

  }



}
