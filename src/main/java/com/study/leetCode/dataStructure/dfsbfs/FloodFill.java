package main.java.com.study.leetCode.dataStructure.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/5/29 16:59
 * @description: LeetCode-733-图像渲染
 * 难度：简单
 * 标签：深度优先搜索、广度优先搜索
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 */
public class FloodFill {
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = floodFill.floodFill(image, sr, sc, newColor);
        for (int[] tmp : result) {
            System.out.println(Arrays.toString(tmp));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }
        int tar = image[sr][sc];
        if (tar == newColor) {
            return image;
        }
        bfs(image, sr, sc, newColor, tar);
        return image;
    }

    /**
     * 深度优先搜索
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @param tar
     */
    private void dfs(int[][] image, int sr, int sc, int newColor, int tar) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != tar) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, tar);
        dfs(image, sr + 1, sc, newColor, tar);
        dfs(image, sr, sc - 1, newColor, tar);
        dfs(image, sr, sc + 1, newColor, tar);
    }

    /**
     * 广度优先搜索
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @param tar
     */
    private void bfs(int[][] image, int sr, int sc, int newColor, int tar) {
        int nr = image.length;
        int nc = image[0].length;
        if (sr < 0 || sc < 0 || sr >= nr || sc >= nc || image[sr][sc] != tar) {
            return;
        }
        image[sr][sc] = newColor;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sr * nc + sc);
        while (!queue.isEmpty()) {
            int id = queue.remove();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && image[row - 1][col] == tar) {
                image[row - 1][col] = newColor;
                queue.add((row - 1) * nc + col);
            }
            if (row + 1 < nr && image[row + 1][col] == tar) {
                image[row + 1][col] = newColor;
                queue.add((row + 1) * nc + col);
            }
            if (col - 1 >= 0 && image[row][col - 1] == tar) {
                image[row][col - 1] = newColor;
                queue.add(row * nc + col - 1);
            }
            if (col + 1 < nc && image[row][col + 1] == tar) {
                image[row][col + 1] = newColor;
                queue.add(row * nc + col + 1);
            }
        }
    }
}
