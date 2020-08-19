package en.strings;

import java.util.HashMap;

public class MaxNumberOfBalloons_1189 {

//    给定一段文本，使用文本中的字符组成 单词 “balloon”  ，每个字符只能用一次，返回最小的可以组成的数目

    public int maxNumberOfBalloons(String text) {

        String validate = "balloon";

        int [] count = new int[26];
        for(int i = 0; i < text.length(); i ++){
            count[text.charAt(i) - 'a']++;
        }

        int []required = new int[26];
        for(char c: validate.toCharArray()){
            required[c - 'a']++;
        }
        int ans = count[1] / required[1];
        for(int i = 0; i < 26; i ++){
            if(required[i] != 0){
                ans = Math.min(ans, count[i]/ required[i]);
            }
        }

        return ans;

    }

    public int maxNumberOfBalloons1(String text){
        HashMap<Character,Integer> freq = new HashMap();
        freq.put('a', 0);
        freq.put('b',0);
        freq.put('l',0);
        freq.put('n', 0);
        freq.put('o',0);

//        统计字符串中遇到的字符出现的次数
        for(int i = 0; i < text.length(); i++){
            if(freq.containsKey(text.charAt(i))){
                int count = freq.get(text.charAt(i));
                freq.put(text.charAt(i),count+1);
            }
        }

//        balloon

        return  Math.min((int)Math.min(freq.get('l'), freq.get('0'))/2, Math.min(freq.get('b'),Math.min(freq.get('a'),freq.get('n'))));
    }


    public int maxNumberOfBalloons2(String text){
        if(text == null || text.length() == 0){
            return 0;
        }
        int [] count = new int[26];
        for(int i = 0; i < text.length(); i++){
            count[text.charAt(i) - 'a']++;
        }
//        获取每个字符出现的最小次数
        int min = Integer.MAX_VALUE;
        min = Math.min(count['b'-'a'], min);
        min = Math.min(count['a' - 'a'], min);
        min = Math.min(count['l' - 'a']/2, min);
        min = Math.min(count['o' - 'a']/2, min);
        min = Math.min(count['n' - 'a'], min);
        return min;
    }

    public int maxNumberOfBalloons3(String text){
        int [] counters = new int["balon".length()] ;
        for(char c :text.toCharArray()){
            switch (c){
                case 'b' : counters[0]++; break;
                case 'a' : counters[1]++; break;
                case 'l' : counters[2]++; break;
                case 'o' : counters[3]++; break;
                case 'n' : counters[4]++; break;
            }
        }

        int min = counters[0];
        for(int i = 0; i < 5; i ++){
            min = Math.min(min, (i == 2 || i == 3) ? counters[i] /2 : counters[i]);
        }

        return min;

    }

}
