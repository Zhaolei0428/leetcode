public class TwentyOne {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode end = head;
        while (l1!=null && l2!=null){
            if(l1.val > l2.val){
                end.next = l2;
                l2 = l2.next;
                end = end.next;
            }
            else {
                end.next = l1;
                l1 = l1.next;
                end = end.next;
            }
        }
        end.next = l1==null? l2: l1;
        return head.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}
