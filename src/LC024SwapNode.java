import java.util.List;

public class LC024SwapNode {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur1 = head;
        ListNode cur2 = head.next;

        cur1.next = cur2.next;
        cur2.next = cur1;
        ListNode newHead = cur2;

        while (cur1.next != null && cur1.next.next != null){
            cur2 = cur1.next;
            ListNode cur3 = cur1.next.next;
            swap(cur1, cur2, cur3);
            cur1 = cur3;
        }
        return newHead;
    }

    public void swap(ListNode cur1, ListNode cur2, ListNode cur3){
        cur1.next = cur3;
        cur2.next = cur3.next;
        cur3.next = cur2;
    }

}
