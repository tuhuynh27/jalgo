package com.tuhuynh.jalgo;

import com.tuhuynh.jalgo.tree.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        /* BST
               50
            /     \
           30      70
          /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.delete(30);

        // Traversal
        List<Integer> treeNodes = tree.inorder();
        System.out.println(treeNodes);

        // Search
        System.out.println(tree.search(10));
        System.out.println(tree.search(60));
    }
}
