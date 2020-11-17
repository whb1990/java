package main.java.com.study.leetCode.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-228-汇总区间
 * @date： 2020-11-17 9:49
 * 难度：简单
 * 标签：数组
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * 示例 3：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：["-1"]
 *
 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 *
 *
 * 提示：
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 */
public class SummaryRange {
    /**
     * 双指针解法
     * 用两个指针一个保存区间起点，一个保存终点。
     * 当数字是连续的时候,通过nums[i] + 1 === nums[i+1]可以判断是否连续
     *
     * 如果连续，那么把这个i加入区间。 end = i
     * 如果不连续，那么把这个区间剪掉，保存，并且重新开始一个新区间即可。start = end = i+1
     * @param nums
     * @return
     */
    public static List<String> summaryRange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                res.add(nums[j] + "");
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(summaryRange(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRange(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRange(new int[]{}));
        System.out.println(summaryRange(new int[]{-1}));
        System.out.println(summaryRange(new int[]{0}));
    }
}
