package en.strings;

import java.util.ArrayList;

public class ReorderLogFiles_937 {

//  你有一个日志数组 logs。每条日志都是以空格分隔的字串。
//  对于每条日志，其第一个字为字母与数字混合的 标识符。

//  除标识符之外，所有字均由小写字母组成的，称为 字母日志
//  除标识符之外，所有字均由数字组成的，称为 数字日志

//  请按下述规则将日志重新排序：
//
//  所有 字母日志 都排在 数字日志 之前。
//  字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
//  数字日志 应该按原来的顺序排列。
//  返回日志的最终顺序。

//    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
//    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

    public String [] reorderLogFiles1(String [] logs){
        if(logs == null){
            return null;
        }

        ArrayList<String> letterLogs = new ArrayList();
        ArrayList<String> digLogs = new ArrayList();
//        循环遍历字符数组
        for(String log: logs){
//            判断每条日志的标识符之后的第一个值是数字，还是字母，若是则将其添加到字母日志list中；如果是数字，则将其添加到数字日志list中

            if(Character.isDigit(log.charAt(log.indexOf(" ")+1))){
                digLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }

//        对字母日志进行排序
//        依赖于Comparator来定义顺序，而该Comparator通过lambda实现的。
        letterLogs.sort((log1, log2)->{
//
            String dat1 = log1.substring(log1.indexOf(" "));
            String dat2 = log2.substring(log2.indexOf(" "));

            if(dat1.compareTo(dat2) == 0){
                return log1.compareTo(log2);
            }
            return dat1.compareTo(dat2);
        });

        int idx = 0;
        for(String log: letterLogs){
            logs[idx++] = log;
        }
        for(String log: digLogs){
            logs[idx++] = log;
        }

        return logs;

    }
}
