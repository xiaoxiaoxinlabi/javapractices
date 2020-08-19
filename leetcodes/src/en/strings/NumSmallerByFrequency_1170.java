package en.strings;

import java.util.Arrays;
import java.util.HashMap;

public class NumSmallerByFrequency_1170 {


//  比较字符串最小字母出现频次
//  该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。

//  例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。

//  现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
//  其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的元素


    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int [] wd = new int [11];

        for(String s: words){
            ++wd[count(s)];
        }

        int [] ans = new int [queries.length];
        for(int i = 0; i < queries.length; ++i){
            int c = count(queries[i]);
            int total = 0;
            for(int j = c + 1; j < wd.length; ++j){
                total+= wd[j];
            }
            ans[i] = total;
        }
        return ans;


    }

//    计算字符串中每个字符的出现次数
    private int count(String s){
        if(s.length() < 1){
            return 0;
        }
        int cnt = 1;
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); ++i){
            if(c > s.charAt(i)){
                cnt = 1;
                c = s.charAt(i);
            }else if(c == s.charAt(i)){
                cnt ++;

            }
        }
        return cnt;
    }
    //2521 ms, faster than 5.04
    public int [] numSmallerByFrequency1(String[] queries, String[] words){
        int [] res = new int[queries.length];
        int [] freq = new int[words.length];
//        循环遍历words, 并统计words数组中每个元素中的最小字母出现次数，存放到freq中
        for(int i = 0; i < words.length; i ++){
            freq[i] = calculateMinFreq(words[i]);
        }
//        对freq进行排序
        Arrays.sort(freq);
//        循环遍历queries数组，统计其数组中每个元素中的最小字母出现次数
        for(int i = 0; i < queries.length; i ++){
            int lead_count = calculateMinFreq(queries[i]);
            int j ;
            for(j = 0; j < freq.length; j ++){
//                如果queries中当前元素中的最小字母出现次数小于words中元素的最小字母出现次数，则直接退出循环
                if(lead_count < freq[j]){
                    break;
                }
            }
//            最后的结果为 words中每个元素最小字母出现次数减去 j
            res[i] = freq.length - j;
        }
        return res;
    }


    private int calculateMinFreq(String s){
        int [] count = new int[26];
//        统计字符串中每个字符出现的次数，利用int数组
        for(int i = 0; i < s.length(); i ++){
            count[s.charAt(i) - 'a']++;
        }
        int min = 0;
//        找到出现次数最小的
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                min = count[i];
                break;
            }
        }
        return min;
    }


    public int [] numSmallerByFrequency3(String[] queries, String[] words){
        int [] ans = new int[queries.length];
//        遍历queries数组，
        for(int i = 0; i < queries.length; i ++){
//            计算每个元素中的最小字母出现次数
            int q = fun(queries[i]);
            int a = 0;
//            遍历words数组
            for(int j = 0; j < words.length; j ++){
//                计算每个元素中的最小字母出现次数
                int w = fun(words[j]);
//                如果q中最小字母出现次数 < w 中的最小字母出现次数，则 a++
                if(q < w){
                    a++;
                }

            }
//            将a的值赋给ans
            ans[i] = a;
        }
        return ans;
    }

    private int fun(String s){
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i ++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i = 0; i <= 26; i++){
            char ch = (char)('a' + i);
            if(map.containsKey(ch)){
                return map.get(ch);
            }
        }
        return 0;
    }


}

