package main.java.com.study.leetCode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/7/11 10:33
 * @description: LeetCode-315-计算右侧小于当前元素的个数
 * 难度：困难
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class CountSmaller {
    /**
     * 可以对nums数组进行从后往前进行遍历，然后放入到arrayList中排好顺序，
     * 当便利nums[i]的时候，可以使用二分查找得到插入的位置
     * <p>
     * 二分查找需要O(lgN),但是插入的过程复杂度为O(n)
     * 算法复杂度：O(N^2)
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Integer[] result = new Integer[nums.length];
        //将每个数插入到list中，使用二分查找
        for (int i = nums.length - 1; i >= 0; i--) {
            int start = 0, end = list.size();
            while (start < end) {
                //判断中间的数
                int middle = start + (end - start) / 2;
                //严格小于的话，只能在后面部分，并且不包含middle
                if (list.get(middle) < nums[i]) {
                    start = middle + 1;
                } else {
                    end = middle;
                }
            }
            result[i] = start;
            list.add(start, nums[i]);
        }
        System.out.println(Arrays.toString(result));
        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        countSmaller(new int[]{5, 2, 6, 1});
    }
}
