package com.algorithm.tree;

/**
 * @Author: feipeixuan
 * @Version: 判断另一个是不是树的子结构
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class HasSubTree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null)
            return false;
        else if (equalsTree(root1, root2))
            return true;
        else
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean equalsTree(TreeNode root1, TreeNode root2) {
        /*  如果能到root2的null节点，说明前面都已经匹配上了 */
        if (root2 == null)
            return true;
        else if (root1 == null)
            return false;
        else if (root1.val == root2.val)
            return equalsTree(root1.left, root2.left) && equalsTree(root1.right, root2.right);
        else
            return false;

    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
