package en.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextGreatestLetter_744 {

//    给定一个仅包含小写字母的排序字符字母列表，并给定一个目标字母目标，请找到列表中大于给定目标的最小元素。

//    二分查找法
    public char nextGreatestLetter(char[] letters, char target) {

        int len = letters.length;
        int left = 0, right = len;
        while(left < right){
            int mid = left + (right - left)/2;

             if(letters[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        if(left >= len){
            left = 0;
        }

        return letters[left];
    }

    public char nextGreatestLetter1(char [] letters, char target){
//        如果大于最后一个元素，则返回第一个元素
        if(target >= letters[letters.length-1]){
            return letters[0];
        }
        char t = target;
        List<Character> ls = new ArrayList();
//        将字符串中的元素装入list中
        for(int i = 0; i < letters.length; i++){
            ls.add(letters[i]);
        }

        if(ls.contains(t)){
            t++;
        }
        for(int i = 0; i < 26; i ++){
            if(ls.contains(t)){
                return t;
            }
            t++;
        }
        return '\u0000';

    }
    public char nextGreatestLetter2(char [] letters, char target){
        for(char c: letters){
            if(c - 'a' > target  - 'a'){
                return c;
            }
        }
        return letters[0];
    }
}
