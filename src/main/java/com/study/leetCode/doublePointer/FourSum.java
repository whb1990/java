package main.java.com.study.leetCode.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/8/18 10:06
 * @description: LeetCode-18-四数之和
 * 难度：中等
 * 标签：数组、哈希表、双指针
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //定义一个返回值
        List<List<Integer>> result = new ArrayList<>();
        //当数组为null或元素小于4个时，直接返回
        if (nums == null || nums.length < 4) {
            return result;
        }
        //数组从小到大排序
        Arrays.sort(nums);
        //数组长度
        int len = nums.length;
        //定义4个指针i，j，m，n  i从0开始遍历，j从i+1开始遍历，留下m和n，m指向j+1，n指向数组最大值
        for (int i = 0; i < len - 3; i++) {
            //当i的值与前面的值相等时忽略
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }
            //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
            int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max < target) {
                continue;
            }
            //第二层循环j，初始值指向i+1
            for (int j = i + 1; j < len - 2; j++) {
                //当j的值与前面的值相等时忽略
                if (j > i - 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //定义指针m指向j+1，指针n指向数组末尾
                int m = j + 1, n = len - 1;
                //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略
                int small = nums[i] + nums[j] + nums[m] + nums[m + 1];
                if (small > target) {
                    continue;
                }
                //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
                int largest = nums[i] + nums[j] + nums[n] + nums[n - 1];
                if (largest < target) {
                    continue;
                }
                //开始m指针和n指针的表演，计算当前和，
                // 如果等于目标值，m++并去重，n--并去重，
                // 当当前和大于目标值时n--，
                // 当当前和小于目标值时m++
                while (m < n) {
                    int num = nums[i] + nums[j] + nums[m] + nums[n];
                    if (num > target) {
                        n--;
                    } else if (num < target) {
                        m++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n - 1]) {
                            n--;
                        }
                        m++;
                        n--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
