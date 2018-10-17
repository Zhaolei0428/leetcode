/**
 * Question Reverse Nodes in k-Group
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:

 Only constant extra memory is allowed.
 You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class TwentyFive {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Count the length of the list
        if (head == null || k < 2) {
            return head;
        }
        int len = 0;
        ListNode ptr0 = head;
        while (ptr0 != null) {
            ptr0 = ptr0.next;
            len++;
        }
        if (len < k) {
            return head;
        }

        // Start reversing the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ptr0 = dummy;
        ListNode ptr1 = dummy.next;
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) { // k nodes only have k-1 links to reverse
                ListNode tmp = ptr1.next;
                ptr1.next = tmp.next;
                tmp.next = ptr0.next;
                ptr0.next = tmp;
            }
            ptr0 = ptr1;
            ptr1 = ptr0.next;
        }
        return dummy.next;
    }


    public static void main(String[] args){
        TwentyFive twentyFive =new TwentyFive();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(4);
        third.next = forth;
        ListNode five = new ListNode(5);
        forth.next = five;
        System.out.println(twentyFive.reverseKGroup(head, 3));
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}