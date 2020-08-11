package main.java.com.study.leetCode.dataStructure.dfsbfs;

import java.util.Arrays;

/**
 * @author: whb
 * @date: 2020/7/16 10:31
 * @description: LeetCode-785-判断二分图
 * 难度：中等
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 *
 * 注意:
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 */
public class Bipartite {
    /**
     * 如示例1：[[1,3], [0,2], [1,3], [0,2]]
     * 他这个意思是第0个点连着1和3，第1个点连着0和2，第2个点连着1和3，第3个点连着0和2
     * 所谓二分图就是把当前的图的节点拆分开成两个子集合，并且每条边的两个节点要分别属于那两个子集合，
     * 咋一眼看起来好像就是将边的节点分开，然后最后看某个点是否不能被分开，就好比把节点分成两类，
     * 如果某个节点既被分到第一类又被分到第二类那么就会冲突，就不符合条件，代码的话还是采用深搜来写
     *
     * @param graph
     * @return
     */
    public static boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!dfs(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int pos, int color) {
        if (colors[pos] != -1) {
            return colors[pos] == color;
        }
        colors[pos] = color;
        for (int index : graph[pos]) {
            if (!dfs(graph, colors, index, 1 - color)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
    }
}
