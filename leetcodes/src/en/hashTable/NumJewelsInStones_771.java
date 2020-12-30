package en.hashTable;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones_771 {
//    您得到的字符串J代表宝石的宝石类型，而S代表您拥有的宝石。 S中的每个字符都是您拥有的一块石头。您想知道您拥有多少宝石也是珠宝。
//    确保J中的字母是不同的，并且J和S中的所有字符都是字母。字母区分大小写，因此“ a”被认为与“ A”不同。

//    S中包含几J中的多少个字母

//    Example 1:
//
//    Input: J = "aA", S = "aAAbbbb"
//    Output: 3
//
//    Example 2:
//
//    Input: J = "z", S = "ZZ"
//    Output: 0

    public int numJewelsInStones(String J, String S) {

        Set<Character> set = new HashSet();
        int count = 0;
        for(int i = 0; i < J.length(); i ++){
            set.add(J.charAt(i));
        }

        for(int i = 0; i < S.length(); i ++){
            char c = S.charAt(i);
            if(set.contains(c)){
                count++;
            }
        }
        return count;


    }

    public int numJewelsInStones1(String J, String S){
        char [] js = J.toCharArray();
        char [] ss = S.toCharArray();
        int res = 0;

        for(int i = 0; i < js.length; i ++){
            for(int j = 0; j < ss.length; j ++){
                if(js[i] == ss[j]){
                    res++;
                }
            }
        }
        return res;
    }


    public int numJewelsInStones2(String J, String S){
        int [] occ = new int[100];
        for(int c : J.toCharArray()){
            occ[c - 'A']++;
        }

        int count = 0;
        for(int c : S.toCharArray()){
            if(occ[c - 'A'] == 1){
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones3(String J, String S){
        int num = 0;
        for(int i = 0; i < S.length(); i ++){
            if(J.indexOf(S.charAt(i)) != -1){
                num++;
            }
        }
        return num;
    }
}
