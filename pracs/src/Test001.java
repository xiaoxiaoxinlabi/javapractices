import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test001 {

//  统计文件中每个字符出现的次数


  public static void stat(File file) throws IOException {


    int max = 0;
    //    读取文件
    BufferedReader bf = new BufferedReader(new FileReader(file));
//    BufferedReader bfs = new BufferedReader(new FileReader(new File("filename")));
    String value = null;
    String newValue = "";

//    文件内容转换为字符串
    while ((value = bf.readLine()) != null) {
      newValue = newValue + value;

    }
    char[] ch = newValue.toCharArray();
    HashMap<Character, Integer> m = new HashMap<>();
    for (int i = 0; i < ch.length; i++) {
      if (m.containsKey(ch[i])) {
        m.put(ch[i], m.get(ch[i]) + 1);
      } else {
        m.put(ch[i], 1);
      }
    }

    for (Map.Entry<Character, Integer> re : m.entrySet()) {

      System.out.println("字符：" + re.getKey() + "出现的次数" + re.getValue());
      max = Math.max(max, re.getValue());


    }

  }

  //字符串的全排列---全排列数组p位置后面的字符数组
  private static void permutation(char[] arr, int p) {
    //当p位置指向字符串最后一个位置时，输出当前排列的字符数组
    if (p == arr.length - 1) {
      System.out.println(String.valueOf(arr));
      return;
    }
    //固定p位置的字符，p后面的字符依次和p交换
    for (int i = p; i < arr.length; i++) {
      //将第一个字符与后面的字符交换
      swap(arr, i, p);
      //对p位置后面的字符进行全排列，递归
      permutation(arr, p + 1);
      //再将之前交换的字符交换回来，以便第一个字符再与其他字符交换
      swap(arr, p, i);
    }
  }

  //数组字符交换函数
  private static void swap(char[] charArray, int i, int j) {
    char temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
  }


//  public static ArrayList<String> permutation(String str) {
//
//    if (str == null || str.length() == 0) {
//      return null;
//    }
//
////    将字符串转化为数组
//    char[] ch = str.toCharArray();
//    ArrayList<String> res = new ArrayList<>();
//    allper(ch, 0, res);
////    按照字典排序
//    Collections.sort(res);
//    return res;
//  }
//
//  public static void allper(char[] chars, int i, ArrayList<String> res) {
//
//    if (chars == null) {
//      return;
//    }
////   如果i指向了最后一个字符
//    if (i == chars.length - 1) {
//      if (res.contains(String.valueOf(chars))) {
//        return;
//      }
//      res.add(String.valueOf(chars));
//
////     当i不指向最后一个时，i代表我们做排列操作的字符串的第一个字符
//    } else {
//
//      for (int j = i; j < chars.length; j++) {
////       将第一个字符与最后一个字符交换
//        char tmp = chars[i];
//        chars[i] = chars[j];
//        chars[j] = tmp;
//        //对后面的字符进行全排列
//        allper(chars, i + 1, res);
//        //再将之前交换的字符交换回来，以便于第一个字符再与其他字符进行交换
//        char tmp1 = chars[j];
//        chars[j] = chars[i];
//        chars[i] = tmp1;
//
//      }
//
//    }
//
//  }


//  public static void cfsz(int[] a) {
//    int count = 0;
//    for (int j = 0; j < a.length; j++) {
//      for (int k = j + 1; k < a.length; k++) {
//        if (a[j] == a[k]) {
//          count++;
//        }
//      }
//      if (count == 1){
//        System.out.println("重复元素 : " + a[j]);
//      }
//
//      count = 0;
//    }
//  }

//  public static void cfsz2(int[] a) {
//    //循环数组，添加到map
//    //如果map中没有这个数(key)，put(值,1)
//    //有的话加一
//    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//    for (int i = 0; i < a.length; i++) {
//      if (map.containsKey(a[i])) {
//        int val = map.get(a[i]);
//        map.put(a[i], val + 1);
//      } else {
//        map.put(a[i], 1);
//      }
//    }
//
//    System.out.println(map);
//  }

//  public static int Sum_Solution(int n) {
//    int sum = n;
//    boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
//    return sum;
//  }

//  public static int sum(int n) {
//    if (n == 1) {
//      return 1;
//    }
//    return n + sum(n - 1);
//  }


  //  利用hashtable的原理--区分大小写
//  hashtable: 是根据关键码值(Key value)而直接进行访问的数据结构

  public static char fun61(String str) {
    if (str == null || str.length() < 1) {
      return 0;
    }
    char[] strArr = str.toCharArray();
    int[] hashTable = new int[256];
//    给hashtable复制默认都为0
    for (int i = 0; i < 256; i++) {
      hashTable[i] = 0;

    }
//将字符存储在hashkey中（key: 字符，value： 出现次数）
    char[] hashKey = strArr;
    for (int i = 0; i < strArr.length; i++) {
      int tmp = hashKey[i];
      hashTable[tmp]++;
    }

    for (int i = 0; i < strArr.length; i++) {
      if (hashTable[hashKey[i]] == 1) {
        return strArr[i];
      }
    }
    return '0';

  }

  //  不区分大小写
  public static char fun6101(String str) {
    if (str == null || str.length() < 1) {
      return '0';
    }
    Map<Character, Integer> m = new HashMap<>();
//    区分大小写
    str = str.toLowerCase();
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (m.containsKey(str.charAt(i))) {
        m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
      } else {
        m.put(str.charAt(i), 1);
      }
    }

    for (int i = 0; i < str.length(); i++) {
      if (m.get(str.charAt(i)) == 1) {
        return str.charAt(i);
      }
    }
    return '0';
  }

  public static void fun63(String str) {

    String newStr = str.replaceAll("[^\\d]", "");
    ArrayList arrayList = new ArrayList();
    HashSet s = new HashSet();
    for (int i = 0; i < newStr.length(); i++) {

      if (Character.isDigit(newStr.charAt(i)) && s.add(newStr.charAt(i))) {

        arrayList.add(newStr.charAt(i));

      }

    }

//    升序排列
//    Collections.sort(arrayList);
//    降序排列
    Collections.sort(arrayList, Comparator.reverseOrder());

    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }

  }

  public static void  fun64(int [] arr){

    int j = 0;
    for(int i = 1; i < arr.length; i ++){
      if(arr[i] !=arr[j]){
        j++;
        arr[j] = arr[i];
      }
    }
    System.out.println( j+1);

//    for (int k = 0; k <=j; k ++){
//      System.out.println(arr[k]);
//    }
  }

  public void moveZeroes(int[] nums) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      //将不等于 0 的元素往前移动，并同时移动 i 指针
      if (nums[j] != 0) {
        nums[i] = nums[j];
        i++;
      }
    }
    //i 之前的元素移动好的【不为 0 的元素】
    //p 指针从 i 开始，将 i 后面的元素都变成 0
    for (int p = i; p < nums.length; p++) {
      nums[p] = 0;
    }
  }

