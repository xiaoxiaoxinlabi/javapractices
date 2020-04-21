public class Test18 {

//  删除链表的节点
//  给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
  private class  ListNode{

    ListNode node;
    ListNode next;
    int val;
  }

  public ListNode deleteNote(ListNode node, int data){

    if (node == null){
      return node;
    }
   if(node.val == data){
     return node.next;
   }
   ListNode cur = node;
   while(cur.next !=null && cur.next.val!=data){
   cur=cur.next;
   }

   if(cur.next !=null){
     cur.next = cur.next.next;
   }
   return node;
  }


  public ListNode deleteNode2(ListNode head, int val){
    if(head.val == val){
      return head.next;
    }
    ListNode pre=head, cur=head.next;
    while(cur !=null && cur.val!=val){
      pre=cur;
      cur=cur.next;
    }
    if(cur !=null){
      pre.next=cur.next;
    }
    return head;
  }


  }