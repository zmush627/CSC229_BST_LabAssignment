package com.mycompany.csc229_bst_example;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {
        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {
        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        // ToDo 1: complete InOrder Traversal
        if (root != null) {
            doInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            doInOrder(root.getRight());
        }
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    private void doPreOrder(BstNode root) {
        // ToDo 2: complete the pre-order traversal
        if (root != null) {
            System.out.print(root.getData() + " ");
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }

    public Integer findHeight() {
        // ToDo 3: Find the height of a tree
        return getHeight(this.root);
    }

    private Integer getHeight(BstNode node) {
        if (node == null) {
            return -1; // Height of empty tree is -1, height of single node tree is 0
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDepth(BstNode node) {
        // ToDo 4: complete getDepth of a node
        return findDepth(this.root, node, 0);
    }

    private int findDepth(BstNode root, BstNode target, int currentDepth) {
        if (root == null) {
            return -1; // Node not found
        }

        if (root == target) {
            return currentDepth;
        }

        // Search in left subtree
        int leftDepth = findDepth(root.getLeft(), target, currentDepth + 1);
        if (leftDepth != -1) {
            return leftDepth;
        }

        // Search in right subtree
        return findDepth(root.getRight(), target, currentDepth + 1);
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }

    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getData());

            // Print left subtree
            if (node.getLeft() != null || node.getRight() != null) {
                print(prefix + (isLeft ? "│   " : "    "), node.getLeft(), true);
                print(prefix + (isLeft ? "│   " : "    "), node.getRight(), false);
            }
        } else {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + "null");
        }
    }

    // Additional utility methods for testing
    public BstNode getRoot() {
        return this.root;
    }

    // Level order traversal for better visualization
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<BstNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Level Order Traversal:");
        while (!queue.isEmpty()) {
            BstNode current = queue.poll();
            System.out.print(current.getData() + " ");

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        System.out.println();
    }
}