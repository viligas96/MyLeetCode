public class LC101SymmetricTree {
    public static class TreeNode {
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return sym(root.left, root.right);
    }

    public boolean sym(TreeNode left, TreeNode right){
        if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left == null && right == null) return true;

        return (left.val == right.val) && sym(left.left, right.right) && sym(left.right, right.left);
    }
}
