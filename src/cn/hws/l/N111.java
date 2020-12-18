package cn.hws.l;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class N111 {
    /**
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        if (root.left != null && root.right != null) {
            return 1 + Math.min(leftMinDepth, rightMinDepth);
        }

        if (root.left == null) {
            return 1 + rightMinDepth;
        }
        if (root.right == null) {
            return 1 + leftMinDepth;
        }
        return 0;
    }
    public int minDepthV2(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty() && flag){
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    flag = false;
                    break;
                }

                if(node.left!= null)queue.add(node.left);
                if(node.right!= null)queue.add(node.right);
            }

        }
        return depth;
    }
}