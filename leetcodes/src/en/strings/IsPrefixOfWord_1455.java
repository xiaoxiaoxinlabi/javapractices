package en.strings;

public class IsPrefixOfWord_1455 {
//    给定一个句子，该句子由一些用单个空格分隔的单词和一个searchWord组成。
//    您必须检查searchWord是否是句子中任何单词的前缀。
//    返回句子中单词的索引，其中searchWord是该单词的前缀（1索引）。
//    如果searchWord是一个以上单词的前缀，则返回第一个单词的索引（最小索引）。如果没有这样的单词，则返回-1
//    Example 1:
//
//    Input: sentence = "i love eating burger", searchWord = "burg"
//    Output: 4
//    Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.

    public int isPrefixOfWord(String sentence, String searchWord) {

        String [] arr = sentence.split(" ");

        for(int i = 0; i < arr.length; i ++){

            if(arr[i].indexOf(searchWord) == 0){
                return  i + 1;
            }
        }
      return -1;

    }

    public int isPrefixOfWord1(String sentence, String searchWord){
        String [] words = sentence.split(" ");
        for(int i = 0; i < words.length; i ++){
            if(words[i].length() >= searchWord.length()){
                if(words[i].substring(0,searchWord.length()).equals(searchWord)){
                    return i + 1;
                }
            }
        }
        return -1;
    }
}


