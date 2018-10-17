public class TwentyThree {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 0)
            return null;
        ListNode[] listNodes = new ListNode[(lists.length+1)/2];
        for(int i = 0; i<lists.length; i+=2){
            ListNode l1 = lists[i];
            ListNode l2 = (i+1)==lists.length? null: lists[i+1];
            listNodes[i] = mergeTwoLists(l1, l2);
        }
        return mergeKLists(listNodes);
    }

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
