import java.util.*;
public class LC098ValidBST {
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
    public boolean isValidBST(TreeNode root) {

        return isV(root, (long)Integer.MAX_VALUE + 1, (long)Integer.MIN_VALUE - 1);
    }

    public boolean isV(TreeNode root, long max, long min){
        if (root == null || (root.left == null && root.right ==null)) return true;
        System.out.print(root.val);

        long maxval = Math.min(root.val, max);
        long minval = Math.max(root.val, min);


        if (root.left != null && root.right != null){
            return root.left.val < root.val && root.val < root.right.val && root.left.val > min && root.right.val < max
                    && isV(root.left, maxval,min) && isV(root.right, max, minval);
        }
        if (root.left == null){
            return root.right.val > root.val && root.right.val < max && isV(root.right, max, minval);
        } else{
            return root.left.val < root.val && root.left.val > min && isV(root.left,maxval,min);
        }
    }
}
