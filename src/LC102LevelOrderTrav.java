import java.util.*;
public class LC102LevelOrderTrav {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        boolean q1 = true;

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (q1) {
                addList(ret, queue1, queue2);
                q1 = false;
            }
            else {
                addList(ret, queue2, queue1);
                q1 = true;
            }
        }
        return ret;
    }

    public void addList(List<List<Integer>> ret, Queue<TreeNode> queue1, Queue<TreeNode> queue2){
        List<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode tmp = queue1.poll();
            if (tmp == null) continue;
            list.add(tmp.val);
            queue2.add(tmp.left);
            queue2.add(tmp.right);
        }
        if (list.size() != 0){
            ret.add(list);
        }
    }
}
