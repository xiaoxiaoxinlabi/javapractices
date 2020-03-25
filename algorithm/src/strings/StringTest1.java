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

//  最长回文子字符串


//  dp[i][j]表示索引i到j的子串是否是回文
//  dp[i][j] = true表示是回文，反之则为false
//
//  dp[i][i]只有一个字符，必是回文
//  关键点在于找到关系：dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
//  长的子串dp[i][j]依赖于短的子串dp[i + 1][j - 1]，所以由短到长依次计算
//1、先计算一个字符，全为true
//2、再计算两个字符，如果两个字符一样则为true
//3、然后计算大于三个字符，直到整个字符串
  public static String longestPalindrome(String s){

    if(s.equals(" ")){
      return s;
    }

    int len = s.length(), left = 0, right = 0;

    boolean [][] db = new boolean[len][len];
    String res = s.substring(0,1);

//    单个字符肯定是回文db[i][i]只有一个字符，必是回文
    for(int i = 0; i < len; i++){
      db[i][i] = true;
    }

//    两个字符串如果字符相同为true（注意数组不要越界）
    for(int i = 0; i < len - 1; i++){
      db[i][i+1] = s.charAt(i)==s.charAt(i+1);
      if(db[i][i+1]){
        res = s.substring(i, i+1+1);
      }
    }

//    依次循环三个字符、四个字符......
//    有起点索引 i，有子串长度 k 则可以得到终点索引 j
    for(int k = 3; k <=len; k++){
      for(int i = 0; (i+k)<=len; i++){
        int j = i+k-1;

        db[i][j] = db[i+1][j-1] && s.charAt(i)==s.charAt(j);

        if(db[i][j] && (j-i+1) > res.length()){
          res = s.substring(i, j+1);
        }
      }
    }
    return res;
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
