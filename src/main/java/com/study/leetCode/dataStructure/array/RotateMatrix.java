package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author: whb
 * @date: 2020/5/30 19:12
 * @description: LeetCode-面试题01.07-旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateMatrix {
    /**
     * 一次旋转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                copy[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                matrix[j][N - 1 - i] = copy[i][j];
            }
        }
    }

    /**
     * 二次旋转
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        int[][] result = new int[len][len];
        //第一次旋转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        int k = 0;
        //第二次旋转
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {
                matrix[i][k++] = result[i][j];
                if (k == len) {
                    k = 0;
                }
            }
        }
    }
}
