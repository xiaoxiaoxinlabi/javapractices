package en.strings;

public class CheckRecord_551 {
//    系统会为您提供一个代表学生出勤记录的字符串。该记录仅包含以下三个字符：
//            'A' : Absent.
//            'L' : Late.
//            'P' : Present.
//
//      如果学生的出勤记录中包含不超过一个“ A”（缺席）或不超过两个连续的“ L”（后期），则可能会获得奖励。
//    您需要返回是否可以根据他的出勤记录来奖励该学生。

//    查找是否包含A， 并且是否为A出现的最后一次，
//    是否包含超过两个以上的lll
    public static boolean  checkRecord1(String s){

      return (s.indexOf('A') == s.lastIndexOf('A') && s.contains("LLL"));
    }

//    循环遍历字符串，第一次判断A出现的次数
//    第二次判断是否当前字符的前后字符都相同
    public boolean checkRecord2(String s){
        int ac = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'A'){
                if(++ac > 1){
                    return false;
                }
            }
        }
        for(int i = 1; i < s.length()-1; i ++){
            if(s.charAt(i) == 'L' && s.charAt(i-1)=='L' && s.charAt(i+1)=='L'){
                return false;
            }
        }
        return true;
    }

    public boolean checkRecord3(String s){
        int ac = 0, lc = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'A'){
                ac++;
                if(ac >= 2){
                    return false;
                }
                lc = 0;
            }else if(s.charAt(i) == 'L'){
                lc++;
                if(lc > 2){
                    return false;
                }
            }else{
                lc = 0;
            }
        }
        return true;
    }

    public static void main(String [] args){
        checkRecord1("PPALLP");
    }


}

