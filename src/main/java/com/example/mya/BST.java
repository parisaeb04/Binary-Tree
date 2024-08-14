//BST

package com.example.mya;

public class BST {
    private TreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public String inOrderTraversal() {
        StringBuilder result = new StringBuilder();
        inOrderTraversalRecursive(root, result);
        return result.toString();
    }

    public TreeNode getRoot() {
        return root;
    }

    private TreeNode insertRecursive(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value);
        }

        return root;
    }

    private TreeNode deleteRecursive(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = deleteRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRecursive(root.right, value);
        } else {
            // Node to be deleted found

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.value);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    private void inOrderTraversalRecursive(TreeNode node, StringBuilder result) {
        if (node != null) {
            inOrderTraversalRecursive(node.left, result);
            result.append(node.value).append(" ");
            inOrderTraversalRecursive(node.right, result);
        }
    }

    static class TreeNode {
        private int value;
        private TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
