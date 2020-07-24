public class RepeatedStringMatch_686 {

//  给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
//
//  举个例子，A = "abcd"，B = "cdabcdab"。
//
//  答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。

  public int repeatedStringMatch1(String A, String B){

    if(A.indexOf(B) !=-1){
      return 1;
    }
    int c = B.length()/A.length()+2;
    String s = new String(A);
    for(int i = 1; i < c;i++){
      s+=A;
      if(s.indexOf(B)!=-1){
        return i+1;
      }
    }
    return -1;

  }

  public int repeatedStringMatch2(String A, String B){
    int i = 1;
    StringBuilder s = new StringBuilder(A);
    int blength = B.length();
    while(s.length() < blength){
      s.append(A);
      i++;
    }
//    return s.indexOf(B)==-1?((s.append(A).indexOf(B) == -1)?-1:i+1):i;
    if(s.indexOf(B) == -1){
      if(s.append(A).indexOf(B) == -1){
        return -1;
      }else{
        return i+1;
      }
    }else{
      return i;
    }

  }

//  使用lastIndexOf 和 indexOf 来进行 字符串匹配 测试数据的问题 lastIndexOf会快很多 (可尝试KMP)
  public int repeatedStringMatch3(String A, String B){
    int i = 1;
    StringBuilder s = new StringBuilder(A);
    int blen = B.length();
    while(s.length() < blen){
      s.append(A);
      i++;
    }

//    return s.lastIndexOf(B) == -1 ?((s.append(A).lastIndexOf(B)==-1?-1:i+1)):i;
//    如果不包含B
    if(s.lastIndexOf(B) == -1){
//      如果在增加之后还不包含B，则返回-1
      if(s.append(A).lastIndexOf(B) == -1){
        return -1;
      }else{
//        在增加之后，如果包含，则返回i+1
        return i+1;
      }
    }else{
//      如果包含，则返回i
      return i;
    }

  }

}
