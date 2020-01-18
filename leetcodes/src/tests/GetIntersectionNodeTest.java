package tests;

import java.util.HashMap;

public class GetIntersectionNodeTest {

//    编写一个程序，找到两个单链表相交的起始节点。
//    如果两个链表没有交点，返回 null.
//    在返回结果后，两个链表仍须保持原有的结构。
//    可假定整个链表结构中没有循环。
//    程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

    public ListNode getIntersectionNode0(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;

        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        if (headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != null){
            hashMap.put(a,1);
            a = a.next;

        }

        while (b != null){
            if (hashMap.containsKey(b)){
                return b;
            }
            b = b.next;
        }

        return null;
    }


    public static void main(String [] args){
        GetIntersectionNodeTest getIntersectionNodeTest = new GetIntersectionNodeTest();
        int [] arrA = {4,1,8,4,5};
        int [] arrB = {5,0,1,8,4,5};
        ListNode listA = new ListNode(0);
        ListNode listB = new ListNode(0);

        for (int i = 0; i < arrA.length; i ++){

            listA.val = arrA[i];
        }

        for (int j = 0; j < arrB.length; j ++){
            listB.val = arrB[j];
        }

       System.out.println(listA.val);
        System.out.println(getIntersectionNodeTest.getIntersectionNode1(listA,listB));

    }
}
