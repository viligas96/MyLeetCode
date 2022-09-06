import java.util.HashSet;

public class LC141LLCycle {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      } }

    public boolean hasCycle(ListNode head) {
        if (head == null)return false;
        HashSet<ListNode> list = new HashSet<>();
        ListNode cur = head;
        while (cur.next !=null){
            if (list.contains(cur)){
                return true;
            }
            list.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head){
        if (head == null)return false;

        ListNode cur = head;
        while(cur.next != null){
            if (cur.next.val == Integer.MAX_VALUE){
                return true;
            }
            cur.val = Integer.MAX_VALUE;
            cur = cur.next;
        }
        return false;
    }
    public boolean hasCycle3(ListNode head){
        if (head == null)return false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            slow =slow.next;
            fast = fast.next;
            fast = fast.next;
            if (slow == fast)return true;
        }
        return false;
    }
}
