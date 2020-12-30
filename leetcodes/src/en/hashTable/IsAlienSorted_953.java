package en.hashTable;

import java.util.HashMap;

public class IsAlienSorted_953 {
//  令人惊讶的是，在外来语言中，他们也使用英语小写字母，但可能是不同的顺序。字母表的顺序是小写字母的一些排列。
//给定一个用该外语书写的单词序列和字母表的顺序，当且仅当给定的单词在该外语的字典按字母顺序排序时返回true。

    public boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> hm = new HashMap();
        for(int i = 0; i < order.length(); i ++){
            hm.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i ++){
            String word1 = words[i];
            String word2 = words[i+1];

            int len = Math.min(word1.length(), word2.length());

            for(int j = 0; j < len ; j ++){
                if(hm.get(word1.charAt(j)) < hm.get(word2.charAt(j))){
                    break;
                }else if(hm.get(word1.charAt(j)) > hm.get(word2.charAt(j))){
                    return false;
                }else if(j == len - 1 && word1.length() > word2.length()){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean isAlienSorted1(String[] words, String order){
        int [] index = new int[26];
        for(int i = 0; i < order.length(); i ++){
            index[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < words.length - 1; i ++){
            int length = Math.min(words[i].length(), words[i + 1].length());
            int match = 0;
            for(int j = 0; j < length; j ++){
                if(words[i].charAt(j) != words[i+1].charAt(j)) {
                    if(index[words[i].charAt(j) - 'a'] > index[words[i+1].charAt(j) - 'a']){
                        return false;
                    }else{
                        break;
                    }
                }else{
                    match++;
                }
            }
            if(match == length && words[i].length() > words[i + 1].length()){
                return false;
            }

        }
        return true;
    }
}
