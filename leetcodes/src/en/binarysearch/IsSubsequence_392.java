package en.binarysearch;

public class IsSubsequence_392 {

//    检查s是否为t的子序列

//    字符串的子序列是一个新字符串，它是通过删除某些字符（可以是无字符）而不会干扰其余字符的相对位置而从原始字符串形成的。 （即，“ ace”是“ abcde”的子序列，而“ aec”则不是）。
//    跟进：
//    如果有很多传入的S，请说S1，S2，...，Sk，其中k> = 1B，并且您想一个个检查一个T是否有其子序列。在这种情况下，您将如何更改代码？

    public boolean isSubsequence(String s, String t) {

       int n = s.length();
       int m = t.length();
       int i = 0, j = 0;
       while(i < n && j < m){
           if(s.charAt(i) == t.charAt(j)){
               i++;
           }
           j++;
       }

       return i == n;

    }

    public boolean isSubsequence1(String s, String t){
        if(s.length() == 0){
            return true;
        }
        if(t.length() == 0){
            return false;
        }

        for(int i = 0; i < s.length(); i ++){
//            判断当前值在t中出现的索引位置
            int idx = t.indexOf(s.charAt(i));
            if(idx == -1){
                return false;
            }
//            重新截取t 为从 idx + 1 到结尾
            t = t.substring(idx+1);
        }
        return true;
    }
    public boolean isSubsequence2(String s, String t){
        boolean flag = false;
        int j = 0;
        if(s == null || s.isEmpty()){
            return true;
        }
        for(int i = 0; i < s.length(); i ++){
            flag = false;
            char c1 = s.charAt(i);
            while(j < t.length()){
                if(c1 != t.charAt(j)){
                    j++;
                }else{
                    flag = true;
                    j++;
                    break;
                }
            }
        }
        return flag;
    }
}
