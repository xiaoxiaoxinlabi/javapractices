package tests;

public class DeleteListNodeDuplicatesTest {

    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return head;
        }else{
            head.next = deleteDuplicates(head.next);
            if(head.next != null && head.next.val == head.val){
                head = head.next;
            }
        }
        return head;


    }

    public ListNode deleteDuplicates1(ListNode head){
        ListNode cur = head;
        while(cur != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head){
        if (head == null)return null;
        ListNode current = head;
        while(current.next != null){
            if (current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }

        return head;
    }


    public static void main(String [] args){
        DeleteListNodeDuplicatesTest deleteListNodeDuplicatesTest = new DeleteListNodeDuplicatesTest();
        int values [] = {1,1,2};
        ListNode list = new ListNode(values[0]);
        for(int i = 0; i < values.length; i ++){
            list.val = values[i];
        }

        System.out.println(deleteListNodeDuplicatesTest.deleteDuplicates(list));
    }
}
