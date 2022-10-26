import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC206ReversedLL {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        } }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur.next != null) {
            stack.add(cur);
            cur = cur.next;
        }
        ListNode newHead = stack.pop();
        cur = newHead;
        while(!stack.empty()){
            cur.next = stack.pop();
            cur = cur.next;
        }
        return newHead;
    }
}
