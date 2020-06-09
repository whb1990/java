package main.java.com.study.leetCode.dataStructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/6/9 18:35
 * @description: LeetCode-219-存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    /**
     * 解法一：双重循环，会重复计算
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j - i <= k; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法二：改良解法一，用hashMap记录已经计算的值
     * 将元素本身存储为key，其索引存储为value，如果散列表中无此key时，直接存储，当存在该key时，判断索引之差是否大于k，是则将之前索引替换为当前索引继续遍历，否则直接返回true，最后循环外直接返回false，因为没有符合要求的元素。 
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearByDuplicate2(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], i);
            } else {
                int temp = hashMap.get(nums[i]);
                if (i - temp <= k) {
                    return true;
                }
                hashMap.put(nums[i], i);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
        nums = new int[]{1, 0, 1, 1};
        k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
        nums = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
