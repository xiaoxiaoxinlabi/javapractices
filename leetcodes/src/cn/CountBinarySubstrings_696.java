public class CountBinarySubstrings_696 {

//  给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
//  重复出现的子串要计算它们出现的次数

//  示例 1 :
//  输入: "00110011"
//  输出: 6
//  解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

//  请注意，一些重复出现的子串要计算它们出现的次数。

//  示例 2 :
//  输入: "10101"
//  输出: 4
//  解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。

//  方法一，按字符分组
//可以将字符串 s 转换为 groups 数组表示字符串中相同字符连续块的长度。例如，如果 s=“11000111000000”，则 groups=[2，3，3，6]。




  public int countBinarySubstrings1(String s){
    int [] groups = new int[s.length()];
    int t = 0;
    groups[0]=1;
    for(int i = 1; i < s.length(); i++){
      if(s.charAt(i-1)!=s.charAt(i)){
        groups[++t] = 1;
      }else{
        groups[t]++;
      }
    }

    int ans = 0;
    for(int i = 1; i <=t; i++){
      ans+=Math.min(groups[i-1], groups[i]);
    }
    return ans;

  }

//  1.中心扩展（类似回文子串的判断）
  public int countBinarySubstrings2(String s){
    int res = 0;
    char [] chars = s.toCharArray();
//    可以用整形序列[1, s.length() - 1]来表示回文中心的位置，那么left = i - 1, right = i 就是最中心的两个字符。
    for(int i = 1; i < s.length(); i ++){
      int left = i - 1, right = i;
//      循环中首先要保证，回文中心左右的两个字符char leftChar = chars[left], rightChar = chars[right];一个是0，另外一个是1。

      char leftChar = chars[left], rightChar = chars[right];
//      比如i = 1时left = 0, right = 1 ，就是第一个可能的满足题目要求的子串。由原字符串中第一，第二个字符构成。
      if(leftChar == rightChar){
        continue;
      }
      while(left >=0 && right < s.length() && chars[left] == leftChar && chars[right] == rightChar){
        left--;
        right++;
        res++;
      }
    }
    return res;
  }

//  2.分组计数
//  假设有4个1与3个0相连，”1111000“ 可以构成的子串有111000，1100，10，共3个；假设有3个0与2个1相连”00011“，可以构成的子串有0011，01，共两个。可以发现我们只要知道相连的两个分组的长度，就可以直接得到这两个组可以构成几个符合题意的子串，就是两分组的中较短的长度。
//  所以只需要通过一次遍历，记录相连两分组的长度即可。preCount表示前一个分组的长度，curCount表示当前分组的长度。
  public int countBinarySubstrings3(String s){

    int res = 0;
    char [] chars = s.toCharArray();
    int precount = 0, curcount = 1;
    for(int i = 1; i < chars.length; i++){
      // 记录当前组的数量
//      在遍历过程中，如果当前元素与上一个元素相等chars[i - 1] == chars[i]（注意这里索引，所以循环从i=1开始），当前分组的长度+1。
      if(chars[i - 1] == chars[i]){
        curcount++;
      }else{
        // 将连续的0,1分组后，相邻两组能满足题意的子串数量即为 Math.min(preCount, curCount)
//        反之，当前分组结束，可以更新result += Math.min(preCount, curCount);
        res+=Math.min(precount, curcount);

//        并且重置preCount = curCount; curCount = 1。
//        这里为什么curCount重置为1呢？因为当前元素已经是下一个分组的第一个元素了，下一次循环是这个分组的第二个元素，然后才会让curCount++为2。

        precount = curcount;
        curcount = 1;
      }
    }

    // 循环结束后还有最后一组要和前一组进行计数
    return res + Math.min(precount, curcount);

  }
}


