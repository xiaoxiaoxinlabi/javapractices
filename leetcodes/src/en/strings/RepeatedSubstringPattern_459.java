package en.strings;

public class RepeatedSubstringPattern_459 {
//    给定一个非空字符串，检查是否可以通过获取其子字符串并将该子字符串的多个副本附加在一起来构造它。您可以假设给定的字符串仅包含小写英文字母，并且其长度不会超过10000。

    public boolean repeatedSubstringPattern1(String s){
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    //  如果全是重复的子字符串，那么使用split函数拆分后的数组长度将会是0
//  找字符串长度的因子，挨个去拆分出子串，去测试满足split函数拆分的数组长度是否为0
    public boolean repeatedSubstringPattern2(String s){
        if(s == null){
            return false;
        }
        if(s.length() == 1){
            return false;
        }
        if(s.split(String.valueOf(s.charAt(0))).length == 1){
            return true;
        }
        for(int i = s.length(); i >= 2; i--){
            if(s.length() % i == 0){
                String pattern = s.substring(0, i);
                String [] arr = s.split(pattern);
                if(arr.length == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern3(String s){
        if(s.length() < 2){
            return false;
        }
        String together  = s + s;
//        2.掐头去尾留中间；
//    3.如果还包含原字符串，则满足题意。
        together = together.substring(1,together.length() -1);
        return together.contains(s);
    }

    public boolean repeatedSubstringPattern4(String s){
        int len = s.length();
//        遍历字符串的前半截
        for(int i = 1; i <= len / 2; i++){
//            如果是双字符
            if(len % i == 0){
                int indexEnd = 0;
//                截取字符串的0 , i 的部分
                String substr = s.substring(0,i);
                while(indexEnd+i <= len && substr.equals(s.substring(indexEnd, indexEnd +i))){
                    indexEnd+=i;
                }
                if(indexEnd == len){
                    return true;
                }

            }

        }
        return false;
    }


}
