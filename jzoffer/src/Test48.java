import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test48 {

//  最长不含重复字符的子字符串
//  请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//  输入: "abcabcbb"
//  输出: 3
//  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

//  动态规划解析：
//  状态定义： 设动态规划列表 dp，dp[j] 代表以字符 s[j]为结尾的 “最长不重复子字符串” 的长度。
//  转移方程： 固定右边界 j，设字符 s[j] 左边距离最近的相同字符为 s[i] ，即 s[i] = s[j]。
//当 i < 0，即 s[j] 左边无相同字符，则 dp[j] = dp[j-1] + 1；
//  dp[j - 1] < j - i ，说明字符 s[i] 在子字符串 dp[j-1]区间之外 ，则 dp[j] = dp[j - 1] + 1
//dp[j−1]≥j−i ，说明字符 s[i]在子字符串 dp[j-1]区间之中 ，则 dp[j]的左边界由 s[i] 决定，即 dp[j] = j - i；






//  左边界 i获取方式： 遍历到 s[j] 时，初始化索引 i = j - 1 ，向左遍历搜索第一个满足 s[i] = s[j]的字符即可 。

//  方法一：动态规划 + 哈希表

  public int lengthOfLongestSubstring1(String s){
    Map<Character,Integer> map = new HashMap<>();
    int res = 0, tmp = 0;
//    哈希表统计： 遍历字符串 s 时，使用哈希表（记为 map ）统计 各字符最后一次出现的索引位置 。
    for(int j = 0; j < s.length(); j ++){
      // 获取索引 i
//      左边界 i 获取方式： 遍历到 s[j]时，可通过访问哈希表 dic[s[j]] 获取最近的相同字符的索引 i 。
      int i = map.containsKey(s.charAt(j))? map.get(s.charAt(j)) : -1;
      // 更新哈希表
      map.put(s.charAt(j), j);
      // dp[j - 1] -> dp[j]
      tmp = tmp < j - i ? tmp + 1: j - i;
      // max(dp[j - 1], dp[j])
      res = Math.max(res, tmp);
    }
    return res;
  }



//  方法二： 动态规划 + 线性遍历
  public int lengthOfLongestSubstring2(String s){
    Map<Character, Integer> map = new HashMap<>();

    int res = 0, tmp = 0;
    for(int j = 0; j < s.length(); j++){
      int i = j - 1;

//      线性查找
      while(i >=0 && s.charAt(i) !=s.charAt(j)){
        i--;
      }
      // dp[j - 1] -> dp[j]
      tmp = tmp < j-i ? tmp + 1: j-i;
      // max(dp[j - 1], dp[j])
      res = Math.max(res, tmp);
    }
    return res;


  }

//  方法三：双指针 + 哈希表
  public int lengthOfLongestSubstring3(String s){
    Map<Character, Integer> map = new HashMap();
    int i = -1, res = 0;
//    哈希表 map统计： 指针 j遍历字符 s ，哈希表统计字符 s[j]最后一次出现的索引 。
    for(int j = 0; j < s.length(); j++){
//      更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]]，每轮更新左边界 i ，保证区间 [i + 1, j] 内无重复字符且最大。

      if(map.containsKey(s.charAt(j))){
        i = Math.max(i , map.get(s.charAt(j)));
      }
      map.put(s.charAt(j), j);

//      更新结果 res ： 取上轮 res 和本轮双指针区间 [i + 1,j]的宽度（即 j - i）中的最大值。
      res = Math.max(res, j-i);
    }
    return res;
  }

//  方法四：滑动窗口法
  public String lengthOfLongestSubstring4(String s){

    int start = 0, end = 0, max = 0;
    Set<Character> set = new HashSet<>();
    while(start < s.length() && end < s.length()){
//      如果set中不包含end, 则将end添加到set中
      if(!set.contains(s.charAt(end))){
        set.add(s.charAt(end));
//        end 索引前进
        end ++;
        max = Math.max(max, end - start);

      }else{
//        如果包含，则将start删除
        set.remove(s.charAt(start));
//        start前进
        start ++;
      }
    }
    return s.substring(start, start + max);

  }

//  方法五：滑动窗口法
  public String lengthOfLongestSubstring5(String s){
    int  max = 0;
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    for(int end = 0; end < s.length(); end ++){
      if(map.containsKey(s.charAt(end))){
        start = Math.max(map.get(s.charAt(end)), start);
      }
      max = Math.max(max, end - start + 1);
      map.put(s.charAt(end), end + 1);

    }
    return s.substring(start, start + max);
  }


}
