/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pointerAhead = dummyHead;
        ListNode pointerAfter = dummyHead;
        for (int i = 0; i < n; i++) {
            pointerAfter = pointerAfter.next;
        }
        while (pointerAfter.next != null) {
            pointerAhead = pointerAhead.next;
            pointerAfter = pointerAfter.next;

        }
        pointerAhead.next = pointerAhead.next.next;

        return dummyHead.next;

    }
}

/*
 * KEY:
 * 
 * Node will be passed by reference
 * 
 * Use dummyHead to avoid edge case
 */