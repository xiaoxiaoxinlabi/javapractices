public class IsFlipedString_0109 {

  public boolean isFlipedString(String s1, String s2) {

    if(s1.length() != s2.length()){
      return false;
    }

    s1+=s1;

    int i = 0;
    int j = 0;

    while(i !=s1.length() && j != s2.length()){
      if(s1.charAt(i) == s2.charAt(j)){
        i++;
        j++;

      }else{
        j=0;
        i++;

      }
    }
    return j == s2.length();




  }

//  这道题使用的是一个巧劲：
//  比如一个单词：water
//  那么： waterwater 是不是包含了所有的旋转方案？了解了这一点 就非常简单了

  public boolean isFlipedString1(String s1, String s2){
    int len = s1.length();
    if(s1 == null && s2 == null || len !=s2.length()){
      return false;
    }
    String s = s1+s1;
    return s.contains(s2);
  }

}
