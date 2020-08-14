package en.strings;

import java.util.*;

public class MostCommonWord_819 {

//找出 paragraph 中出现次数最多的单词，并且不再banned中

    public String mostCommonWord1(String paragraph, String [] banned){

        Map<String, Integer> map = new HashMap();
        Set<String> bs = new HashSet();
        int max = 0;
        String res = "";

//        将字符数组 banned 装入set中
        for(String b: banned){
            bs.add(b);
        }
        StringBuilder sb = new StringBuilder();
//        遍历字符串paragraph
        for(int i = 0; i < paragraph.length(); i ++){
            char c = paragraph.charAt(i);
//            如果字符串中的字符是字母，则将其转换为小写之后，装入sb中
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }

//            如果不是最后一个字符，或者该字符非字母
            if(i == paragraph.length() - 1 || !Character.isLetter(c)){
//                则将sb中的值转换为字符串
                String w = sb.toString();
//                如果字符串不为空，并且bs中不包含它
                if(!w.isEmpty() && !bs.contains(w)){
//                    将其放入map中
                    map.put(w, map.getOrDefault(w, 0)+1);
//                    如果该字符出现的次数大于最大的max,则交换值，输出res
                    if(map.get(w) > max){
                        max = map.get(w);
                        res = w;
                    }
                }
                sb.setLength(0);
            }
        }
        return res;


    }


    public String mostCommonWord2(String paragraph, String [] banned){
//        代表最终要输出的字符串值
        String maxUsed = "";
//        字符串出现的最多的次数
        Integer maxUsedCount = new Integer(0);
//        将banned 转换为list
        List<String> bannedList = Arrays.asList(banned);
//        将字符串也转换为list
        List<String> list = Arrays.asList(paragraph.toLowerCase().split("[, .!?;']+"));
        HashMap<String, Integer> map = new HashMap();
//        遍历转为list的字符串
        for(String str: list){
//            定义count 计算字符串list中每个字符串出现的次数
            int count = map.getOrDefault(str, 0)+1;
//            然后将其存储到map中
            map.put(str,count);
//            如果该出现次数大于最大的出现次数，并且 改字符串不在bannedlist中。则将该字符串赋值给 maxused,
            if(maxUsedCount < count && !bannedList.contains(str)){
                maxUsed = str;
                maxUsedCount = count;
            }
        }
        return maxUsed;
    }

    public String mostCommonWord3(String paragraph, String [] banned){
        String result = "";
        List<String> bannedList = new ArrayList<>();
        String [] par = paragraph.toLowerCase().split("\\W+");
        Map<String, Integer> map = new HashMap();
        int largest = 0;
        for(int i = 0; i < banned.length; i ++){
            bannedList.add(banned[i]);
        }
        for(int i = 0; i < par.length; i ++){
            String c = par[i];
            if(!bannedList.contains(c)){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }

        for(Map.Entry<String, Integer> pp: map.entrySet()){
            if(largest < pp.getValue()){
                largest = pp.getValue();
                result = pp.getKey();
            }
        }
        return result;
    }
}
