package main.java.com.study.leetCode.unionFind;

/**
 * @author： whb
 * @description： LeetCode-547-朋友圈
 * @date： 2020-11-20 15:42
 * 难度：中等
 * 标签：深度优先搜索、广度优先搜索、并查集
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

    public static void main(String[] args) {
        FindCircleNum obj = new FindCircleNum();
        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(obj.findCircleNumDfs(M));
        M = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println(obj.findCircleNumDfs(M));
    }
}
