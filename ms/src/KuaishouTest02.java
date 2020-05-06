public class KuaishouTest02 {

//  比较两个版本号的大小

  public static String getMaxVersion(String s1, String s2){

    String [] s1Array = s1.split("/.");
    String [] s2Array = s2.split("/.");


    int minLen = Math.min(s1Array.length, s2Array.length);

    for(int i = 0; i < minLen; i ++){

      int tmplen = s1Array[i].length() - s2Array[i].length();
      if(tmplen == 0){

        if(s1Array[i].compareTo(s2Array[i]) > 0){
          return s1;
        }else {
          return s2;
        }

      }else if (tmplen > 0){
        return s1;
      }else{
        return s2;
      }
    }
    return null;

  }


  public static int compareVersion(String s1, String s2){
    String [] str1 = s1.split("\\.");
    String [] str2 = s2.split("\\.");

    int minlen = Math.min(str1.length, str2.length);

    for(int i = 0; i < minlen; i ++){
      int temp = str1[i].length() - str2[i].length() ;
      if(temp == 0){
        if(str1[i].compareTo(str2[i]) == 0){
          continue;
        }

      }else if (temp > 0){
        return 1;
      }else{
        return -1;
      }
    }

    return 0;

  }

  public static int compareVersion1(String str1, String str2){
    String [] s1 = str1.split("\\.");
    String [] s2 = str2.split("\\.");

    int minlen = Math.min(s1.length, s2.length);
    int index = 0;
    int diff = 0;
    while(index < minlen && (diff = s1[index].length() - s2[index].length() )==0  && s1[index].compareTo(s2[index]) == 0){
      ++index;

    }
    diff =(diff !=0)? diff: s1.length - s2.length;
    return diff;

  }



  public static void main(String [] args){

    System.out.println(getMaxVersion("6.3.1", "6.3.1.2"));

  }

}
