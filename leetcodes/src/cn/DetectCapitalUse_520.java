public class DetectCapitalUse_520 {

//  给定一个单词，你需要判断单词的大写使用是否正确。
//
//  我们定义，在以下情况时，单词的大写用法是正确的：
//
//  全部字母都是大写，比如"USA"。
//  单词中所有字母都不是大写，比如"leetcode"。
//  如果单词不只含有一个字母，只有首字母大写， 比如 "Google



  public boolean detectCapitalUse(String word) {

    int upper = 0;
    int lower = 0;

    for(int  i = 0; i < word.length(); i++){

      if(word.charAt(i) - 'a' < 0){
        upper++;
      }else{
        lower++;
      }

    }

    if(upper == word.length() || lower == word.length() || (upper == 1 && word.charAt(0) < 'a')){
      return true;
    }
    return false;

  }

}
