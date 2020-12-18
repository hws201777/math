package cn.hws.l;

import java.util.Stack;

public class N226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;

        TreeNode leftnode = node.left;
        TreeNode rightnode = node.right;
        node.left = rightnode;
        node.right = leftnode;

        dfs(rightnode);
        dfs(leftnode);

        return;
    }

    public TreeNode invertTreeV2(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }
        return root;
    }

}
