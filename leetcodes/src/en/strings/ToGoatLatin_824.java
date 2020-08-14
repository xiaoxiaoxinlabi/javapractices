package en.strings;

import java.util.*;
import java.util.stream.Collectors;

public class ToGoatLatin_824 {

//    将给定的(给出句子S，由空格分隔的单词组成。每个单词仅包含小写和大写字母))按照如下规则替换
//    1、如果一个单词以元音开头（a,i,e,o,u）则在单词结尾拼接 “ma”
//    2、如果一个单词开头以辅音开头,则删除第一个字符，并将其拼接在单词后面，然后在添加“ma”
//    3、在句子中按单词索引在每个单词的末尾添加一个字母'a'，从1开始

    public String toGoatLatin1(String s){
       String [] arr = s.split(" ");
       StringBuilder res = new StringBuilder();
       for(int i = 0; i < arr.length; i ++){
           StringBuilder obj = new StringBuilder(arr[i]);

           if(obj.charAt(i) =='a'|| obj.charAt(i) == 'i' || obj.charAt(i) == 'e'|| obj.charAt(i) =='o' || obj.charAt(i) == 'u'||
           obj.charAt(i) == 'A' || obj.charAt(i) == 'I' || obj.charAt(i) == 'E' || obj.charAt(i) == 'O' || obj.charAt(i) == 'U'){
               obj.append("ma");
           }else{
               obj.append(obj.charAt(0));
               obj.append("ma");
               obj.deleteCharAt(0);
           }
           for(int j = 0; j <= i; j ++){
               obj.append("a");
           }
           res.append(obj + " ");
       }
       res.deleteCharAt(res.length()-1);
       return res.toString();
    }

    public String toGoatLatin2(String s){
        List<String> res = new ArrayList();
        int countOfA = 1;
        String suffix = "ma";
//        将元音字母添加到set中
        Set<Character> vowels = new HashSet();
        vowels.addAll(Arrays.asList('a','i','e','o','u'));
        for(String ss: s.split(" ")){
            StringBuilder sb = new StringBuilder();
            char ch = ss.charAt(0);

//            循环遍历字符串，如果有字符出现在元音列表中
            if(vowels.contains(Character.toLowerCase(ch))){
//                则将该字符添加到sb中，并且后面添加后缀
                sb.append(ss).append(suffix);
            }else{
//                如果不包含，
                sb.append(ss.substring(1)).append(ch).append(suffix);
            }

            for(int i = 0; i < countOfA; i ++){
                sb.append('a');
            }
            res.add(sb.toString());
            countOfA++;
        }
        return res.stream().collect(Collectors.joining(" "));

    }
}
