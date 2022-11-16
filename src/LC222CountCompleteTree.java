

public class LC222CountCompleteTree {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
    }
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        //Queue<Integer> list1 = new LinkedList<>();
        //list2.add(1);

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
