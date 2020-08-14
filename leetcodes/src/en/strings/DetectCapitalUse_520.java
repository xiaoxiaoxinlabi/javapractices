package en.strings;

import java.util.regex.Pattern;

public class DetectCapitalUse_520 {

//    判断给出的字符串是否符合某种规则
//    1，所有的字符全大写
//    2，所有的字符全小写
//    3，只有第一个字符大写

//     [A-Z][A-Z]* One Upper and followed by 0 or more upper
//     [A-Z][a-z]* One Upper followed by 0 or more lower
//     [a-z]* - 0 or more occurences of lower case

    public boolean detectCapitalUse1(String word){

          String pattern = "[A-Z][A-Z]*|[A-Z][a-z]*|[a-z]*";
          Pattern p = Pattern.compile(pattern);
        return p.matcher(word).matches();
    }

    public boolean detectCapitalUse2(String word){
//        如果字符串为空则返回true
        if(word.length() == 0){
            return true;
        }
//        将字符串转换为字符数组
        char [] arr = word.toCharArray();
//        定义变量 firstCapital 代表：第一个字符大写； allCpaital代表所有的字符为大写；allLower代表所有的为小写
        boolean firstCapital = false;
        boolean allCpaital = false;
        boolean allLower = true;
//        如果第一个字符为大写；则 修改变量的值
        if(arr[0] >= 65 && arr[0] <=90){
            firstCapital = true;
            allCpaital = true;
            allLower = false;
        }
//        定义一个指针用于判定是从第一个开始遍历还是第二个开始遍历
        int pos = firstCapital ? 1:0;
        for(int i = pos; i < arr.length; i ++){
//            所有的都是大写
            allCpaital &= arr[i] >= 65 && arr[i] <= 90;
//            第一个是大写；其他未小写
            firstCapital &= arr[i] >= 97 && arr[i] <= 122;
//            所有的都为小写
            allLower &= arr[i] >= 97 && arr[i] <= 122;
        }
        return allCpaital || firstCapital || allLower;
    }

//    统计大写字符的个数，并计算大写字符所在的位置
    public boolean detectCapitalUse3(String word){
        int caps = 0;
        boolean flag = false;
        for(int i = 0; i < word.length(); i ++){
            if(Character.isUpperCase(word.charAt(i))){
                caps++;
            }
        }
        if(caps == 0 || caps == word.length()){
            flag = true;
        }else if(caps == 1 && Character.isUpperCase(word.charAt(0))){
            flag = true;
        }
        return flag;

    }
}
