package en.hashTable;

import java.util.ArrayList;

public class ShortestCompletingWord_748 {

//    给定一个字符串licensePlate和一个字符串单词数组，找到单词中最短的完整单词。
//    补全单词是包含licensePlate中所有字母的单词。忽略licensePlate中的数字和空格，并将字母视为不区分大小写。如果一个字母在licensePlate中出现多次，则它在单词中的出现次数必须相同或多次。
//    例如，如果licensePlate =“ aBc 12c”，则它包含两次字母'a'，'b'（忽略大小写）和'c'。可能的补全单词是“ abccdef”，“ caaacab”和“ cbca”。
//    返回单词中最短的补全单词。保证答案存在。如果有多个最短的补全单词，请返回出现在单词中的第一个。

    public String shortestCompletingWord(String licensePlate, String[] words) {

        int [] ch = new int[26];
        licensePlate = licensePlate.toLowerCase();

        for(char c : licensePlate.toCharArray()){

            if(Character.isLetter(c)){
                ch[c - 'a']++;
            }
        }

        String res = "";

        for(int i = 0; i < words.length; i ++){
            int [] temp = new int[26];
            for(int j = 0; j < words[i].length(); j ++){
                char ct = words[i].charAt(j);
                temp[ct - 'a']++;
            }


            for(int k = 0; k < 26; k ++){
                if(temp[k] < ch[k]){
                    break;
                }
                if(k == 25){
                    if(res.length() == 0 || res.length() > words[i].length()){
                        res = words[i];
                    }
                }
            }

        }
        return res;

    }

    public String shortestCompletingWord1(String licensePlate, String[] words){
        int [] licenesPlateCount = new int[26];
        ArrayList<String> res = new ArrayList();
        int min = Integer.MAX_VALUE;
        licensePlate = licensePlate.toLowerCase();

        for(char c : licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                licenesPlateCount[c - 'a']++;
            }
        }

        for(String word: words){
            int [] wordCharCount = new int[26];
            boolean flag = true;
            for(char c : word.toCharArray()){
                wordCharCount[c - 'a']++;
            }

            for(int k = 0; k < 26; k ++){
                if(licenesPlateCount[k] > wordCharCount[k]){
                    flag = false;
                }
            }
            if(flag){
                res.add(word);
                if(word.length() < min){
                    min = word.length();
                }
            }
        }

        for(int i = 0; i < res.size(); i ++){
            if(res.get(i).length() == min){
                return res.get(i);
            }
        }
        return "-1";
    }
}
