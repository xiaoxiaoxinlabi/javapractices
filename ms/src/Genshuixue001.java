public class Genshuixue001 {


  //    输入：字符串
//    返回： 回文true，  非回文false
//    如 "abcba" "abccba" 都属于回文


  public static boolean isPalindrome1(String s){

    int count = 0;

    for(int i = 0; i < s.length() / 2; i ++){

      if(s.charAt(i) == s.charAt(s.length() - i - 1)){

        count++;
      }

    }

    if(count == s.length() / 2){

      return true;
    }

    return false;

  }


  public static boolean isPalindrome2(String s){

    for(int i = 0; i < s.length() / 2; i ++){
      if(s.charAt(i) != s.charAt(s.length() - i - 1)){
        return false;
      }
    }
    return true;
  }


  public static boolean isPalindrome3(String s){

    char [] ch = s.toCharArray();
    int left = 0, right = ch.length - 1;

    while(left <= right){
      while(left <= right && !Character.isLetterOrDigit(ch[left])){
        left++;
      }

      while(left <= right && !Character.isLetterOrDigit(ch[right])){
        right--;
      }

      if(left <= right){
        if (Character.toLowerCase(ch[left]) != Character.toLowerCase(ch[right])) {

          return false;

        }

        left++;
        right--;
        }
      }
    return true;
  }


  public static void main(String [] args){

    String s = "a";
    System.out.println(isPalindrome1(s));


  }

}
