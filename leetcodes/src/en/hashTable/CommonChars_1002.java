package en.hashTable;

import java.util.*;

public class CommonChars_1002 {

//    给定仅由小写字母组成的字符串数组A，返回列表中所有字符串（包括重复项）中显示的所有字符的列表。例如，如果一个字符在所有字符串中出现3次，但没有出现4次，那么您需要在最终答案中将该字符包含3次。
//    您可以按任何顺序返回答案。
//    Example 1:
//    Input: ["bella","label","roller"]
//    Output: ["e","l","l"]
//
//    Example 2:
//    Input: ["cool","lock","cook"]
//    Output: ["c","o"]

    public List<String> commonChars(String[] A) {

        Map<Character,Integer> map = new HashMap();
        String first = A[0];
        for(int i = 0; i < first.length(); i ++){
            map.put(first.charAt(i),map.getOrDefault(first.charAt(i),0)+1);

        }
        for(int i = 1; i < A.length; i ++){
            String value = A[i];
            Map<Character,Integer> temp = new HashMap<>();
            for(int j = 0; j < value.length(); j ++){
                if(!map.containsKey(value.charAt(j))){
                    continue;
                }else{
                    if(!temp.containsKey(value.charAt(j))){
                        temp.put(value.charAt(j),1);
                    }else{
                        int val = temp.get(value.charAt(j));
                        val++;
                        temp.put(value.charAt(j),Math.min(val,map.get(value.charAt(j))));
                    }
                }
            }
            map = temp;
        }
        List<String> res = new ArrayList();
        for(Character c: map.keySet()){
            for(int j = 0; j < map.get(c); j ++){
                res.add(c + " ");
            }
        }
        return res;

        }

        public List<String> commonChars1(String[] A){
        int [] res = new int[26];
        for(int i = 0; i < A[0].length(); i ++){
            res[A[0].charAt(i) - 'a']++;
        }

        for(int i = 1; i < A.length; i ++){
            int [] tmp = new int[26];
            for(int j = 0; j < A[i].length(); j ++){
                char c = A[i].charAt(j);
                tmp[c - 'a']++;
            }

            for(int j = 0; j < 26; j ++){
                res[j] = Math.min(res[j],tmp[j]);
            }
        }

        List<String> list = new ArrayList();
        for(char c = 'a'; c <= 'z'; c ++){
            while (res[c-'a']-- > 0){
                list.add(c+"");
            }
        }
        return list;
        }

        public List<String> commonChars2(String [] A){
        int [] finallCount = new int[26];
            Arrays.fill(finallCount,100);
            for(String a: A){
                int [] tmpcount = new int[26];
                for(char ch: a.toCharArray()){
                    tmpcount[ch - 'a']++;
                }
                for(int j = 0; j < 26; j ++){
                    finallCount[j] = Math.min(finallCount[j],tmpcount[j]);
                }
            }
            List<String> list = new ArrayList();
            for(int i = 0; i < 26; i ++){
                for(int j = 0; j < finallCount[i]; j ++){
                    char c = 'a';
                    c =(char) (c + i);

//                    list.add(c+"");
//                    更快
                    list.add(Character.toString(c));
                }
            }
            return list;
        }

}
