package main.java.com.study.leetCode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/5/30 16:57
 * @description: LeetCode-95-不同的二叉搜索树Ⅱ
 * 难度：中等
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class GenerateTrees {

    /**
     * 递归
     * 需要构建的二叉搜索树的数量实际上满足卡特兰数。
     * 从序列 1 ..n 取出数字 i 并以它作为当前树的根节点。 那么就有 i - 1 个元素可以用来构造左子树，而另外的 n - i 个元素可以用于构造右子树。
     * 最后我们将会得到 G(i - 1) 棵不同的左子树，以及 G(n - i) 棵不同的右子树，其中 G 为卡特兰数。
     * 现在，我们将会在序列 1 ... i - 1 上重复前面的步骤来构造所有的左子树，之后对序列 i + 1 ... n 也这样做以得到所有的右子树。
     * <p>
     * 这么一来，我们就得到了根节点 i 和两个可能的左右子树列表。 最后一步是遍历两个列表，将左右子树和根节点链接起来。
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generate(start, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
