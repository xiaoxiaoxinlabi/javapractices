package linkedlist;

public class SingleLinked {

//  创建一个节点
  private class Node{

//    数据域
    private Object data;
//    下一个节点引用
    private Node next;


    public Node(Object data, Node next){
      this.data = data;
      this.next = next;
    }


    public Node(Object data){
      this.data = data;
    }
  }
  private Node head;
  private int size;

  public SingleLinked(){

  }

//  获取链表元素的个数

  public int getSize(){
    return this.size;
  }

//  判断链表是否为空

  public boolean isEmpty(){
    return this.size == 0;
  }


//  表头插入节点
  public void addHead(Object data){
//    创建新节点
    Node newNode = new Node(data);

//    如果链表为空，则将新节点作为表头head
    if(this.size == 0){
      head = newNode;
    }else{

//      创建新节点，指向旧的表头head
      newNode.next = head;
//      新添加的节点作为新的表头
      head = newNode;
    }

    size++;

  }

//  表未插入节点

  public void addTail(Object data){
    Node cur = head;
    while(cur.next !=null){
      cur=cur.next;
    }
    Node newNode = new Node(data);
    cur.next = newNode;
    size ++;
  }

//  在指定位置插入节点

  public void addByIndex(int index, Object data){
//    指定位置不合理退出
    if (index < 0 || index > size){
      return;
    }
    Node newNode = new Node(data);
//    表头插入
    if(index == 0){
      newNode.next =head;
      head = newNode;
    }else{
      Node cur = head;
      Node pre = head;
      int pos = 0;
      while(pos !=index){
        pre = cur;
        cur = cur.next;
        pos++;
      }
      pre.next = newNode;
      newNode.next = cur;
      size++;
    }
  }

//  表头删除

  public void removeHead(){

    if(size > 0){
//      当前头节点指向头结点的下一个节点
      head = head.next;
      size --;
    }else{
      return;
    }
  }

//  表尾删除

  public void removeTail(){
//    如果只有一个元素，则删除头结点
    if(size == 1){
      head = head.next;
    }

//    记录当前节点cur, 以及要删除节点的前一个节点pre
    Node cur = head;
    Node pre = head;
//    找到尾部节点，（cur.next = null）
    while(cur.next !=null){
      pre= cur;
      cur=cur.next;
    }
    pre.next = cur.next;
    size--;


  }

//  删除链表指定位置的节点

  public void removeByIndex(int index){
//    如果索引超出size则返回
    if(index >= size){
      return;
    }

//    如果index指向表头，则删除表头节点
    if(index == 0){
      head = head.next;
    }else{

      Node cur = head;
      Node pre = head;
      int pos = 0;
//      找到要删除的位置
      while(pos != index){
        pre = cur;
        cur = cur.next;
        pos++;
      }

//      删除节点的前一个节点的next指向当前节点的next
      pre.next = cur.next;

    }
    size --;
  }

//  删除指定元素

  public void removeBydata(Object data) {

    Node cur = head;
    Node pre = head;

//    查找要删除的元素
    while (cur.data != data) {
//      找到链表尾还没有找到，则退出
      if (cur.next == null) {
        break;
      }

      pre = cur;
      cur = cur.next;

    }
//    如果找到则删除
    if (cur.data == data) {
      pre.next = cur.next;
    }

    size--;
  }

//  根据索引位置查找节点

  public void findByIndex(int index){
   Node cur = head;
   Node pre = head;
   int pos = 0;
//   找到要查找的索引位置
   while(pos !=index){
     if(cur.next == null){
       System.out.println("没找到");
       break;
     }
     pre = cur;
     cur = cur.next;
     pos++;
   }
   if(pos == index){
     System.out.println(cur.data);

   }
  }

//  根据数据查找节点

  public void findBydata(Object data){
    Node cur = head;
    Node pre = head;

//    当前节点的值不等于查找的值则继续往下查找
    while(cur.data !=data){
//      如果到链表尾则退出
      if(cur.next == null){
        System.out.println("not found");
        return;
      }
      pre = cur;
      cur = cur.next;

    }
//    如果找到则输出
    if (cur.data == data){
      System.out.println(cur.data);
    }
  }

//  遍历链表

