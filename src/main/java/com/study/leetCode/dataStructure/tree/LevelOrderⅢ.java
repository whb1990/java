package main.java.com.study.leetCode.dataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/8/5 18:38
 * @description: LeetCode-剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 难度：中等
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class LevelOrderⅢ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> tmpList = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode tmp = queue.poll();
                    if (result.size() % 2 == 0) {
                        tmpList.add(tmp.val);
                    } else {
                        tmpList.add(0, tmp.val);
                    }
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
                result.add(tmpList);
            }
        }
        return result;
    }
}
