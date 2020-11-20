package main.java.com.study.leetCode.unionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： whb
 * @description： LeetCode-547-朋友圈
 * @date： 2020-11-20 15:42
 * 难度：中等
 * 标签：深度优先搜索、广度优先搜索、并查集
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1：
 * 输入：
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出：2
 * 解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回 2 。
 *
 * 示例 2：
 * 输入：
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出：1
 * 解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
 *
 *
 * 提示：
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 */
public class FindCircleNum {
    /**
     * 深度优先搜索
     * 从每个节点开始，使用一个大小为 N 的 visited 数组（M 大小为 N×N），这样 visited[i] 表示第 i 个元素是否被深度优先搜索访问过。
     * 首先选择一个节点，访问任一相邻的节点。然后再访问这一节点的任一相邻节点。这样不断遍历到没有未访问的相邻节点时，回溯到之前的节点进行访问。
     * 从每个未被访问的节点开始深搜，每开始一次搜索就增加 count 计数器一次。
     *
     * @param M
     * @return
     */
    public int findCircleNumDfs(int[][] M) {
        int len = M.length, count = 0;
        int[] visited = new int[len];
        for (int i = 0; i < len; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    /**
     * 广度优先搜索
     * 从一个特定点开始，访问所有邻接的节点。然后对于这些邻接节点，依然通过访问邻接节点的方式，直到访问所有可以到达的节点。
     * 按照一层一层的方式访问节点。使用 visited 数组记录是否被访问过。
     * 增加 count 变量当一个连通块已经访问完但是还有节点没有被访问的时候。
     *
     * @param M
     * @return
     */
    public int findCircleNumBfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int poll = queue.remove();
                    visited[poll] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[poll][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 并查集
     *
     * @param M
     * @return
     */
    public int findCircleNumUf(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        FindCircleNum obj = new FindCircleNum();
        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(obj.findCircleNumDfs(M));
        System.out.println(obj.findCircleNumBfs(M));
        System.out.println(obj.findCircleNumUf(M));
        M = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println(obj.findCircleNumDfs(M));
        System.out.println(obj.findCircleNumBfs(M));
        System.out.println(obj.findCircleNumUf(M));
    }
}
