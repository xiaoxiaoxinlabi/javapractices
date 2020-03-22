package arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {

  public void fun1(int [] num, int target){

    HashMap<Integer, Integer> m = new HashMap<>();
    int [] res = new int [2];

    for (int i = 0; i < num.length; i ++){
      if (m.containsKey(target - num[i])){
        res[0] = i;
        res[1] = m.get(target - num[i]);
      }else{
        m.put(num[i],i);
      }
    }
  }

  public int  fun2(int n){
    int sum = 0;

    if (n <=1){
      return n;
    }

    int jc = 1;
    for (int i = 1; i <= n; i ++){
      jc = jc * i;
      sum+=jc;

    }
    return sum;
  }

  public int fun3(int n){

    if (n <=1){
      return n;
    }
    return n * fun3(n-1);

  }

public int fun4(int n){
    int sum = 0;
    for(int i = 1; i <=n; i ++){
      sum+=fun3(i);
    }
    return sum;
}


public int fun5(int [] num, int target){

    int lo = 0;
    int hi = num.length - 1;

    while(lo <= hi){
      int mid = (lo + hi) / 2;

      if (target > num[mid]){
        lo = mid + 1;
      } if (target < num[mid]){
        hi = mid - 1;
      }else{
        return mid;
      }
    }
    return -1;
}

//穷举法
public int fun6(int a, int b){
//    程序思想:找到两个数的最小数，然后依次递减如果都能被两个数整除，则找到的第一个数则是最大公约数
    int min = Math.min(a,b);
    int gy = 0;
    for (int i = min; i >=1; i --){
      if(a % i ==0 && b % i ==0){
        gy= i;
        break;
      };
    }

    return gy;

}

//辗转相除法:欧几里得算法(递归式)
//原理：gcd(a, b) = gcd(b, a mod b)
  public int fun7(int a, int b){
   a = Math.abs(a);
   b = Math.abs(b);
    // 先求余数，假定第一个数较大；如果第二个较大，在第二轮调用时会颠倒过来
   int re = a % b;
    // 如果为 0，则直接得出
   if (re == 0){
     return b;
   }
    // 递归调用
   return fun7(b, re);

  }
//  辗转相除法:欧几里得算法(非递归式)
  public int fun8(int a, int b){
    a = Math.abs(a);
    b = Math.abs(b);
//    假定第一个数较大；如果第二个较大，在第二轮会颠倒过来
    // 如果第二个数为 0，则第一个数就是最大公约数
    while(b != 0){
//      求余
      int re = a % b;
//      交换
      a = b;
      b = re;
    }
    return a;
  }

  public int fun9(int a, int b){

    return a * b / fun8(a,b);
  }

//  最长的没有重复的子字符串
  public int fun23(String s){

    if (s == null || s.length() < 1){
      return 0;
    }
//  记录字符上次出现的位置
    HashMap<Character,Integer> m = new HashMap<>();
    int max = 0;
//  最近出现重复字符的位置
    int pre = -1;
    for (int i = 0; i < s.length() ; i ++){
      Character ch = s.charAt(i);
      Integer index = m.get(ch);
      if(index !=null){
        pre = Math.max(pre,index);

      }
      max = Math.max(max, i - pre);
      m.put(ch,i);

    }

    return max;
  }

  //  最长的没有重复的子字符串
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int res = 0;
    int end=0,start=0;
    Set<Character> set=new HashSet<>();
    while(start<n && end<n){
      if(set.contains(s.charAt(end))){
        set.remove(s.charAt(start++));
      }else{
        set.add(s.charAt(end++));
        res=Math.max(res,end-start);
      }

    }
    return res;
  }

  //  最长的没有重复的子字符串
  public int getMaxLength(String str) {

    if(str.isEmpty()){return 0;}

    int maxLength = 0;
    int preLength = 0;
    int curLenght = 0;
    int [] pointValue = new int[26];

    for (int i =0;i<str.length();i++){
      pointValue[i]=-1;
    }

    for (int i=0;i<str.length();i++){
      int index = str.charAt(i) - 'a';
      int curVaule = i - pointValue[index]; // 当前位置距离上次出现的差值
      if(pointValue[index]<0||curVaule>preLength) {
        curLenght = preLength+1;
      }else {
        curLenght = curVaule;
      }
      pointValue[index] = i;
      if(curLenght>maxLength) {// 纪录最大值
        maxLength = curLenght;
      }
      preLength = curLenght;
    }
    return maxLength;
  }

  public int lengthOfLongestSubstring1(String s) {
    int n = s.length();
    int res = 0;
    int end=0,start=0;
    Map<Character,Integer> map=new HashMap<>();
    for(;start<n && end<n;end++){
      if(map.containsKey(s.charAt(end))){
        start=Math.max(map.get(s.charAt(end)),start);//从有重复的下一个位置继续找
      }
      map.put(s.charAt(end),end+1);//map每次更新
      res=Math.max(res,end-start+1);//结果每次更新
    }
    return res;
  }


//  最长回文子字符串
  public String fun10(String s){

    if (s.length() <=1){
      return s;
    }
    for (int i = s.length(); i>0; i--){//子串长度

      for(int j = 0; j <= s.length() -i; j++){
        //子串位置
        String str = s.substring(j, i+j);
        int count = 0;//计数，用来判断是否对称
        for(int k = 0; k < str.length()/2; k++){//左右对称判断
          if(str.charAt(k) ==str.charAt(str.length() - k - 1)){
            count ++;
          }
        }if(count ==str.length()/2){
          return str;
        }
      }
    }
    return "";//表示字符串中无回文子串

  }

  public ArrayList<String> permutation(String str){

    if(str == null || str.length()==0){
      return null;
    }

//    将字符串转化为数组
    char [] ch = str.toCharArray();
    ArrayList<String>  res = new ArrayList<>();
    allper(ch,0, res);
//    按照字典排序
    Collections.sort(res);
    return res;
  }

  public void  allper( char [] chars, int i ,ArrayList<String>res){

   if(chars == null){
     return ;
   }
//   如果i指向了最后一个字符
   if (i == chars.length - 1){
     if(res.contains(String.valueOf(chars))){
       return;
     }
     res.add(String.valueOf(chars));

//     当i不指向最后一个时，i代表我们做排列操作的字符串的第一个字符
   }else{

     for (int j = i; j < chars.length; j ++){
//       将第一个字符与最后一个字符交换
       char tmp = chars[i];
       chars[i] = chars[j];
       chars[j] = tmp;
       //对后面的字符进行全排列
       allper(chars, i+1, res);
       //再将之前交换的字符交换回来，以便于第一个字符再与其他字符进行交换
       char tmp1 = chars[j];
       chars[j] = chars[i];
       chars[i] = tmp1;

     }

   }

  }

  public int Sum_Solution(int n) {
    int sum = n;
    boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
    return sum;
  }



  public static void main(String [] args){
    Test t = new Test();
    int sum = 0;
   String s = "abcbadaab";
   System.out.println(t.Sum_Solution(4));
  }

}
