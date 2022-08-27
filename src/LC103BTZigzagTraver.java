import java.util.*;

public class LC103BTZigzagTraver {
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

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);

        recur(0, stack1, stack2);
        return ret;
    }

    public void recur(int level, Stack<TreeNode> stack1, Stack<TreeNode> stack2){
        while (!stack1.empty() || !stack2.empty()){
            TreeNode node = stack1.pop();
            if (level == ret.size()) ret.add(new ArrayList<Integer>());
            ret.get(level).add(node.val);
            if (level % 2 == 0){
                if (node.left != null) stack2.add(node.left);
                if (node.right != null) stack2.add(node.right);
            } else{
                if (node.right != null) stack2.add(node.right);
                if (node.left != null) stack2.add(node.left);
            }
            if (stack1.empty()){
                level++;
                stack1 = stack2;
                stack2 = new Stack<>();
            }
        }
    }

    public static void main(String[] args){
        Stack<Integer> a1 = new Stack<>();
        Stack<Integer> a2 = new Stack<>();
        a2.add(1);
        a1 = a2;
        a2 = new Stack<>();

        System.out.println(a1.pop());
        System.out.println(a2.empty());

    }
}