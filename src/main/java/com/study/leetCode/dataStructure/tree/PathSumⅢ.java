package main.java.com.study.leetCode.dataStructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/6/12 15:55
 * @description: LeetCode-437-路径总和Ⅲ
 * 难度：中等
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
     * 前缀和+记忆化回溯
     * 如果两个数的前缀总和是相同的，那么这些节点之间的元素总和为零。进一步扩展相同的想法，如果前缀总和currSum，在节点A和节点B处相差target，则位于节点A和节点B之间的元素之和是target。
     * 抵达当前节点(即B节点)后，将前缀和累加，然后查找在前缀和上，有没有前缀和currSum-target的节点(即A节点)，存在即表示从A到B有一条路径之和满足条件的情况。结果加上满足前缀和currSum-target的节点的数量。然后递归进入左右子树。
     * <p>
     * 左右子树遍历完成之后，回到当前层，需要把当前节点添加的前缀和去除。避免回溯之后影响上一层。因为思想是前缀和，不属于前缀的，我们就要去掉它。
     * <p>
     * 时间复杂度：每个节点只遍历一次,O(N).
     * <p>
     * 空间复杂度：开辟了一个hashMap,O(N).
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> pathMap = new HashMap<>();
        // 前缀和为0的目前只有一条路径
        pathMap.put(0, 1);
        // 前缀和的递归回溯思路
        return core(root, pathMap, sum, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     *
     * @param root    树节点
     * @param pathMap 前缀和Map
     * @param sum     目标值
     * @param curSum  当前路径和
     * @return 满足题意的解
     */
    private int core(TreeNode root, Map<Integer, Integer> pathMap, int sum, int curSum) {
        // 1.递归终止条件
        if (root == null) {
            return 0;
        }
        // 2.本层要做的事情
        int result = 0;
        // 当前路径上的和
        curSum += root.val;
        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        result += pathMap.getOrDefault(curSum - sum, 0);
        // 更新路径上当前节点前缀和的个数
        pathMap.put(curSum, pathMap.getOrDefault(curSum, 0) + 1);
        // 3.进入下一层
        result += core(root.left, pathMap, sum, curSum);
        result += core(root.right, pathMap, sum, curSum);
        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        pathMap.put(curSum, pathMap.get(curSum) - 1);
        return result;
    }
}
