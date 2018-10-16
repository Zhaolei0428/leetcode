/**
 * Question19
 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class Nineteen {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        for(int i=0;i<n;i++)
            pre = pre.next;
        ListNode behind = new ListNode(0);
        behind.next = head;
        while(pre != null){
            pre = pre.next;
            behind = behind.next;
        }
        if(behind.next == head)
            return head.next;
        behind.next = behind.next.next;
        return head;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

}
