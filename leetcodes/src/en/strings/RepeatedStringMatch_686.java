
package en.strings;

public class RepeatedStringMatch_686 {

//    给定两个字符串A和B，找出必须重复的最小次数，以使B是它的子字符串。如果没有这样的解决方案，则返回-1。
//    例如，使用A =“ abcd”和B =“ cdabcdab”。
//    返回3，因为重复三遍A（“ abcdabcdabcd”），B是它的子字符串；并且B不是重复两次的A的子字符串（“ abcdabcd”）

    public int repeatedStringMatch1(String A, String B){
        int i = 1;
        StringBuilder res = new StringBuilder(A);
        while(A.length() < B.length()){
           res.append(A);
            i++;
        }
        if(res.lastIndexOf(B) == -1){
            if(res.append(A).lastIndexOf(B) == -1){
                return -1;
            }else{
                return i + 1;
            }


        }else {
            return i;
        }

    }

    public int repeatedStringMatch2(String A, String B){
        int count = 0;
        if(A == null || B == null){
            return count;
        }
        StringBuilder builder = new StringBuilder();
//        循环次数
        int times = (B.length()/A.length())+2;
        while(times -->= 0){
            builder.append(A);
            count++;
            if(builder.indexOf(B) != -1){
                return count;
            }
        }
        return -1;
    }

    public int repeatedStringMatch3(String A, String B){
        int count = 1;
        StringBuilder sb = new StringBuilder(A);
        while(sb.length() < B.length()){
            sb.append(A);
            count++;
        }
        if(sb.indexOf(B) >= 0){
            return count;
        }else if(sb.append(A).indexOf(B) >= 0){
            return count + 1;
        }else {
            return -1;
        }

    }

}
