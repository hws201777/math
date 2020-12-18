package cn.hws.l;

public class N110 {
    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * <p>
     * 本题中，一棵高度平衡二叉树定义为：
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：true
     */

    public boolean isBalanced(TreeNode root) {
        return helper(root) == -1 ? false : true;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int l = helper(root.left);
        if(l == -1) return -1;

        int r = helper(root.right);
        if(r == -1) return -1;

        return Math.abs(l - r) > 1 ? -1 : 1 + Math.max(l, r);
    }


}
