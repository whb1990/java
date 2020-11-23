package main.java.com.study.leetCode.greedyAlgorithm;

/**
 * @author： whb
 * @description： LeetCode-45-跳跃游戏Ⅱ
 * @date： 2020-11-23 9:25
 * 难度：困难
 * 标签：数组、贪心算法
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Jump {
    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int res = 0, maxReach = 0, lastReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxReach) {
                // 能跳到最远的距离
                maxReach = Math.max(maxReach, i + nums[i]);
                if (maxReach >= nums.length - 1) {
                    res++;
                    break;
                }
            }
            // 遇到边界，就更新边界，并且步数加一
            if (i == lastReach) {
                res++;
                lastReach = maxReach;
            }
        }
        //返回跳跃次数
        return res;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
