package main.java.com.study.leetCode.dataStructure.ntree;

import java.util.List;

/**
 * @author： whb
 * @description： N叉树节点定义
 * @date： 2020-10-30 15:14
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {

    }

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, List<Node> _children) {
        this.val = _val;
        this.children = _children;
    }
}
