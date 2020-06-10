package main.java.com.study.leetCode.binarySearch;

/**
 * @author: whb
 * @date: 2020/6/10 11:40
 * @description: LeetCode-33-搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchRotateArr {
    /**
     * 双指针，指向头尾，拿着target和数组中间元素nums[mid]比较，分三种情况判断：
     * （1）若相等则直接mid就是答案；
     * （2）如果nums[mid]大于等于头元素，并且目标值在它和头元素之间，则尾指针变为mid - 1,否则头指针变为mid + 1;
     * （3）如果nums[mid]比头元素小，并且目标值在尾元素和中间元素之间，那么头指针就变为mid + 1,否则尾指针变为mid - 1；
     * 如果全部没有找到目标值相匹配的元素，或者数组长度为空，就返回-1即可
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] >= nums[left]) {
                if (nums[middle] > target && target >= nums[left]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
