public class TT01 {

//  翻转单链表

  private class Node{

    Node head;
    Node next;
    int val;
  }


  public  static void fun1(Node node){

    Node pre=null;
    Node cur =node;
    Node next=null;

    while(cur !=null){

//    先将当前节点的下一个节点保存
      next = cur.next;
//    将当前节点指向它的前面的节点
      cur.next = pre;

//     前面的指针后移
      pre=cur;
//      当前指针后移
      cur=next;

    }
    node = pre;

  }


  public static void fun2(Node node){

    Node pre = null;
    Node cur = node;

    while(cur !=null){

      Node temp = cur.next;
      cur.next = pre;

      pre = cur;
      cur = temp;
    }
  }



}
