package en.strings;

import java.util.HashMap;
import java.util.Map;

public class Compress_443 {
//    给定一个字符数组，就地压缩它。
//    压缩后的长度必须始终小于或等于原始数组。
//    数组的每个元素都应该是长度为1的字符（不是int）。
//    在完成就地修改输入数组之后，返回数组的新长度。

//    Input:
//            ["a","a","b","b","c","c","c"]
//
//    Output:
//    Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

//    Input:
//            ["a"]
//
//    Output:
//    Return 1, and the first 1 characters of the input array should be: ["a"]

    public static char[] compress(char [] chars){

//  定义一个stringbuilder 用来重新append 值
        StringBuilder sb = new StringBuilder();
//        定义一个变量count 表示该字符出现的次数
        int count = 1;
        char pre = chars[0];

//        循环遍历字符数组，比较当前元素与前一个元素是否相等
       for(int i = 1; i < chars.length; i ++){
//           如果不相等，则直接将该字符追加到sb中，如果count > 1 则将出现次数追加到sb中
           if(chars[i-1] != chars[i]){

              sb.append(chars[i]);
              if(count > 1){
                  sb.append(count);
              }
              count = 1;
              pre = chars[i];
//        否则，count 加加
           }else{
               count++;
           }

       }
       sb.append(pre);

       if(count > 1){
           sb.append(count);
       }
       for(int i = 0; i < sb.length(); i ++){
           chars[i] = sb.charAt(i);
       }
       return sb.toString().toCharArray();
//       return sb.length();



    }

    public static int compress1(char [] chars){
        int left = 0, right = 0, curcount = 0;
        while(right < chars.length){
            char ch = chars[right];
            curcount = 0;

            while(right < chars.length && chars[right] == ch){
                right++;
                curcount++;
            }
            chars[left++]=ch;
            if(curcount > 1){
                String newlen = ""+curcount;
                for(char c: newlen.toCharArray()){
                    chars[left++] = c;
                }
            }
        }
        return left;
    }


    public static int compress2(char [] chars){
//        定义一个当前索引，更新后的索引
        int index = 0, updateindex = 0;
//        从当前索引开始循环遍历字符数组
        while(index < chars.length){
//            定义变量vcount 计算相等元素的数量
            int count = 0;
//            定义当前索引所对应的值
            char current = chars[index];
//            如果当前值等于下一个值，则index 继续前进扫描， count 增加
            while(index < chars.length && chars[index] == current){
                index ++;
                count ++;

            }
//            重新对chars 赋值
            chars[updateindex++] = current;
//            如果count 不等于1 ，这说明有重复的元素
            if(count != 1){
                String counterVal = String.valueOf(count);
                for(char c: counterVal.toCharArray()){
                    chars[updateindex++] = c;
                }
            }
        }
        return updateindex;
    }

    public static int compress3(char [] chars){
        int N = chars.length;
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i < N){
            int j = i;
            while(j < N && chars[j] == chars[i]){
                j++;
            }
            res.append(chars[i]);
            res.append(j-i);
            j = i;
        }
        String ans = res.toString();
        if(ans.length() < chars.length){
            return ans.length();
        }
        return chars.length;
    }

    public static char [] compress4(char[] chars){
        StringBuilder sb = new StringBuilder().append((chars[0]));
        int cnt = 1;
        for(int i = 1; i < chars.length; i ++){
            if(chars[i] == chars[i-1]){
                cnt++;
            }else{
                sb.append(cnt).append(chars[i]);
                cnt = 1;
            }
        }
        sb.append(cnt);
        char [] tmp = sb.toString().toCharArray();
        for(int i = 0; i < tmp.length; i ++){
            chars[i] = tmp[i];
        }
        return tmp;

    }
    public static void main(String [] args){
        char [] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress4(chars));
    }
}
