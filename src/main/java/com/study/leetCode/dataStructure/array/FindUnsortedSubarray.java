package main.java.com.study.leetCode.dataStructure.array;

import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-581-最短无序连续子数组
 * @date： 2020-10-30 10:30
 * 难度：中等
 * 标签：数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
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

    /**
     * 栈解法
     * 这个方法背后的想法是选择排序。需要找到无序子数组中最小元素和最大元素分别对应的正确位置，来求得要的无序子数组的边界。
     * <p>
     * 从头遍历 nums数组，如果遇到的数字大小一直是升序的，就不断把对应的下标压入栈中，这么做的目的是因为这些元素在目前都是处于正确的位置上。
     * 一旦遇到前面的数比后面的数大，也就是 nums[j] 比栈顶元素小，就可以知道 nums[j] 一定不在正确的位置上。
     * <p>
     * 为了找到 nums[j]的正确位置，需要不断将栈顶元素弹出，直到栈顶元素比 nums[j]小，我们假设栈顶元素对应的下标为 k ，那么我们知道 nums[j] 的正确位置下标应该是 k + 1 。
     * <p>
     * 重复这一过程并遍历完整个数组，这样我可以找到最小的 k， 它也是无序子数组的左边界。
     * <p>
     * 类似的，逆序遍历一遍 nums数组来找到无序子数组的右边界。这一次我们将降序的元素压入栈中，如果遇到一个升序的元素，像上面所述的方法一样不断将栈顶元素弹出，直到找到一个更大的元素，以此找到无序子数组的右边界。
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarrayStack(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int left = nums.length, right = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right > left ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarrayStack(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarrayStack(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
