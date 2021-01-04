package com.tuhuynh.jalgo.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root = null;

    public BinarySearchTree() {}

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    Node<T> insertRecursive(Node<T> node, T value) {
        if (node == null) {
            node = new Node<>(value);
        } else if (value.compareTo(node.value) < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public List<T> inorder() {
        List<T> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    void inorderRecursive(Node<T> node, List<T> result) {
        if (node != null) {
            inorderRecursive(node.left, result);
            result.add(node.value);
            inorderRecursive(node.right, result);
        }
    }

    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    boolean searchRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value.compareTo(current.value) < 0 ? searchRecursive(current.left, value) : searchRecursive(current.right, value);
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = deleteRecursive(current.right, value);
        } else {
            if (current.left == null) return current.right;
            else if (current.right == null) return current.left;

            current.value = minValue(current.right);
            current.right = deleteRecursive(current.right, current.value);
        }

        return current;
    }

    T minValue(Node<T> node) {
        T minVal = node.value;
        while (node.left != null) {
            minVal = node.left.value;
            node = node.left;
        }
        return minVal;
    }
}

class Node<T> {
    T value;
    Node<T> left, right = null;

    Node(T value) {
        this.value = value;
    }
}
