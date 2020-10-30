package main.java.com.study.leetCode.dataStructure.ntree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： whb
 * @description： LeetCode-559-N叉树的最大深度
 * @date： 2020-10-30 16:38
 * 难度：简单
 * 标签：树、深度优先搜索、广度优先搜索
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
public class MaxDepth {
    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }

    /**
     * 迭代法
     */
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size > 0) {
                Node cur = queue.poll();
                if (cur.children != null) {
                    for (Node child : cur.children) {
                        queue.add(child);
                    }
                }
                size--;
            }
        }
        return depth;
    }
}
