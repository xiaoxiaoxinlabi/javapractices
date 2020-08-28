package en.sorts;

import java.util.Arrays;

public class SortString_1370 {

//    给定一个字符串s。您应该使用以下算法对字符串重新排序：
//    1.从s中选择最小的字符，并将其附加到结果中。
//    2.从s中选择一个大于最后一个追加字符的最小字符，并将其追加。
//    3.重复步骤2，直到您无法选择更多字符。
//    4.从s中选择最大的字符，并将其附加到结果中。
//    5.从s中选择比最后添加的字符小的最大字符，然后将其添加。
//    6.重复步骤5，直到您不能选择更多的字符。
//    重复步骤1到6，直到从中选择所有字符。

//    在每个步骤中，如果最小字符或最大字符出现多次，则可以选择任何出现的字符并将其附加到结果中。
//    使用此算法对s排序后返回结果字符串。

    public String sortString(String s) {

//        char [] res = new char[s.length()];
        StringBuilder res = new StringBuilder();

        int [] count = new int[26];
        int cindex = 0;
//        统计字符串中每个字符出现的次数，并完成了按照字典排序
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
//            字符转数字
            count[c - 'a']++;
        }

//        定义一个变量为索引index
        while(cindex < s.length()){
//            从0开始遍历数组count,如果count中的元素不为0 ，这说明是最小的字母，将其添加到res中，并把出现的次数减一
            for(int i = 0; i < count.length; i ++){
                if(count[i] != 0){
//                    res[cindex++] = (char)(i+'a');
                    res.append((char)(i+'a'));
                    count[i]--;
                    cindex++;
                }
            }

//            降序遍历数组count,如果count中的元素不为0 ，这说明是最大的字符，将其添加到res中，并把出现的次数减一
            for(int i = count.length - 1; i >= 0; i--){
                if(count[i] != 0){
//                    （i + 'a） 数字转字符
//                    res[cindex++] = (char)(i+'a');
//                    count[i]--;

                    res.append((char)(i+'a'));
                    count[i]--;
                    cindex++;
                }
            }
        }

        return res.toString();



    }

    public String sortString1(String s){
        int [] map = new int[26];
        StringBuilder res = new StringBuilder();
        int count = s.length();
        boolean direction = true;

//        统计字符串中每个字符出现的次数
        for(char c : s.toCharArray()){
            map[c-'a']++;
        }

        while(count > 0){
//            循环遍历计算当前数字的ascii值
            for(int i = 0; i < map.length; i++){
                int asciiCd = direction ? i+'a' : 'z' - i;
//                计算其在map中所对应的位置
                Character key = (char)(asciiCd - 'a');

//                如果val 大于 0 ，并且 count 大于0 ；
                if(map[key] > 0 && count > 0){
//                    将当前val 减1，并将其 改ascii 添加到转换成字符，添加到 res中
                    map[key] = map[key] - 1;
                    res.append((char) asciiCd);
                    count--;
                }
            }
            direction = !direction;
        }
        return res.toString();
    }

    public String sortString3(String s){
        StringBuilder res = new StringBuilder();
        int letterCount = s.length();
        int letterFrequency [] = new int[26];
        Arrays.fill(letterFrequency,0);
        for(int i = 0; i < s.length(); i ++){
            letterFrequency[s.charAt(i) - 'a']++;
        }

        while (letterCount > 0){
            for(int i = 0; i < letterFrequency.length; i ++){
                if(letterFrequency[i] != 0){
                    res.append((char)(i+97));
                    letterFrequency[i]--;
                    letterCount--;
                }
            }

            for(int i = letterFrequency.length-1; i >= 0; i --){
                if(letterFrequency[i] != 0){
                    res.append((char)(i+97));
                    letterFrequency[i]--;
                    letterCount--;
                }
            }
        }
        return res.toString();
    }

}