//  质因数就是能够被该正整数整除的质数（除它本身和1外）
//  每个非素数（合数）都可以写成几个素数（也可称为质数）相乘的形式，这几个素数就都叫做这个合数的质因数。
//  比如，6可以被分解为2x3，而24可以被分解为2x2x2x3。
  public static void fun41(int n){

    StringBuilder sb = new StringBuilder();

    //如果是素数，则直接输入
   if(isPrimeInt(n)){
     sb.append(n);
   }else{
     // 当读到的不是素数时，输出它的质因数分解式：n=axbxcxd
     while(n!=1){
       for(int j = 2; j <=n; j ++){
//         对最后一个进行特殊处理
         if(j==n){
           n = 1;
           sb.append(j);
           break;

         }
         // j为当前n的第一个因数时，一定是n的质因数
         if(n % j == 0){
           n = n / j;
           sb.append(j).append("x");
           break;
         }
       }
     }

     System.out.println(sb.toString());

   }

  }

  public static boolean isPrimeInt(int n){
    if (n < 2){
      return  false;
    }
    for(int i = 2; i*i <=n; i ++){
      if(n%i == 0){
        return false;
      }

    }
    return true;
  }

  public static void fun12(int n) {

    int k = 2;  //定义一个最小的质因数
    System.out.print(n + "=");
    while (k <= n) {    //进行循环判断
      if (k == n) {
        System.out.print(n);
        break;
      } else if (n % k == 0) {
        System.out.print(k + "*");
        n = n / k;
      } else {
        k++;
      }
    }
  }




  public static void fun65(int n){

    int sum = 0;
    int max = 0;
    for(int i = 2; i <=n; i ++){
      if(n % i == 0){

        System.out.println(n +"="+i + "*"+ n / i);
        sum = i + n/i;
        System.out.println(sum);
        max = Math.max(sum, max );
        continue;

      }

    }
    System.out.println(max);

  }
//通过滑动窗口方法，
//  如果s[end] 在索引end 的范围s[start, end) 中有重复，重复的这个索引为 end`,
//  则跳过[start, end`] 范围内的所有元素，
//  直接令 start = end` + 1
  public static void  lenOfLongestSubstring(String s){
    int n = s.length(), max = 0;
    //map记录当前字符串的索引
    Map<Character, Integer> m = new HashMap<>();
    // try to extend the range [start, end]
    int start = 0,end = 0;
    for(; end < n; end ++){
      if (m.containsKey(s.charAt(end))){
        start = Math.max(m.get(s.charAt(end)), start);
      }
      max = Math.max(max, end - start + 1);
      m.put(s.charAt(end), end+1);


    }

    System.out.println(s.substring(start, start +max));


  }

  public static void  fun23(String s){

    if (s == null || s.length() < 1){
      return ;
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

    System.out.println(max);

  }



  public static void fun231(String s){
    int len = s.length();
    Set<Character> set = new HashSet<>();
    int max = 0, start = 0, end = 0;
    while(start < len && end < len){
      if(!set.contains(s.charAt(end))){
        set.add(s.charAt(end));
        end ++;
        max = Math.max(max, end - start);


      }else{
        set.remove(s.charAt(start));
        start++;

      }

    }
    System.out.println(s.substring(start, start +max));

  }



  public static void main(String[] args){
//      permutation("abc".toCharArray(),0);
//    ArrayList<String>  arr = permutation("abc");
//
//    for(int i = 0; i < arr.size(); i ++){
//      System.out.println(arr.get(i));
//    }

    int [] a = {1,2,2,4,4,4,4};
//    System.out.println(Sum_Solution(3));

//    fun63("&(*(10231208sd");
//    fun65(12);

//    System.out.println(lenOfLongestSubstring("abcabcbb"));
    lenOfLongestSubstring("abdevbac");
    permutation("abc".toCharArray(),0);

 }


}









