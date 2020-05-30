package main.java.com.study.leetCode.recursion;

/**
 * @author: whb
 * @date: 2020/5/30 16:19
 * @description: LeetCode-779-第K个语法符号
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * 例子:
 * <p>
 * 输入: N = 1, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 2
 * 输出: 1
 * <p>
 * 输入: N = 4, K = 5
 * 输出: 1
 * <p>
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 */
public class KthGrammar {
    /**
     * 思路分析：N的取值范围是 [1, 30]，意味着K的取值可能达到2^30，这将是一个非常大的数，因此想构造出这个序列然后直接找出第K未是非常不现实的。首先我们来看一下这棵满二叉树排序序号结构
     * <p>
     * //序号
     * //              1
     * //          /        \
     * //      1                2
     * //    /   \            /    \
     * //  1       2        3       4
     * // / \     /  \     /  \    / \
     * //1   2   3    4   5    6  7   8
     * <p>
     * 不难发现一个规律：(K + 1) / 2是K的父节点所在的序号。
     * 再来看一下01值的分布图
     * <p>
     * //01排列
     * //              0
     * //          /        \
     * //      0                1
     * //    /   \            /    \
     * //  0       1        1       0
     * // / \     /  \     /  \    / \
     * //0   1   1    0   1    0  0   1
     * <p>
     * 可以再得到一个规律，如果K是奇数，则K的状态与K的父节点的状态相同，否则K的状态与K的父节点状态相反。
     * 所以我们先利用递归求得K的父节点，然后根据K的奇偶性求出K的值。
     *
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
        //第一层：树的根
        if (N == 1) {
            return 0;
        }
        //先求出当前K的父节点
        int father = kthGrammar(N - 1, (K + 1) / 2);
        //根据K的奇偶性求出当前K的状态
        if (K % 2 == 1) {
            return father;
        }
        return 1 - father;
    }
}