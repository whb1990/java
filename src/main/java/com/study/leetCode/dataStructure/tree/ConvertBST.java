package main.java.com.study.leetCode.dataStructure.tree;

/**
 * @author： whb
 * @description： LeetCode-538-把二叉搜索树转换为累加树
 * @date： 2020-11-20 19:41
 * 难度：中等
 * 标签：树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 *  示例 1：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 *
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 *
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 *
 *
 * 提示：
 * 树中的节点数介于 0 和 104 之间。
 * 每个节点的值介于 -104 和 104 之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
 */
public class ConvertBST {
    /**
     * 分析
     *
     * 对只有三个节点的搜索二叉树而言，计算结果就是，右子节点保持不变，中间节点的值是其本身与右子节点相加的和，左子节点的值是其本身与中间节点、右子节点三者的累计之和。
     *
     * 也就是说，若求中间节点的值必须要先遍历完右子节点，而若求左子节点的值必须要遍历完中间节点和右子节点。
     * 因此，只需要进行一次反向中序遍历（即遍历顺序为右子树-->根节点-->左子树），在遍历过程中需要将已经遍历的节点的值进行累加，然后再赋值给当前节点。
     *
     * 思路
     *
     * 1、定义一个全局变量sum，用于存储遍历的所有节点值的累计和；
     * 2、递归终止条件： root为空就返回null;
     * 3、递归右子树root.right;
     * 4、遍历当前节点，作如下操作：
     * 4.1、将其值累加到sum中；
     * 4.2、把sum赋值给当前节点的值；
     * 5、递归左子树root.left;
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    int sum = 0;
    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
