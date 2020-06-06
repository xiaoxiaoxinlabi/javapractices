//比较两个版本号 version1 和 version2。 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

public class CompareVersion_165 {

  public static int compareVersion(String version1, String version2){
//    注意此处为正则匹配，不能用
    String [] str1 = version1.split("\\.");
    String [] str2 = version2.split("\\.");

    // 取数组最小长度值
    int minlen= Math.min(str1.length, str2.length);
    int idx = 0;
    int diff = 0;


    while(idx < minlen
        // 先比较长度
        && (diff = str1[idx].length() - str2[idx].length()) ==0
        // 再比较字符
        &&  (diff = str1[idx].compareTo(str2[idx]))==0){
      ++idx;

    }
    // 如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大

    diff = (diff !=0)? diff: str1.length - str2.length;
    return diff;

  }


  public static void compareversion1(String version1, String version2){

    String [] str1 = version1.split("\\.");
    String [] str2 = version2.split("\\.");

    // 取数组最小长度值
    int minlen= Math.min(str1.length, str2.length);
    int idx = 0;
    int diff = 0;

    for(int i = 0; i <minlen; i ++){
//      比较长度
      diff = str1[i].length() - str2[i].length();

//      如果长度相等
      if(diff ==0){
//        比较字符
        if(str1[i].compareTo(str2[i]) > 0){
          System.out.println("1");
          break;
        }else{
          if(str1[i].compareTo(str2[i]) <0){
            System.out.println("-1");
            break;
          }else if (i == minlen - 1){
            System.out.println(minlen == str1.length ? -1 : 1);
          }
        }
      }else if(diff !=0){
        System.out.println(diff);
        break;

      }
    }

  }


}
