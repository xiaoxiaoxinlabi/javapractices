package en.strings;

public class FreqAlphabets_1309 {
//
//    给定由数字（'0'-'9'）和'＃'组成的字符串s。我们想将s映射为英文小写字符，如下所示：
//
//    字符（'a'至'i'）分别由（'1'至'9'）表示。
//    字符（'j'至'z'）分别由（'10＃'至'26＃'）表示。
//    返回映射后形成的字符串。
//    Example 1:
//
//    Input: s = "10#11#12"
//    Output: "jkab"
//    Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//    Example 2:
//
//    Input: s = "1326#"
//    Output: "acz"
//    Example 4:
//
//    Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
//    Output: "abcdefghijklmnopqrstuvwxyz"

    public String freqAlphabets(String s) {
        char [] c = s.toCharArray();
        StringBuilder ss = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int n;
            if(i < s.length()-2 && c[i+2] == '#'){
                n = Integer.parseInt(s.substring(i, i+2));
                i+=3;
            }else{
                n = Character.getNumericValue(c[i]);
                i+=1;
            }
            n = n + 96;
            char cc = (char)n;
            ss.append(cc);
        }
        return ss.toString();
    }

    public String freqAlphabets1(String s){
        StringBuilder builder = new StringBuilder();
//        将字符串转换为字符数组
        char [] arr = s.toCharArray();
        int i = 0;
//        遍历字符数组
        while(i < arr.length){
//            如果当前索引+2 小于 字符数组长度，并且 当前索引+2 之后的对应的索引的值为 #；则将其转换为对应的字母
            if(i+2 < arr.length && arr[i+2] == '#'){
//                获取的数字转换成ascii ：arr[i]-'0'
                char c1 = (char)('a'-1+10*(arr[i]-'0')+(arr[i+1]-'0'));
                builder.append(c1);
                i+=3;
            }else{
                char c1 = (char)('a' - 1+(arr[i]-'0'));
                builder.append(c1);
                ++i;
            }
        }
        return builder.toString();
    }

    public String freqAlphabets2(String s){
        StringBuilder result = new StringBuilder();
        char [] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i ++){
            if((i+2) < s.length() && arr[i+2] == '#'){
                char tmp = (char)('a'+ Character.getNumericValue(arr[i])*10 + Character.getNumericValue(arr[i+1]) - 1);
                result.append(tmp);
                i+=2;
            }else{
                result.append((char)('a'+Character.getNumericValue(arr[i])-1));
            }
        }
        return result.toString();
    }
}
