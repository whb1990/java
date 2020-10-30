package main.java.com.study.leetCode.dataStructure.ntree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author： whb
 * @description： LeetCode-429-N叉树的层序遍历
 * @date： 2020-10-30 16:09
 * 难度：中等
 * 标签：树、广度优先搜索
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> tmpList = new ArrayList<>();
                while (size-- > 0) {
                    Node tmp = queue.poll();
                    tmpList.add(tmp.val);
                    if (tmp.children != null) {
                        queue.addAll(tmp.children);
                    }
                }
                res.add(tmpList);
            }
        }
        return res;
    }
}
