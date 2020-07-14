package main.java.com.study.leetCode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/7/14 10:06
 * @description: LeetCode-120-三角形最小路径和
 * 难度：中等
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class MinimumTotal {
    /**
     * 动态规划--二维数组解法
     * 自底向上，不断更新最小的值，一直推到最后，计算的递推公式，dp[i][j] = min(dp[i+1][j], dp[i+1[j+1]) + triangle[i][j];
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int[][] dp = new int[row][row];
        //最后一行
        for (int j = row - 1; j >= 0; j--) {
            dp[row - 1][j] = triangle.get(row - 1).get(j);
        }
        //其他行
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(2);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(3);
        tmp.add(4);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(6);
        tmp.add(5);
        tmp.add(7);
        triangle.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(4);
        tmp.add(1);
        tmp.add(8);
        tmp.add(3);
        triangle.add(tmp);
        System.out.println(minimumTotal(triangle));
    }
}
