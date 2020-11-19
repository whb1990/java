package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author： whb
 * @description： LeetCode-687-最长同值路径
 * @date： 2020-11-19 11:35
 * 难度：中等
 * 标签：树、深度优先搜索
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 *
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class LongestUnivaluePath {
    /**
     * 解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
     * 1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
     * 2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
     * 需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
     */
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return res;
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        res = Math.max(res, left + right);
        // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
        return root.val == val ? Math.max(left, right) + 1 : 0;
    }
}
