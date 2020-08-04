package main.java.com.study.leetCode.dataStructure.image;

import java.util.LinkedList;

/**
 * @author: whb
 * @date: 2020/8/4 11:51
 * @description: LeetCode-207-课程表
 * 难度：中等
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * <p>
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 * <p>
 * 提示：
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class CanFinish {
    /**
     * 拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] cp : prerequisites) {
            //计算各个节点的入度
            indegree[cp[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //将入度为0的节点放入队列
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.remove();
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != pre) {
                    continue;
                }
                indegree[req[0]]--;
                if (indegree[req[0]] == 0) {
                    queue.offer(req[0]);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }
}
