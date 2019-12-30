class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        _addTwoNumbers(l1, l2, result);
        return result;
    }

    private void _addTwoNumbers(ListNode l1, ListNode l2, ListNode result) {
        int v1 = l1.val;
        int v2 = l2.val;
        if (result.next == null) {
            result.next = new ListNode(0);
        }
        result = result.next;

        int v3 = (v1 + v2 + result.val) % 10;
        int carry = (v1 + v2 + result.val) / 10;
        result.val = v3;
        if (carry != 0) {
            result.next = new ListNode(carry);
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
        } else if (l1.next == null && l2.next == null) {
            return;
        } else {
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
        }
        _addTwoNumbers(l1.next, l2.next, result);
    }
}

/*
Recap:

Two linked lists representing numbers in reverse order:
    - Add corresponding positions one by one
    - Fill null position with 0
    - Calculation has 3 parts: val of l1, val of l2 and carry

Tips while implementing:
    - Calculate next carry after adding val of l1, val of l2 and carry
    - Pass l1.next, l2.next and result itself to next recursion can avoid judge and delete last digit of result if it's 0
*/