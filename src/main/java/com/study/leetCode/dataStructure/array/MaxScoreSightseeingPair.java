package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author: whb
 * @date: 2020/6/17 15:00
 * @description: LeetCode-1014-最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 示例：
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * 提示：
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class MaxScoreSightseeingPair {
    /**
     * 组合得分A[i] + A[j] + i - j 调换下位置变为：
     * （A[i] + i的最大值）与（A[j] - j的最大值）的和。
     * 由于当前元素A[j] - j是定值（对每一个元素自身而言），那么该元素的观光最高得分转化为求当前元素集合中的A[i] + i的最大值
     *
     * @param A
     * @return
     */
    public static int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0, maxFirstScore = A[0];
        for (int i = 1; i < A.length; i++) {
            if (maxScore < maxFirstScore + A[i] - i) {
                maxScore = maxFirstScore + A[i] - i;
            }
            if (maxFirstScore < A[i] + i) {
                maxFirstScore = A[i] + i;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }
}
