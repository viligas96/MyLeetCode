import java.util.ArrayList;
import java.util.*;

public class ListNode {
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


        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0){
                return null;
            }
            boolean all_null = true;
            for (ListNode node: lists){
                if (node != null) {
                    all_null = false;
                    break;
                }
            }
            if (all_null){
                return null;
            }

            ListNode new_head = new ListNode();
            ListNode cur = new_head;




            return new_head;
        }

        public static void main(String[] args){
            ListNode node = new ListNode(123);

        }

}
