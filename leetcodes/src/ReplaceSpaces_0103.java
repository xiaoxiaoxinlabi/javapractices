public class ReplaceSpaces_0103 {
//  URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

//  示例1:
//
//  输入："Mr John Smith    ", 13
//  输出："Mr%20John%20Smith"



  public String replaceSpaces1(String s, int length){

    StringBuilder res = new StringBuilder();
    for(int i = 0; i < length; i ++){
      if(s.charAt(i) == ' '){
        res.append("%20");
      }else{
        res.append(s.charAt(i));
      }
    }
    return res.toString();


  }

//  方法一：char数组替换（时间空间最少）
  public String replaceSpaces2(String s, int length){

    char [] c = s.toCharArray();
    int i = 0, j = 0;
    char temp;
    while(i < length){
      temp = s.charAt(i);
      if(temp == ' '){
        c[j++] ='%';
        c[j++] = '2';
        c[j++] = '0';
      }else{
        c[j++] = temp;
      }
      i++;
    }
    return new String(c, 0, j);
  }

  public String replaceSpaces3(String s, int length){
    char [] ss = s.toCharArray();
    int j = s.length() - 1;
    for(int i = length - 1;i >=0; i--){
      if(ss[i] == ' '){
        ss[j--]='0';
        ss[j--]='2';
        ss[j--] = '%';

      }else{
        ss[j--]=ss[i];
      }
    }
    return String.valueOf(ss, j+1, s.length()-j-1);
  }




}
