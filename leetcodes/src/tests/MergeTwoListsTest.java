package tests;

public class MergeTwoListsTest{


//    Merge two sorted linked lists and return it as a new list.
//    The new list should be made by splicing together the nodes of the first two lists.

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newhead = null;
        ListNode p = null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            newhead = l1;
            p = l1;
            l1 = l1.next;
        }else{
            newhead = l2;
            p = l2;
            l2 = l2.next;
        }
        while( l1 != null  && l2 != null ){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null  ? l2 : l1;

        return newhead;

    }

    public static void main(String [] args){

        MergeTwoListsTest m = new MergeTwoListsTest();

        int values1 [] = {1,2,3};
        int values2 [] = {1,3,4};
        ListNode list1 = new ListNode(values1[0]);
        ListNode list2 = new ListNode(values2[0]);
        for (int i = 0; i < values1.length; i ++){
            list1.next = new ListNode(values1[i]);
            list1 = list1.next;
        }

        for (int i = 0; i < values2.length; i ++){
            list2.next = new ListNode(values2[i]);
            list2 = list2.next;
        }

        System.out.println(m.mergeTwoLists(list1,list2));




    }
}
