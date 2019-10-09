package main.java.com.study.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/10/9 14:46
 * @description: 完全二叉树的三种遍历
 */
public class BinaryTreeErgodic {

    private static List<Node> list = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        createdBTree(arr);
        Node rootNode = list.get(0);
        System.out.println("前序遍历：");
        preTraverse(rootNode);
        System.out.println();
        System.out.println("中序遍历：");
        middleTraverse(rootNode);
        System.out.println();
        System.out.println("后序遍历：");
        tailTraverse(rootNode);
    }

    /**
     * 前序遍历：根 --- 左子树 --- 右子树
     *
     * @param node
     */
    public static void preTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preTraverse(node.getLeftChildNode());
        preTraverse(node.getRightChildNode());
    }

    /**
     * 中序遍历：左子树 --- 根 --- 右子树
     *
     * @param node
     */
    public static void middleTraverse(Node node) {
        if (node == null) {
            return;
        }
        middleTraverse(node.getLeftChildNode());
        System.out.print(node.getData() + " ");
        middleTraverse(node.getRightChildNode());
    }

    /**
     * 后序遍历：左子树 --- 右子树 --- 根
     *
     * @param node
     */
    public static void tailTraverse(Node node) {
        if (node == null) {
            return;
        }
        tailTraverse(node.getLeftChildNode());
        tailTraverse(node.getRightChildNode());
        System.out.print(node.getData() + " ");
    }

    /**
     * 将一个arry数组构建成一个完全二叉树
     *
     * @param arr
     */
    public static void createdBTree(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            list.add(new Node(arr[i]));
        }

        for (int i = len / 2 - 1; i >= 0; i--) {
            list.get(i).setLeftChildNode(list.get(getLeftChild(i)));
            if (getLeftChild(i) < (len - 1)) {
                list.get(i).setRightChildNode(list.get(getLeftChild(i) + 1));
            }
        }
    }

    /**
     * 获取左孩子
     *
     * @param i
     * @return
     */
    private static int getLeftChild(int i) {
        return 2 * i + 1;
    }
}

/**
 * 定义二叉树节点元素
 */
class Node {
    /**
     * 左孩子
     */
    private Node leftChildNode;
    /**
     * 右孩子
     */
    private Node rightChildNode;
    /**
     * 节点数据
     */
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public Node getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}


