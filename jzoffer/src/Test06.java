import java.util.LinkedList;
import java.util.Stack;

public class Test06 {

//  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

//  输入：head = [1,3,2]
//  输出：[2,3,1]

  private class ListNode{

    ListNode node;
    int val;
    ListNode next;




  }


//  辅助栈法
//  链表特点： 只能从前至后访问每个节点。
//  题目要求： 倒序输出节点值。
//  这种 先入后出 的需求可以借助 栈 来实现。
//  入栈： 遍历链表，将各节点值 push 入栈。（Python​ 使用 append() 方法，​Java​借助 LinkedList 的addLast()方法）。
//  出栈： 将各节点值 pop 出栈，存储于数组并返回。（Python​ 直接返回 stack 的倒序列表，Java ​新建一个数组，通过 popLast() 方法将各元素存入数组，实现倒序输出）。

  public int[] reversePrint1(ListNode head) {

    LinkedList <Integer>  stack = new LinkedList<Integer>();
    while(head !=null){
      stack.addLast(head.val);
      head = head.next;
    }

    int [] res = new int[stack.size()];
    for(int i = 0; i < res.length; i ++){
      res[i] = stack.removeLast();
    }

    return res;

  }

  public int[] reversePrint2(ListNode head){
    Stack<ListNode> stack = new Stack<ListNode>();
    ListNode temp = head;
    while(temp !=null){
      stack.push(temp);
      temp = temp.next;
    }

    int size = stack.size();
    int [] prints = new int[size];
    for(int i = 0; i < size; i ++){
      prints[i] = stack.pop() .val;
    }
    return prints;
  }

//  链表翻转



}
