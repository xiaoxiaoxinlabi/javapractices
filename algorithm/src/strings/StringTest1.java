package strings;

public class StringTest1 {

//  判断字符串是否是一条回文

  public static boolean isPalindromeTest(String s){

    int N = s.length();

    for (int i = 0; i < N / 2; i ++){

      if (s.charAt(i)  != s.charAt(N - 1 - i)){
        return false;
      }
    }
    return true;
  }


//  获取文件的名称以及后缀
  public static String getBaseAndExt(String s){

    int splits = s.indexOf(".");

    String base = s.substring(0,splits);
    String ext = s.substring(splits + 1, s.length());

    return "base:" + base + " and ext:" + ext;

  }

//  检查字符串数组中的元素是否已按照字母表排序
  public static boolean isSort(String [] s){

    int N = s.length;

    for (int i = 1; i < N; i ++){
      if (s[i - 1].compareTo(s[i]) > 0){

        return false;
      }
    }
    return true;
  }



  public static void main(String [] args){


    String s = "abcbad";
    String fileName = "StringTest1.java";

    String [] sArray = {"a","b","c","a"};

    System.out.println(isPalindromeTest(s));
    System.out.println(getBaseAndExt(fileName));
    System.out.println(isSort(sArray));


  }
}
