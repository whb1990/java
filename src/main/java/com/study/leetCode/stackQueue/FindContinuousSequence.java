package main.java.com.study.leetCode.stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: whb
 * @date: 2020/3/7 19:39
 * @description: LeetCode面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class FindContinuousSequence {
    /**
     * 滑动窗口算法
     *
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int start = 1, end = (int) Math.floor(target >> 1) + 1;
        int sum = start;
        queue.add(start);
        while (start <= end) {
            ++start;
            if (sum < target) {
                sum += start;
                queue.add(start);
            } else if (sum > target) {
                sum -= queue.remove();
                --start;
            } else {
                int[] tmp = new int[queue.size()];
                for (int i = 0; i < queue.size(); i++) {
                    tmp[i] = queue.get(i);
                }
                result.add(tmp);
                sum -= queue.removeFirst();
                --start;
            }
        }
        int[][] resultArr = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    /**
     * 暴力求解
     *
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence2(int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            Integer sum = 0;
            List<Integer> numList = new ArrayList<>();
            for (int j = i; j < target; j++) {
                sum = sum + j;
                if (sum < target) {
                    numList.add(j);
                } else if (sum == target) {
                    numList.add(j);
                    result.add(numList);
                    break;
                } else {
                    numList = new ArrayList<Integer>();
                    break;
                }
            }
        }
        int[][] resultArr = new int[result.size()][];
        List<Integer> tmpList = null;
        for (int i = 0; i < result.size(); i++) {
            tmpList = result.get(i);
            int[] tmpArr = new int[tmpList.size()];
            for (int j = 0; j < tmpList.size(); j++) {
                tmpArr[j] = tmpList.get(j);
            }
            resultArr[i] = tmpArr;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[][] result = findContinuousSequence(15);
        for (int[] tmpArr : result) {
            for (int tmp : tmpArr) {
                System.out.print(tmp + ",");
            }
            System.out.println(" ");
        }
        int[][] result2 = findContinuousSequence2(15);
        for (int[] tmpArr : result2) {
            for (int tmp : tmpArr) {
                System.out.print(tmp + ",");
            }
            System.out.println(" ");
        }
    }
}
