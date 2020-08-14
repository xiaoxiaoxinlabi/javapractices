package en.strings;

public class ReverseWords_557 {

//    给定一个字符串，您需要反转句子中每个单词的字符顺序，同时仍保留空白和初始单词顺序。

    public String reverseWords1(String s){
        String [] ss = s.split(" ");
        StringBuilder res = new StringBuilder();

        for(int i = 0;  i < ss.length; i ++){

            res.append(new StringBuilder(ss[i]).reverse()).append(" ");
        }
        return res.toString().trim();
    }
}
