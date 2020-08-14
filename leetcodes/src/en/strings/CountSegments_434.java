package en.strings;

public class CountSegments_434 {

    //    计算字符串中的段数，其中一个段被定义为连续的非空格字符序列。
//    请注意，该字符串不包含任何不可打印的字符。
    public int countSegments1(String s) {
//        去除字符串前后空格
        s = s.trim();
//        判断字符串是否为空
        if (s.length() == 0 || s == null) {
            return 0;
        }
//        定义count计算空字符串的数量
        int count = 0;
//        遍历字符串，如果当前字符的前一个字符为空格，但是当前字符不为空，则空格加一
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == 32 && s.charAt(i) != 32) {
                count++;
            }
        }
//        最后的子字符串数量为空格+1
        return count+1;
    }

    public int countSegments2(String s){
//        去除前后空格
        s = s.trim();
//        判断是否为空
        if(s.length() == 0 || s == null){
            return 0;
        }
        int l = s.length();
        int i = l - 1;
        int cnt = 0;
//        倒序遍历数组，计算空格数量
        while(i > 0){
            if(s.charAt(i) == ' ' && s.charAt(i-1)!=' '){
                cnt++;
            }
            i--;
        }
        return cnt == 0 ? 1: cnt+1;
    }
    public int countSegments3(String s){
        if(s.length() == 0){
            return 0;
        }
//        将字符串转为字符串数组
        String [] ss = s.split("");
        if(ss.length == 0){
            return 0;
        }
//        定义变量为计算字符数组中的空格元素的数量
        int blank = 0;
//       则ss 中有多个空元素
        for(String res: ss){
            if(res.equals("")){
                ++blank;
            }
        }
        return ss.length - blank;
    }
    public int countSegments4(String s){
//        定义变量计算空格，字符的数量
        int count = 0;
        int letters = 0;
        if(s.length() == 0){
            return 0;
        }
        for(int i = 0; i < s.length()-1; i++){
//            如果字符不为空，则字符数量加一
            if(s.charAt(i)!= ' '){
                letters++;
            }
//            计算空格数量
            if(s.charAt(i)!=' '&& s.charAt(i+1)==' ' || letters == s.length()){
                count++;
            }
        }
//        如果最后一个字符不为空
        if(s.charAt(s.length()-1)!=' '){
            count++;
        }
        return count;
    }
}
