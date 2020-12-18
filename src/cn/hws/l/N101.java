package cn.hws.l;

import java.util.LinkedList;
import java.util.Stack;

public class N101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        if (!compare(left.left, right.right)) return false;
        if (!compare(left.right, right.left)) return false;
        return true;
    }

    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null) continue;//注意不要反回true
            if (left == null || right == null || left.val != right.val) return false;

            stack.add(left.left);
            stack.add(right.right);

            stack.add(right.left);
            stack.add(left.right);
        }
        return true;
    }

}
