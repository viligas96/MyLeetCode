import java.util.*;

public class LC105ConstructBTFromPreAndIn {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        build(root, preorder, inorder);
        return root;
    }

    public void build(TreeNode root, int[] preorder, int[] inorder){
        int len = preorder.length;
        if (len == 0) return;
        int lenL, lenR;
        int[] preL, inL, preR, inR;

        int rootIndex = 0;
        for (int i = 0; i < len; i++){
            if (inorder[i] == root.val){
                rootIndex = i;
                break;
            }
        }
        lenL = rootIndex;
        lenR = len - 1 - rootIndex;

        if (lenL == 0) {root.left = null;}
        else{root.left = new TreeNode(preorder[1]);}

        if (lenR == 0) {root.right = null;}
        else{root.right = new TreeNode(preorder[1 + lenL]);}

        preL = Arrays.copyOfRange(preorder, 1, lenL + 1);
        inL = Arrays.copyOfRange(inorder, 0, lenL);

        preR = Arrays.copyOfRange(preorder, 1 + lenL, len);
        inR = Arrays.copyOfRange(inorder, lenL + 1, len);

        build(root.left, preL, inL);
        build(root.right, preR, inR);
    }

}
