package en.strings;

public class CountAndSay_38 {
//    计数序列是具有前五个项的整数序列，如下所示
//            1       1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//            1 is read off as "one 1" or 11.
//            11 is read off as "two 1s" or 21.
//            21 is read off as "one 2, then one 1" or 1211.
//              1211 is read off as "one 1 one 2 two 1" or 111221

//    count 计算字符串中的每个值出现的次数
    public String countAndSay(int n){
//        如果n 为0 则返回空
        if(n <=0){
            return "";
        }

        String ans = "1";
        while(n > 1){
            StringBuilder sb = new StringBuilder();
            int N = ans.length();
//            遍历n
            for(int i = 0; i < N; i++){
//                定义count 为计算连续的两个数是否相同，计算字符串中连续1的数量
                int count = 1;
                while(i + 1 < N && ans.charAt(i) == ans.charAt(i+1)){
                    count++;
                    i++;
                }
//                将count 的值拼接到sb中
                sb.append(count);
//                在拼接上 ans.charAt(i)   11 is read off as "two 1s" or 21.
                sb.append(ans.charAt(i));
            }
            ans = sb.toString();
            n--;
        }
        return ans;

    }

    
    public String countAndSay1(int n){

//        如果n 为1 则直接输出 str
        String str = "1";
        if(n == 1) {
            return str;
        }
//        遍历n ,并改变str 的值
        for(int i = 1; i < n; i ++){
            str = sequencegenerator(str);
        }
        return str;
    }

    private  String sequencegenerator(String str){
        int count = 0;
        String result = "";
        for(int i = 0; i < str.length(); i ++){
            count++;
//            如果是最后一个值，或者 当前值不等于下一个值
            if(i == str.length() - 1 || (str.charAt(i)!=str.charAt(i+1))){
//                则result = result + count
                result+=count;
                result+=str.charAt(i);
                count=0;
            }
        }
        return result;
    }

    public String countAndSay2(int n){
        return dfs(n);
    }

    private String dfs(int n){
        if(n == 1)return "1";
        if(n == 2)return "11";

        String ret = dfs(n-1);
        int len = 1;
        char num = ret.charAt(0);
        StringBuilder sb = new StringBuilder();
//        遍历前一个数字所对应的转换值
        for(int i = 1; i <=ret.length(); i ++){
            char c = ret.charAt(i);
//            判断转换之后的值的长度
            if(c == num){
                len++;
            }else{
                sb.append(len).append(num);
                len = 1;
                num = c;
            }

        }
        sb.append(len).append(num);
        return sb.toString();
    }
}
