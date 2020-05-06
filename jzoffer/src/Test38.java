import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Test38 {
//  输入一个字符串，打印出该字符串中字符的所有排列。

//  你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//  输入：s = "abc"
//  输出：["abc","acb","bac","bca","cab","cba"]

  List<String> res = new LinkedList();
  char [] c;
  public String  permutation(String s){
    c = s.toCharArray();

    dfs(0);
//    return res.toArray(new String[res.size()]);
    return res.toString();
  }

  void dfs(int x){
//    终止条件： 当 x = len(c) - 1x=len(c)−1 时，代表所有位已固定（最后一位只有 11 种情况），则将当前组合 c 转化为字符串并加入 res，并返回；

    if(x == c.length - 1){
      res.add(String.valueOf(c));
      return;
    }

    HashSet<Character> set = new HashSet<>();
    for(int i = x; i < c.length; i ++){
      // 重复，因此剪枝
      if(set.contains(c[i])){
        continue;
      }
      set.add(c[i]);
      // 交换，将 c[i] 固定在第 x 位
      //交换元素，这里很是巧妙，当在第二层dfs(1),x = 1,那么i = 1或者 2， 要不是交换1和1，要不交换1和2
      swap(i, x);
      // 开启固定第 x + 1 位字符
      //进入下一层递归
      dfs(x+1);
      // 恢复交换
//      /返回时交换回来，这样保证到达第1层的时候，一直都是abc。这里捋顺一下，开始一直都是abc，那么第一位置总共就3个位置
//      ，因为固定第 x 位时，实现方法是每轮将 c[x] 和 c[i] 交换。如果每轮交换完不恢复的话，从第二轮开始就不是 c[x] 和 c[i] 交换了，而是例如： c[i] 和 c[i+1] 交换 此类.... 这样可能某轮又把 c[x] 交换回原位置了，导致漏掉某些解。建议你可以试试删除掉恢复交换后运行一下试试啊
      swap(i, x);
    }
  }

  void swap(int a, int b){
    char tmp = c[a];
    c[a] = c[b];
    c[b] = tmp;
  }


  public static void main(String [] args){
    System.out.println(new Test38().permutation("abc"));
  }




}
