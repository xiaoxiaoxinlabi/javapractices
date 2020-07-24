package en;

import java.util.HashMap;

public class NumSmallerByFrequency_1170 {

//  我们在一个非空字符串s上定义一个函数f（s），该函数计算s中最小字符的频率。例如，如果s =“ dcce”，则f（s）= 2，因为最小字符为“ c”，其频率为2。
//  现在，给定字符串数组查询和单词，返回一个整数数组，其中每个answer [i]是单词的数量，使得f（queries [i]）<f（W），其中W是单词中的单词。



  public int [] numSmallerByFrequency1(String [] queries, String [] words){

//    定义一个新数组，用于存放最终的结果
    int [] ans = new int[queries.length];

//    循环遍历数组1，并统计每个字符出现的次数
    for(int i = 0; i < queries.length; i ++){
      int q = fun(queries[i]);

//      循环遍历数组2，统计每个字符出现的次数
      int a = 0;
      for(int j = 0; j < words.length; j ++){
        int w = fun(words[j]);

//        如果数组1中的字符出现次数，小于数组2中的字符出现次数，则a 的值为数组2
        if(q < w){

          a++;
        }
      }
      ans[i] = a;
    }
    return ans;

  }


  private int fun(String str){
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < str.length(); i ++){
      map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
    }

//    按照字符顺序从小到大，找到每个字母出现的次数
    for(int i = 1; i <= 26; i++){
      char ch = (char) ('a' + i - 1);
      if(map.containsKey(ch)){
        return map.get(ch);
      }

    }
    return 0;
  }


  public int [] numSmallerByFrequency2(String [] queries, String[] words){
    int [] cnt = new int [12];
    for(int i = 0; i < words.length; i ++){
      cnt[check(words[i])]++;
    }

    for(int i = 9; i > 0; i --){
      cnt[i] +=cnt[i+1];
    }

    int n = queries.length;
    int [] ans = new int[n];
    for(int i = 0; i <n; i ++){
      ans[i] = cnt[check(queries[i])+1];
    }

    return ans;
  }

  int check(String s){
    char l = 'z';
    int cnt = 0;
    for(char c: s.toCharArray()){
      if(c == l){
        cnt++;
      }else if(c < l){
        l = c;
        cnt = 1;
      }
    }
    return cnt;
  }

}
