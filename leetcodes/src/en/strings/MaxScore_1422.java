package en.strings;

public class MaxScore_1422 {

//  给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
//「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。

//  示例 1：
//
//  输入：s = "011101"
//  输出：5
//  解释：
//  将字符串 s 划分为两个非空子字符串的可行方案有：
//  左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
//  左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
//  左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
//  左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
//  左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3

    public int maxScore(String s) {

       int p = 0, c = 0;
//       先计算所有的1 的数量
       for(int i = 0; i < s.length(); i ++){
           if(s.charAt(i) == '1'){
               p++;
           }
       }
       int sum = p - 1;
//       再次循环遍历数组，
       for(int i = 0; i < s.length()-1; i++){
//           计算0 的数量，如果遇到1 则 p 减1
           if(s.charAt(i) == '0'){
               c++;
           }else{
               p--;
           }
//           统计每轮的最大和
           if(c+p > sum){
               sum = c + p;
           }
       }
       return sum;

    }

    public int maxScore1(String s){
        int res = 0;
        String left = "", right = "";
        for(int i = 1; i < s.length(); i++){
//            遍历字符串，按照当前索引进行截取
            left = s.substring(0,i);
            right = s.substring(i, s.length());
//            判断每次截取之后的和
            int subTotal = sumStr(left,right);
//            得到最大的值，然后返回
            if(res < subTotal){
                res = subTotal;
            }
        }
        return res;
    }

    private int sumStr(String left, String right){
        int res = 0;
//        如果左串遇到0 ，则res加一
        for(int i = 0; i < left.length(); i++){
            if(left.charAt(i) == '0'){
                res++;
            }
        }
//        如果右串遇到1 ，则res + 1
        for(int i = 0; i < right.length(); i++){
            if(right.charAt(i) == '1'){
                res++;
            }
        }
        return res;
    }
}
