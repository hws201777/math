package cn.hws.l;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N257 {
    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * <p>
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Integer> queue = new LinkedList<>();
        helper(root, queue, res);
        return res;
    }

    private void helper(TreeNode root, LinkedList<Integer> queue, List<String> res) {
        queue.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : queue) {
                sb.append(integer).append("->");
            }
            String str = sb.toString();
            str = str.substring(0, str.length() - 3);
            res.add(str);
            return;
        }
        if (root.left != null) {
            helper(root.left, queue, res);
            queue.removeLast();
        }

        if (root.right != null) {
            helper(root.right, queue, res);
            queue.removeLast();
        }
        return;
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }
    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
