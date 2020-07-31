package cn;

public class ReverseStr_541 {

//  给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//  如果剩余字符少于 k 个，则将剩余字符全部反转。
//  如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

//  示例:
//
//  输入: s = "abcdefg", k = 2
//  输出: "bacdfeg"

//  提前算好 step = 2 * k
//  遍历的索引 i 直接用 left

  public String reverseStr1(String s, int k){

    char [] arr = s.toCharArray();
    for(int left = 0, step = 2 * k; left < arr.length; left+=step){
      int right = Math.min(arr.length - 1, left + k - 1);
      swap(arr, left, right);
    }
    return new String(arr);
  }

  private void swap(char [] arr, int left, int right){
    while(left < right){
      char swap = arr[left];
      arr[left++] = arr[right];
      arr[right--] = swap;
    }
  }

//  暴力解法，每隔k个数操作一次，奇数次翻转，偶数次跳过。
//  在翻转操作中，分两种情况，一种是长度为k，一个是不到k就到结尾了

  public String reverseStr2(String s, int k){
    int i = 0;
    char [] ch = s.toCharArray();
    while(i < ch.length){
//      偶数次
      if(i%(2 * k)==0){
        if(i+k-1 < ch.length){
          for(int j = 0; j < k/2; j ++){
            char mid = ch[i+j];
            ch[i+j] = ch[i+k-1-j];
            ch[i+k-1-j] = mid;
          }
        }else{
          for(int j = 0; j < (ch.length-i)/2; j++){
            char mid = ch[i+j];
            ch[i+j] = ch[ch.length-1-j];
            ch[ch.length-1-j] = mid;
          }
        }
      }
      i+=k;
    }

    return new String(ch);
  }

}
