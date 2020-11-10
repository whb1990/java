package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author： whb
 * @description： LeetCode-654-最大二叉树
 * @date： 2020-11-10 14:12
 * 难度：中等
 * 标签：树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 *
 * 提示：
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class ConstructMaximumBinaryTree {
    /**
     * 创建方法 buildTree(nums, l, r)，用于找出在数组 nums 中从 l 到 r 索引（不包含第 r 个位置）中最大二叉树的根节点。
     *
     * 算法步骤如下：
     *
     * 首先调用 buildTree(nums, 0, n)，其中 nn 是数组 nums 的长度。
     *
     * 在索引范围 (l:r-1) 内找到最大值的索引，将 nums[max_i] 作为根节点。
     *
     * 调用 buildTree(nums, l, max_i) 创建根节点的左孩子。递归执行此操作，创建根节点的整个左子树。
     *
     * 类似的，调用 buildTree(nums, max_i + 1, r) 创建根节点的右子树。
     *
     * 方法 buildTree(nums, 0, n) 返回最大二叉树的根节点。
     *
     * 时间复杂度：O(n^2)。方法 buildTree 一共被调用 n 次。每次递归寻找根节点时，需要遍历当前索引范围内所有元素找出最大值。
     * 一般情况下，每次遍历的复杂度为 O(logn)，总复杂度为 O(nlogn)。最坏的情况下，数组 nums 有序，总的复杂度为 O(n^2)。
     *
     * 空间复杂度：O(n)。递归调用深度为 n。平均情况下，长度为 n 的数组递归调用深度为 O(logn)。
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int idx = -1, max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = buildTree(nums, low, idx - 1);
        root.right = buildTree(nums, idx + 1, high);
        return root;
    }
}
