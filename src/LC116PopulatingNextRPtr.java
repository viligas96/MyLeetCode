public class LC116PopulatingNextRPtr {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    class Solution {
        public Node connect(Node root) {
            if (root == null)return null;
            help(root);
            return root;
        }

        public void help(Node cur){
            if (cur == null) return;

            Node L = cur.left;
            Node R = cur.right;
            help(L);
            help(R);
            while (L != null|| R != null){
                L.next = R;
                L = L.right;
                R = R.left;
            }
        }
    }
}
