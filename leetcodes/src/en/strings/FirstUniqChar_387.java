package en.strings;

public class FirstUniqChar_387 {
//    给定一个字符串，找到其中的第一个非重复字符并返回其索引。如果不存在，则返回-1。

    public int firstUniqChar(String s){
        int [] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i ++){
            if(arr[s.charAt(i) - 'a'] ==1){
                return i;
            }
        }
        return -1;
    }

//    查找字符串第一个出现的索引，最后一次出现的索引，如果两者相等，则说明只出现了一次
    public int firstUniqChar1(String s){
        for(int i = 0; i < s.length(); i ++){
            int firstIndex = s.indexOf(s.charAt(i));
            int lastIndex = s.lastIndexOf(s.charAt(i));
            if(firstIndex == lastIndex){
                return firstIndex;
            }
        }
        return -1;
    }
    public int firstUniqChar2(String s){
        if(s == null || s.length() == 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for(char c = 'a'; c <= 'z'; c++){
            int in = s.indexOf(c);
            if(in !=-1 && in==s.lastIndexOf(c)){
                res = Math.min(res, in);
            }
        }
        return res == Integer.MAX_VALUE ? -1: res;
    }

}
