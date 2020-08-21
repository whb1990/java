package main.java.com.study.leetCode.dataStructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/6/12 15:12
 * @description: LeetCode-113-路径总和Ⅱ
 * 难度：中等
 * 标签：树、深度优先搜索
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root != null) {
            if (root.val == sum && root.left == null && root.right == null) {
                resultList.add(Arrays.asList(root.val));
                return resultList;
            }
            //计算左子树满足总和的结果集
            List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
            //计算右子树满足总和的结果集
            List<List<Integer>> rightList = pathSum(root.right, sum - root.val);
            for (List<Integer> tmpList : leftList) {
                //结果集要加上根节点的值
                tmpList.add(0, root.val);
                resultList.add(tmpList);
            }
            for (List<Integer> tmpList : rightList) {
                //结果集要加上根节点的值
                tmpList.add(0, root.val);
                resultList.add(tmpList);
            }
        }
        return resultList;
    }
}
