package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author： whb
 * @description： LeetCode-572-另一个树的子树
 * @date： 2020-11-19 10:19
 * 难度：简单
 * 标签：树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 */
public class IsSubTree {
    /**
     * 这道题其实是相同的树的进阶版。
     * 判断t是否为s的子树，如果根节点相同，那么有必要开始判断从这个根节点开始这两棵树是否相同。
     * 若相同了，说明已经找到，结束算法；如果不同，继续从s的左右子树寻找t，只要在一边找到就可以了。
     * 根节点相同但仍然是不同的树，如 s = [2,2,3], t = [2]
     * 如果根节点不相同，那么继续从s的左右子树寻找t，只要在一边找到就可以了
     * 递归出口：空树认为是任何树的子树；当s为空而t不为空时，说明s不包含t。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //若s为空，则t为空返回true，反之false
        if (s == null) {
            return t == null;
        }
        //如果当前节点是子树开端且左右子树一致 就返回true
        //没找到就继续往左右子树找
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断两棵树是否相同
     *
     * @param s
     * @param t
     * @return
     */
    private boolean isSame(TreeNode s, TreeNode t) {
        //都为空时,它们相同且不用比较左右子树
        if (s == null && t == null) {
            return true;
        }
        //如果一个为空一个不为空或者不相等都不满足成为子树的条件
        if (s == null || t == null) {
            return false;
        }
        //来到这里说明它们此节点是相同的,比较它们的左右子树
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
