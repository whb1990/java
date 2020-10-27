package main.java.com.study.leetCode.dataStructure.dfsbfs;

/**
 * @author： whb
 * @description： LeetCode-1219-黄金矿工
 * @date： 2020-10-27 16:15
 * 难度：中等
 * 标签：回溯算法、深度搜索优先
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 * 示例 1：
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 *
 * 示例 2：
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 输出：28
 * 解释：
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 *
 *
 * 提示：
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * 最多 25 个单元格中有黄金。
 */
public class MaximumGold {
    /**
     * 题目的意思就是在一个二维数组中从任一位置开始，可以往他的上下左右4个方向走，然后返回走过的路线中值最大的，0其实就相当于障碍物，不能往位置为0的地方走。
     * 我们需要遍历每一个位置，从任何一个位置开始找到最大路径。
     *
     * @param grid
     * @return
     */
    public static int getMaximumGold(int[][] grid) {
        //边界条件判断
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        //保存最大路径值
        int res = 0;
        //两个for循环，遍历每一个位置，让他们当做起点
        //查找最大路径值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //函数dfs是以坐标(i,j)为起点，查找最大路径值
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        //返回最大值
        return res;
    }

    private static int dfs(int[][] grid, int i, int j) {
        //边界条件的判断，i,j都不能越界，同时当前坐标的位置如果是0，表示有障碍物或者遍历过了
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        //先把当前坐标的值保存下来，最后再还原
        int value = grid[i][j];
        //当前坐标已经访问过了，要把他标记为0，防止再次访问
        grid[i][j] = 0;
        //然后沿着当前坐标的上下左右4个方向查找
        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);
        //然后再把当前位置的值还原
        grid[i][j] = value;
        //这里只要4个方向的最大值加上当前位置的值即可
        return Math.max(Math.max(up, down), Math.max(left, right)) + value;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGold(new int[][]{
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        }));
        System.out.println(getMaximumGold(new int[][]{
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        }));
    }
}
