import java.util.Arrays;

public class LC108ArrToBST {
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
    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return build(len/2, nums);
    }

    public static TreeNode build(int i, int[] nums){
        System.out.println(i);
        TreeNode cur = new TreeNode(nums[i]);
        if (i == 1 ){
            cur.left = new TreeNode(nums[0]);
            return cur;
        }
        if (i == 0 || i == nums.length - 1){
            return cur;
        }
        if (i == nums.length - 2){
            cur.right = new TreeNode(nums[nums.length-1]);
            return cur;}

        cur.left = build(i/2, nums);
        cur.right = build(3*i/2, nums);
        return cur;
    }

    public static void main(String[] args){
        int[] num = new int[]{1,3};
        System.out.println(sortedArrayToBST(num).left.val);
    }
}
