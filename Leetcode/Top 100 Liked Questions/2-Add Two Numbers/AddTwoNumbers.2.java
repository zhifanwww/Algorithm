class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int carry = 0;

        ListNode added = dummyHead;

        while (l1 != null || l2 != null) {
            int p = l1 != null ? l1.val : 0;
            int q = l2 != null ? l2.val : 0;

            int sum = (carry + p + q) % 10;
            carry = (carry + p + q) / 10;
            added.next = new ListNode(sum);

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            added = added.next;
        }
        if (carry > 0) {
            added.next = new ListNode(carry);
        }
        return dummyHead.next;

    }
}

/*
 * Second attemp: Optimized the code implementation to make it clearer.
 * 
 * Tips: Why we use a dummyhead is because we need to return the whole
 * linkedlist also make modification to the linkedlist during running
 * 
 * Note: we can't let var `added` point to `dummyHead.next` cuz `dummyHead.next`
 * is null and didn't contain any reference information
 */