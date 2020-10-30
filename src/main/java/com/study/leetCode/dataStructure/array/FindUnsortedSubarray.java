package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author： whb
 * @description： LeetCode-581-最短无序连续子数组
 * @date： 2020-10-30 10:30
 * 难度：中等
 * 标签：数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class FindUnsortedSubarray {
    /**
     * 从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，记录需要调整的最大位置 i 为 high;
     * 同理，从右到左循环，记录最小值为 min, 若 nums[i] > min, 则表明位置 i 需要调整，循环结束，记录需要调整的最小位置 i 为 low.
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int high = 0, low = len - 1, max = nums[0], min = nums[len - 1];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            if (nums[i] < max) {
                high = i;
            }
            if (nums[len - 1 - i] > min) {
                low = len - 1 - i;
            }
        }
        return high > low ? high - low + 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
