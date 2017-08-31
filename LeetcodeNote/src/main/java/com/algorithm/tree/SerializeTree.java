package com.algorithm.tree;

/**
 * @Author: feipeixuan
 * @Version: 序列化二叉树，先序遍历null用#
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class SerializeTree {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = root.left.right = null;
        root.right.left = root.right.right = null;
        SerializeTree serializeTree = new SerializeTree();
        String str = serializeTree.Serialize(root);
        TreeNode newRoot = serializeTree.Deserialize(str);


    }


    int index = 0;

    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        else {
            StringBuilder builder = new StringBuilder();
            VisitTree(root, builder);
            return builder.deleteCharAt(builder.length() - 1).toString();
        }
    }

    public void VisitTree(TreeNode root, StringBuilder builder) {
        if (root == null)
            builder.append("#,");
        else {
            builder.append("" + root.val + ",");
            VisitTree(root.left, builder);
            VisitTree(root.right, builder);
        }
    }

    TreeNode Deserialize(String str) {
        String[] array = str.split(",");
        if (array.length == 1)
            return null;
        else {
            index = 0;
            TreeNode root = ConstructTree(array);
            return root;
        }
    }

    public TreeNode ConstructTree(String[] array) {
        //equals而不是==
        if (array[index].equals("#")) {
            index++;
            return null;
        } else {
            int value = Integer.valueOf(array[index++]);
            TreeNode root = new TreeNode(value);
            root.left = ConstructTree(array);
            root.right = ConstructTree(array);
            return root;
        }
    }


}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}