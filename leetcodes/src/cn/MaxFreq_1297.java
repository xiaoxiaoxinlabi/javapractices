import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxFreq_1297 {

//  给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
//  子串中不同字母的数目必须小于等于 maxLetters 。
//  子串的长度必须大于等于 minSize 且小于等于 maxSize 。
//  示例 1：
//  输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//  输出：2
//  解释：子串 "aab" 在原字符串中出现了 2 次。
//  它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
//
//  示例 2：
//
//  输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
//  输出：2
//  解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。

  public int maxFreq1(String s, int maxLetters, int minSize, int maxSize){

    int len = s.length();
    Map<String, Integer> countMap = new HashMap();
    for(int i = 0; i < len; i ++){
      if(i + minSize > len){
        break;
      }
      String sub = s.substring(i, i + minSize);
      if(isMatch(sub, maxLetters)){
        countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
      }
    }
    int ansMax = 0;
    for(String str: countMap.keySet()){
      int count = countMap.get(str);
      if(count > ansMax){
        ansMax = count;
      }
    }
    return ansMax;

  }

  private boolean isMatch(String str, int maxLetters){
    Set<Character> set = new HashSet<>();
    for(char c: str.toCharArray()){
      set.add(c);
      if(set.size()  > maxLetters){
        return false;
      }
    }

    return set.size() <= maxLetters;


  }


  public int maxFreq2(String s, int maxLetters, int minSize, int maxSize){

    char [] chars = s.toCharArray();
    Map<String, Integer> map = new HashMap<>();
    // 固定窗口大小的滑动窗口，枚举每个左边界的起始位置，那么右边界位置等于 i + minSize - 1
    for(int i = 0;i <=chars.length - minSize; i ++){

//      如果子串中的不同字母的数目小于等于maxLetters
      if(counter(chars, i, i + minSize - 1)<=maxLetters){

//        key 为从i开始的minsize 个数的字符(将该子串存入map 中，判断出现的次数的最大的)
        String key = String.valueOf(chars, i, minSize);
        map.put(key, map.getOrDefault(key, 0) + 1);
      }
    }

    int max = 0;
    for(Integer value: map.values()){
      max = Math.max(max, value);
    }
    return max;
  }

  // 用来统计不同元素的个数
  private int counter(char [] chars, int start, int end){
    Set<Character> set = new HashSet<>();
    for(int i = start; i <= end; i ++){
      set.add(chars[i]);
    }
    return set.size();
  }


  public int maxFreq3(String s, int maxLetters, int minSize, int maxSize){
    Map<String, Integer> map = new HashMap<>();
    int res = 0;
    for(int i = 0; i <=s.length()-minSize; i ++){
      String sub = s.substring(i, i +minSize);
      if(isValid(sub, maxLetters)){
        //统计最短长度的所有单词出现次数
        map.put(sub, map.getOrDefault(sub, 0) + 1);

      }
      if(map.get(sub) > res){
        res = map.get(sub);
      }
    }
    return res;
  }

  private boolean isValid(String s, int maxLettes){
    //只有小写字母，统计字母是否出现过
    boolean [] chars = new boolean[26];
    int sum = 0;
//    /不同字母出现的次数
    for(int i = 0; i < s.length(); i ++){
      //没有出现过的字母
      if(!chars[s.charAt(i) - 'a']){
        sum++;
        chars[s.charAt(i)-'a']=true;
      }
      //不同字母出现次数超过最多次数
      if(sum > maxLettes){
        return false;
      }
    }
    return true;
  }



}
