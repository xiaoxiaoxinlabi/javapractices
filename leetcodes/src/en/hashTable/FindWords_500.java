package en.hashTable;

import java.util.*;

public class FindWords_500 {
//    给出一个单词列表，返回可以在美国键盘的一行上用字母输入的单词，如下图所示。
    public String[] findWords(String[] words){

        List<String> list = new ArrayList();
        int [] arr = new int[26];

//        将26个字母按照键盘上的排行分组
        for(char c = 'a'; c <= 'z'; c ++){
            if("zxcvbnm".indexOf(c) >= 0){
                arr[c - 'a'] = 1;
            }else if("asdfghjkl".indexOf(c) >= 0){
                arr[c - 'a'] = 2;
            }else{
                arr[c - 'a'] = 3;
            }
        }

//        遍历字符串数组，计算每个字符串的第一个字母所在的行 row; 然后遍历该字符串后续的字符所在的行，如果与第一个字符不在同一行，则放弃，否则全部添加到list中
        for(String word: words){
            boolean possible = true;
            String lWord = word.toString().toLowerCase();
            int row = arr[lWord.charAt(0) - 'a'];

            for(int i = 1; i < lWord.length(); i ++){
                if(arr[lWord.charAt(i) - 'a'] != row){
                    possible = false;
                    break;
                }
            }
            if(possible){
                list.add(word);
            }

        }
        return list.toArray(new String[list.size()]);

    }

    public String [] findWords1(String [] words){
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";

        List<String> list = new ArrayList<>();


        for(int i = 0; i < words.length; i ++){
            Set<Integer> set = new HashSet();
            boolean isok = true;
            String tmp = words[i];

            for(int j = 0; j < tmp.length(); j ++){
                String ch = Character.toString(tmp.charAt(j)).toLowerCase();
                if(str1.contains(ch)){
                    set.add(1);
                }
                if(str2.contains(ch)){
                    set.add(2);
                }
                if(str3.contains(ch)){
                    set.add(3);
                }
                if(set.size() > 1){
                    isok = false;
                }

            }
            if(isok){
                list.add(tmp);
            }

        }
        return list.toArray(new String[list.size()]);
    }

    public String[] findWords2(String [] words){
        Map<Character, String> lookup = new HashMap<>();
        index("qwertyuiop", lookup);
        index("asdfghjkl",lookup);
        index("zxcvbnm",lookup);

        List<String> res = new ArrayList<>();
        main:
        for(String word: words){
            String temp = word;
            char [] chars = temp.toLowerCase().toCharArray();
            String prev = lookup.get(chars[0]);
            for(int i = 1; i < chars.length; i ++){
                String current = lookup.get(chars[i]);
                if(prev != current){
                    continue main;
                }
                prev = current;
            }
            res.add(word);
        }
        return res.toArray(new String[0]);

    }

    private void index(String str, Map<Character,String> map){
        for(char c : str.toCharArray()){
            map.put(c,str);
        }
    }

    public String [] findWords3(String [] words){
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        String []res = new String[words.length];
        int count = 0;
        for(int i = 0; i < words.length; i ++){
            String word = words[i].toLowerCase();
           int found = 1;
           if(row1.indexOf(word.charAt(0)) != -1){
               for(int j = 1; j < word.length(); j ++){
                   if(row1.indexOf(word.charAt(j)) == -1){
                       found = 0;
                       break;
                   }
               }
           }else if(row2.indexOf(word.charAt(0)) != -1){
               for(int j = 1; j < word.length(); j ++){
                   if(row2.indexOf(word.charAt(j)) == -1){
                       found = 0;
                       break;
                   }
               }
           }else if(row3.indexOf(word.charAt(0)) != -1){
               for(int j = 1; j < word.length(); j ++){
                   if(row3.indexOf(word.charAt(j)) == -1){
                       found = 0;
                       break;
                   }
               }
           }
           if(found == 1){
               res[count] = words[i];
               count ++;
           }
        }
        String [] ans = new String[count];

        for(int i = 0; i < count; i ++){
            ans[i] = res[i];
        }
        return res;

    }

    public String[] findWords4(String [] words){
        List<String> output = new ArrayList<>();
        for(String word: words){
            if(word.toLowerCase().matches("[qwertyuiop]+") ||
                word.toLowerCase().matches("[asdfghjkl]+") ||
                word.toLowerCase().matches("[zxcvbnm]+")){
                output.add(word);
            }
        }
            return output.toArray(new String[output.size()]);
    }




    public static void main(String[] args){
        String [] words = {"Hello","Alaska","Dad","Peace"};
        new FindWords_500().findWords2(words);
    }



}
