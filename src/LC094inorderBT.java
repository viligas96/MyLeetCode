import java.util.*;

public class LC094inorderBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
     }
}
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();

        recur(ret, root);

        return ret;
    }

    public void recur(List<Integer> ret, TreeNode cur){
        if (cur == null) return;

        recur(ret, cur.left);
        ret.add(cur.val);
        recur(ret, cur.right);
    }
}
