import java.util.*;
public class LC958CheckBSTCompleteness {
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

    public boolean isCompleteTree(TreeNode root) {
          if (root.left == null && root.right == null)return true;

        Queue<Integer> queue1 = new LinkedList<>();
          Queue<TreeNode> queue2 = new LinkedList<>();


          TreeNode curNode = root;

          queue1.add(1);
          queue2.add(root);
          int cur = 1;

          while (queue2.size() != 0){
              if (cur != queue1.poll()) return false;
              curNode = queue2.poll();

              if (curNode.left != null){
                  queue2.add(curNode.left);
                  queue1.add(cur*2);
              }
              if (curNode.right != null){
                  queue2.add(curNode.right);
                  queue1.add(cur*2 + 1);
              }
              cur++;
          }
          return true;
    }
    }
}
