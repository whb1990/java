package main.java.com.study.leetCode.dp;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-11-5-填充书架
 * @date： 2020-12-05 11:29
 * 难度：中等
 * 标签：动态规划
 * 附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。
 *
 * 你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，高度为 books[i][1]。
 *
 * 按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。
 *
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。
 *
 * 需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 *
 * 每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。
 *
 * 以这种方式布置书架，返回书架整体可能的最小高度。
 *
 *
 * 示例：
 *
 * 输入：books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
 * 输出：6
 * 解释：
 * 3 层书架的高度和为 1 + 3 + 2 = 6 。
 * 第 2 本书不必放在第一层书架上。
 *
 *
 * 提示：
 * 1 <= books.length <= 1000
 * 1 <= books[i][0] <= shelf_width <= 1000
 * 1 <= books[i][1] <= 1000
 */
public class MinHeightShelves {
    /**
     * 动态规划
     * 1、状态定义：用 dp[i] 表示放置前 i 本书所需要的书架最小高度；
     * 2、状态转移方程：
     * 遍历每一本书，把当前这本书作为书架最后一层的最后一本书，将这本书之前的书向后调整，看看是否可以减少之前的书架高度。
     * 状态转移方程为 dp[i] = min(dp[i] , dp[j - 1] + h)，其中 j 表示最后一层所能容下书籍的索引，h 表示最后一层最大高度。
     * 3、base case：初始值 dp[0] = 0，其他为最大值 1000*1000。
     *
     * @param books
     * @param shelf_width
     * @return
     */
    public static int minHeightShelves(int[][] books, int shelf_width) {
        // dp[i] 表示放置前 i 本书所需要的书架最小高度
        int[] dp = new int[books.length + 1];
        //初始值 dp[0] = 0
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= books.length; i++) {
            //width:以第i本书作为最后一本书，最后一层的宽度
            //height:以第i本书作为最后一本书，最后一层的高度
            int width = 0, height = 0;
            for (int j = i; j >= 1; j--) {
                width += books[j - 1][0];
                //仅考虑到之前的书能与现在组成一层
                if (width > shelf_width) {
                    break;
                }
                //组成一层后该层的高度，取书的最高高度
                height = Math.max(height, books[j - 1][1]);
                //不断更新当前最低高度
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[books.length];
    }

    public static void main(String[] args) {
        System.out.println(minHeightShelves(new int[][]{
                        {1, 1},
                        {2, 3},
                        {2, 3},
                        {1, 1},
                        {1, 1},
                        {1, 1},
                        {1, 2}
                }, 4
        ));
    }
}
