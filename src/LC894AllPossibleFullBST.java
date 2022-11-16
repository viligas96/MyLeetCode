import java.util.*;
public class LC894AllPossibleFullBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<TreeNode> allPossibleFBT(int n) {
            if (n== 2) return null;
            List<TreeNode> list = new ArrayList<>();
            TreeNode root = new TreeNode();





            return list;
        }
    }
}
