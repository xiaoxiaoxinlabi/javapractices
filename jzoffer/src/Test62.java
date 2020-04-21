import java.util.ArrayList;
import java.util.List;

public class Test62 {

//  圆圈中最后剩下的数字
//  0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

//  例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

//  输入: n = 5, m = 3
//  输出: 3
//  输入: n = 10, m = 17
//  输出: 2

//  这个问题是以弗拉维奥·约瑟夫命名的，他是1世纪的一名犹太历史学家。他在自己的日记中写道，他和他的40个战友被罗马军队包围在洞中。他们讨论是自杀还是被俘，最终决定自杀，并以抽签的方式决定谁杀掉谁。约瑟夫斯和另外一个人是最后两个留下的人。约瑟夫斯说服了那个人，他们将向罗马军队投降，不再自杀。约瑟夫斯把他的存活归因于运气或天意，他不知道是哪一个。 —— 【约瑟夫问题】维基百科



//  方法一：模拟链表
  public int lastRemaining1(int n, int m){

    ArrayList<Integer>  list = new ArrayList<>();

    for(int i = 0; i < n; i ++){
      list.add(n);
    }

    int idx = 0;
    while(n > 1){
      idx = (idx + m -1)%n;
      list.remove(idx);
      n--;
    }

    return list.get(0);

  }





//  方法二：数学解法
//  这么著名的约瑟夫环问题，是有数学解法的！
//  总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
  public int lastRemaining2(int n, int m){

    int ans = 0;
    for(int i = 2; i <= n; i++){
      ans = (ans + m)%i;
    }
    return ans;
  }


//  方法三：链表模拟法
//  将[0,n]依次存储在链表中
//  只要链表的长度不为1，就一直循环，如果到了第m个就remove；否则将其添加到链表尾部
//  时间复杂度为O(nm)
  public int lastRemaining3(int n , int m){

    List<Integer> list = new ArrayList();
    for(int i = 0; i < n; i ++){
      list.add(i);
    }

    while(list.size() > 1){
      for(int j = 0; j <m; j ++){
//        因为每次，都看list 头部的元素，如果不是我们要删除的那个，就把它从头部remove，再接到list的最后。如果是要删的，直接remove
        if(j!=m-1){
          list.add(list.get(0));
        }
        list.remove(0);
      }
    }

    return list.get(0);

  }




}
