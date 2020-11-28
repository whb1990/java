package main.java.com.study.leetCode.dataStructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-442-数组中重复的数据
 * @date： 2020-11-28 10:37
 * 难度：中等
 * 标签：数组
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
public class FindDuplicates {
    /**
     * 计数排序
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        int[] buckets = new int[nums.length + 1];
        for (int num : nums) {
            buckets[num]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] == 2) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 负号标记
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] *= -1;
            } else {
                res.add(x);
            }
        }
        return res;
    }

    /**
     * 原地置换
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(0, nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=============计数排序==============");
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println("=============负号标记==============");
        System.out.println(findDuplicates2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println("=============原地置换==============");
        System.out.println(findDuplicates3(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
