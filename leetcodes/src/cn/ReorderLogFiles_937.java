package cn;

import java.util.Arrays;

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

    Arrays.sort(logs, (log1, log2) ->{
      String [] split1 = log1.split(" ", 2);
      String [] split2 = log2.split(" ", 2);
      boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
      boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//      如果都不是数字
      if(!isDigit1 && !isDigit2){
//        则按照字典顺序进行比较
        int cmp = split1[1].compareTo(split2[1]);
//        如果不相等，则返回 比较的值
        if(cmp !=0){
          return cmp;
        }
        return split1[0].compareTo(split2[0]);

      }

      return isDigit1 ?(isDigit2 ? 0: 1) : -1;


    });
    return logs;


  }


}
