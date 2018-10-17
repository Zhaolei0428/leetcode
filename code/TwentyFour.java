/**
 * Question Swap Nodes in Pairs
 Given a linked list, swap every two adjacent nodes and return its head.

 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Note:

 Your algorithm should use only constant extra space.
 You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class TwentyFour {
    public ListNode swapPairs(ListNode head) {
        ListNode emptyHead = new ListNode(0);
        emptyHead.next = head;
        ListNode pre = emptyHead;
        while(pre != null){
            if(pre.next == null || (pre.next!=null && pre.next.next == null))
                return emptyHead.next;
            ListNode firstNode = pre.next;
            ListNode secondNode = firstNode.next;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            pre.next = secondNode;
            pre = firstNode;
        }
        return emptyHead.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}
