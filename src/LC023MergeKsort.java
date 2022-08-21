import java.util.ArrayList;
import java.util.*;

public class LC023MergeKsort {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(){
        }
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }


    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }

        PriorityQueue<ListNode> map1 = new PriorityQueue<>(new Compare());
        for (int i = 0; i < lists.length; i++){
            while (lists[i] != null){
                map1.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode cur = map1.poll();
        ListNode head = cur;

        if (cur != null){
            while (!map1.isEmpty()){
                cur.next = map1.poll();
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    static class Compare implements Comparator<ListNode>{
        public int compare(ListNode a, ListNode b){
            return a.val - b.val;
        }
    }


    public static void main(String[] args){
        ListNode node = new ListNode(123);

    }
}
