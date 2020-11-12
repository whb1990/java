package main.java.com.study.leetCode.recall;

/**
 * @author： whb
 * @description： LeetCode-60-排列序列
 * @date： 2020-11-12 18:11
 * 难度：困难
 * 标签：数组、回溯算法
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 *
 * 示例 1：
 * 输入：n = 3, k = 3
 * 输出："213"
 *
 * 示例 2：
 * 输入：n = 4, k = 9
 * 输出："2314"
 *
 * 示例 3：
 * 输入：n = 3, k = 1
 * 输出："123"
 *
 *
 * 提示：
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class GetPermutation {
    /**
     * 所求排列 一定在叶子结点处得到，进入每一个分支，可以根据已经选定的数的个数，进而计算还未选定的数的个数，然后计算阶乘，就知道这一个分支的 叶子结点 的个数：
     * 如果 k 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫「剪枝」；
     * 如果 k 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        // 阶乘数组
        int[] factorial = calculateFactorial(n);
        // 查找全排列需要的布尔数组，记录数字是否使用过，
        boolean[] used = new boolean[n + 1];
        StringBuilder res = new StringBuilder();
        backtrack(n, k, 0, factorial, used, res);
        return res.toString();
    }

    /**
     * @param n
     * @param k
     * @param index     在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param factorial
     * @param used
     * @param res
     */
    private static void backtrack(int n, int k, int index, int[] factorial, boolean[] used, StringBuilder res) {
        if (index >= n) {
            return;
        }
        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            res.append(i);
            used[i] = true;
            backtrack(n, k, index + 1, factorial, used, res);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组
     *
     * @param n
     * @return
     */
    private static int[] calculateFactorial(int n) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(3, 1));
    }
}
