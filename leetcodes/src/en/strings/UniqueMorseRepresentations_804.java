package en.strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations_804 {

//    将字符数组中的对应的字母转换成match 中的值, 去重之后在输出转换之后的长度
    public int uniqueMorseRepresentations1(String [] words){
        Set<String> result = new HashSet();
        String [] match = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        StringBuilder morseword;
        for(String word: words){
            morseword = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                morseword.append(match[word.charAt(i) - 'a']);
            }
            result.add(morseword.toString());
        }

        return result.size();

    }
}
