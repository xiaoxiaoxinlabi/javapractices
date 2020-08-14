package en.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BuddyStrings_859 {
//    给定两个由小写字母组成的字符串A和B，当且仅当我们可以交换A中的两个相邻的字母以使结果等于B时，才返回true。

    public boolean buddyStrings(String A, String B){
//        如果两个字符串长度不相等，则返回false
        if(A.length() != B.length()){
            return false;
        }
//        如果字符串 A 的值等于字符串 B 的值
        if(A.equals(B)){
            HashSet<Character> h = new HashSet();

//            将字符串A的字符放进set中
            for(char c: A.toCharArray()){
                h.add(c);
            }
//            如果set中的长度小于A的长度则返回true,否则返回false
            if(h.size() < A.length()){
                return true;
            }else{
                return false;
            }

        }

        List<Integer> res = new ArrayList();
//        遍历字符串A，如果相同索引位置上的字符串a 不等于字符 b,则将改索引装进list 中
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) != B.charAt(i)){
                res.add(i);
            }
        }
//        如果list中长度为2 ，并且 交换A，B 中索引0,1 的元素之后仍相对，则返回true
        if(res.size() == 2 && A.charAt(res.get(0)) == B.charAt(res.get(1)) && B.charAt(res.get(0)) == A.charAt(res.get(1))){
            return true;

        }else{
            return false;
        }
    }

}