  public void displayAllNode(){
    Node cur = head;

    while(cur!= null){
      System.out.println(cur.data);
      cur = cur.next;
    }
  }

//  链表翻转

  public Node reverseLinked(Node node){
//    Initialize three pointers prev as NULL, curr as head and next as NULL.

    Node pre = null;
    Node cur = node;
    Node next = null;
//    Iterate trough the linked list. In loop, do following.
    while(cur !=null){
      // Before changing next of current,
     // store next node(先保存next)
      next = cur.next;

      // Now change next of current
// This is where actual reversing happens（当前的next指向pre）
      cur.next = pre;

      // Move prev and curr one step forward
      pre = cur;
      cur = next;
    }
    node = pre;
    return node;
  }


  public Node reverseLinked1(Node node){
    //定义当前节点指针，以及前一个节点指针
    Node pre = null;
    Node cur = node;
//每次循环，都将当前节点指向它的前面的节点，然后当前节点和前节点后移
    while(cur !=null){

//      现将当前节点的下一个节点暂时保存
      Node nexttmp = cur.next;
//      将当前节点指向它前面的节点
      cur.next = pre;
//      前面的指针后移
      pre = cur;
//      当前指针后移
      cur = nexttmp;
    }
    return pre;

  }

//  两个有序链表合并

  public  Node mergeTwoList(Node l1, Node l2){

    if(l1 == null){
      return l2;
    }
    if (l2 == null){
      return l1;
    }
    Node head =null;
    Node res = head;
    while(l1 !=null && l2!=null){
//      如果l1比l2小则将l1作为新链接的头节点
      if((int)l1.data <= (int)l2.data){
        head .next = l1;
        l1 = l1.next;
      }else{
        head.next = l2;
        l2 = l2.next;
      }
      head = head.next;
    }
    if(l1 == null){
      head.next = l2;
    }
    if(l2 == null){
      head.next = l1;
    }
    return res;

  }

//  合并两个有序链表--递归

  public Node mergetwoLists(Node l1, Node l2){
    if (l1 == null){
      return l2;
    }
    if (l2 == null){
      return l1;
    }
    Node head = null;
    while(l1 !=null && l2 !=null){
      if((int)l1.data > (int)l2.data){
        head = l2;
        head.next = mergetwoLists(l1,l2.next);

      }else{
        head = l1;
        head.next = mergetwoLists(l2, l1.next);

      }
    }
    return head;
  }
//  两个单链表的相交点
//  链表分有环链表和无环链表，如果两个链表存在相交，则只有两种可能，两个链表都无环或者都有环。

public Node getIntersectionNode(Node nodeA, Node nodeB){
    int lenA = 0, lenB = 0;
  // 1.让二者分别走到链表末尾，测出各自长度
    Node pA = nodeA;
    Node pB = nodeB;
    while(pA!=null){
      pA = pA.next;
      ++lenA;
    }
    while(pB!=null){
      pB=pB.next;
      ++lenB;
    }

    pA=nodeA;
    pB = nodeB;
// 2.得到分别链长的差值，让长的先走这个差值
    int diff = lenA - lenB;
    if (diff > 0){
      int step = diff;
      while(step > 0){
        pA = pA.next;
        --step;
      }
    }else if(diff < 0){
      int step = diff;
      while(step < 0){
        pB = pB.next;
        ++step;
      }
    }
  // 3.两指针往前走，相遇即为所求
    while(pA!=pB){
      pA = pA.next;
      pB = pB.next;
    }
    return pA;
}

public Node getIntersectionNode1(Node nodeA, Node nodeB){

//  定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
//  两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
    if(nodeA == null || nodeB == null){
      return null;
    }
    Node pA = nodeA, pB = nodeB;
  // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
    while(pA !=pB){
      pA=pA==null ? nodeB:pA.next;
      pB=pB==null?nodeA:pB.next;
    }
    return pA;
}

//  链表是否有环

  public boolean hascycle(Node head){

    if (head == null){
      return false;
    }
//    设置快慢指针，当两个指针相遇时则说明有环
    Node slow = head, fast = head;
    while(fast !=null && fast.next !=null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        return true;
      }
    }
    return false;

  }
}


