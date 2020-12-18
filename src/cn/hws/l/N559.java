package cn.hws.l;

public class N559 {
    /**
     * 559. N叉树的最大深度
     * 给定一个 N 叉树，找到其最大深度。
     *
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     *
     * 例如，给定一个 3叉树 :
     *
     *
     *
     *
     *
     *
     *
     * 我们应返回其最大深度，3。
     */

    public int maxDepth(Node root) {
        if(root == null) return 0;
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth,maxDepth(child));
        }
        return 1 + depth;
    }
}
