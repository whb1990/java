package main.java.com.study.leetCode.dataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/6/12 10:42
 * @description: LeetCode-102-层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
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
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            //创建的队列用来存放结点，泛型注意是TreeNode
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            //队列为空说明已经遍历完所有元素，while语句用于循环每一个层次
            while (!queue.isEmpty()) {
                int size = queue.size();
                if (size > 0) {
                    List<Integer> tmpList = new ArrayList<>();
                    //遍历当前层次的每一个结点，每一层次的size代表了当前层次的结点数目
                    while (size-- > 0) {
                        //遍历的每一个结点都需要将其弹出
                        TreeNode curr = queue.remove();
                        tmpList.add(curr.val);
                        //迭代操作，向左探索
                        if (curr.left != null) {
                            queue.add(curr.left);
                        }
                        //迭代操作，向右探索
                        if (curr.right != null) {
                            queue.add(curr.right);
                        }
                    }
                    result.add(tmpList);
                }
            }
        }
        return result;
    }
}
