package main.java.com.study.leetCode.dp;

import main.java.com.study.leetCode.dataStructure.tree.TreeNode;

/**
 * @author: whb
 * @date: 2020/8/5 15:15
 * @description: LeetCode-337-打家劫舍Ⅲ
 * 难度：中等
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class RobⅢ {
    /**
     * 1、每个节点可以选择偷或者不偷，因为相邻节点不能一起偷，所以如果当前节点偷，那么其子节点不能偷；如果当前节点不偷，那么最大金额就是左右子节点最大值之和。
     * 2、状态int res[] = new int[2],0表示不偷，1表示偷。
     * 3、状态转移方程result[0] = Math.max(helpRob(root.left)[0],helpRob(root.left)[1])+Math.max(helpRob(root.right)[0],helpRob(root.right)[1])
     * result[1] = helpRob(root.left)[0]+helpRob(root.right)[0]+root.val;
     * 4、输出Math.max(result[0],result[1])
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = helpRob(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helpRob(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        // 左子树 不包含根节点与包含根节点 值
        int[] left = helpRob(node.left);
        int[] right = helpRob(node.right);
        int[] result = new int[2];
        // 不包含本节点
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 包含本节点
        result[1] = left[0] + right[0] + node.val;
        return result;
    }
}
