package main.java.com.study.leetCode.dataStructure.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/6/11 14:37
 * @description: LeetCode-652-寻找重复子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class FindDuplicateSubtrees {
    /**
     * 思路：将节点的子树作为字符串的形式存入哈希表中，如果有重复就将节点放入结果集
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //结果集
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //定义map，key为序列化的子树，value为子树出现次数
        Map<String, Integer> map = new HashMap<>();
        //后序遍历
        find(root, map, result);
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param map
     * @param result
     * @return
     */
    private String find(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }
        //递归左子孩子、右子孩子，串联子树路径
        String serial = root.val + "," + find(root.left, map, result) + "," + find(root.right, map, result);
        ////哈希映射查找重复子结点
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            // 第二次出现相同路径时存储该结点，必须这样判断，如果用 > 1的条件，有可能子树出现超过两次就会输出多次结果
            result.add(root);
        }
        return serial;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
