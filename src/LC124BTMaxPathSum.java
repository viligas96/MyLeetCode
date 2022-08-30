public class LC124BTMaxPathSum {
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
    class Solution {
        public int maxPathSum(TreeNode root) {
            if (root == null) return -1000;

            if (root.left == null && root.right == null){
                return root.val;
            }
            if (root.left == null){
                return Math.max(root.right.val, root.right.val +root.val);
            }
            if (root.right == null){
                return Math.max(root.left.val, root.left.val + root.val);
            }

            int notPass = Math.max(maxPathSum(root.left), maxPathSum(root.right));

            int passRoot = Math.max(linkedSum(root.left),0) + Math.max(linkedSum(root.right),0) + root.val;


            return Math.max(passRoot, notPass);
        }

        public int linkedSum(TreeNode cur){
            if (cur == null)return 0;

            int contain = cur.val;
            int child = Math.max(linkedSum(cur.left) + cur.val, linkedSum(cur.right) + cur.val);

            return Math.max(contain, child);
        }
  }
}
