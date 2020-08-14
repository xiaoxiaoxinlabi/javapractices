package en.strings;

public class CountBinarySubstrings_696 {

//    给定一个字符串s，计算具有相同数量的0和1的非空（连续）子字符串的数量，并且这些子字符串中的所有0和所有1都被连续分组

    public int countBinarySubstrings1(String s){

//        将字符串转换成字符数组
        char [] str = s.toCharArray();

        char prev = str[0];
//        记录连续的数
        int countNum = 1;
        int res = 0;
        for(int i = 1; i < str.length; i ++){
//            如果是 00 | 11
            if(str[i] == prev){
//                连续的数加1
                countNum++;
            }else{
//                当我们遇到不相等的数字，因此我们从当前开始使用j索引前进时， i 保持不变
//                并计算所有不等于上一个数字
                for(int j = i; countNum > 0 && j < str.length; j ++){

                    if(str[j] != prev){
                        res++;
                        countNum--;
                    }else{
                        break;
                    }
                }
//                一旦完成，i 将成为下一个prev对应的值
                prev = str[i];
                countNum = 1;
            }
        }
        return res;
    }



}
