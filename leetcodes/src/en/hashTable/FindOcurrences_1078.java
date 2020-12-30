package en.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOcurrences_1078 {

//    给定单词“ first”和“ second”，请考虑某些文本中出现的“第一第二第三”形式，其中第二紧跟在第一之后，第三紧随第二。
//    对于每次发生的此类情况，在答案中添加“第三”，然后返回答案。
//    将text 中，按照frist,sencond,third 顺序排列的third找出来

//    Example 1:
//    Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
//    Output: ["girl","student"]
//    Example 2:
//
//    Input: text = "we will we will rock you", first = "we", second = "will"
//    Output: ["we","rock"]

    public String[] findOcurrences(String text, String first, String second) {

        String [] arr = text.split(" ");
        List<String> list = new ArrayList();
        for(int i = 1; i < arr.length-1; i ++){
            //        object 比较用equals， 基本类型比较用 ==
            if(arr[i-1].equals(first) && arr[i].equals(second) ){
                list.add(arr[i+1]);
            }
        }
        return list.toArray(new String[list.size()]);

    }

    public String[] findOcurrences1(String text, String first, String second){
        String [] words = text.split(" ");
        String [] res = new String[text.length()];
        int index = 0;

        for(int i = 0; i < words.length-2; i ++){
            if(words[i].equals(first) && words[i+1].equals(second)){
                res[index++] = words[i+2];
            }
        }
        return Arrays.copyOf(res, index);
    }

    public String[] findOcurrences2(String text, String first, String second){
        List<String> list = new ArrayList();
        String tmp1 ="",tmp2 = "";
        for(String word: text.split(" ")){
            if(tmp1.equals(second) && tmp2.equals(first)){
                list.add(word);
            }
            tmp2 = tmp1;
            tmp1 = word;
        }
        return list.toArray(new String[0]);
    }
}
