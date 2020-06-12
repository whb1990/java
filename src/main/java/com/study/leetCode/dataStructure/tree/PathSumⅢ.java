package main.java.com.study.leetCode.dataStructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/6/12 15:55
 * @description: LeetCode-437-路径总和Ⅲ
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class PathSumⅢ {
    /**
     * 递归:从每一个结点开始，DFS遍历所有路径
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
    }

    /**
     * 记忆化回溯
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> pathMap = new HashMap<>();
        //路径长度为0的目前有1个
        pathMap.put(0, 1);
        return core(root, pathMap, sum, 0);
    }

    private int core(TreeNode root, Map<Integer, Integer> pathMap, int sum, int curSum) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int result = pathMap.getOrDefault(curSum - sum, 0);
        //把当前路径放入
        pathMap.put(curSum, pathMap.getOrDefault(curSum, 0) + 1);
        result += core(root.left, pathMap, sum, curSum);
        result += core(root.right, pathMap, sum, curSum);
        //把之前的弹出
        pathMap.put(curSum, pathMap.get(curSum) - 1);
        return result;
    }
}
