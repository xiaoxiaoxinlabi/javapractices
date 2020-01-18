package tests;

public class HasCycleTest {
//    链表中的节点，data代表节点的值，next是指向下一个节点的引用
//    给定一个链表，判断链表中是否有环。
//    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

    public boolean hasCycle1(ListNode head){

        if (null == head) {
            return false;
        }
        if (head == head.next){
            return true;
        }
        ListNode n = head.next;
        head.next = head;


        return hasCycle1(n);

    }


    public boolean hasCycle2(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle3(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
            return false;
        }else{
            ListNode slow = head.next;
            ListNode fast  = head.next.next;

            while (slow != fast){
                if (fast.next == null || fast.next.next == null){
                    return false;
                }else {
                    fast = fast.next.next;
                }
                if(slow.next == null){
                    return false;
                }else{
                    slow = slow.next;
                }
            }
            return true;
        }

    }




    public static void main (String [] args){
        HasCycleTest hasCycleTest = new HasCycleTest();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(hasCycleTest.hasCycle1(listNode));




    }
}
