package main.java.com.study.leetCode.binarySearch;

/**
 * @author: whb
 * @date: 2020/6/10 16:31
 * @description: LeetCode-154-寻找旋转数组最小值Ⅱ
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * <p>
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 */
public class FindMinⅡ {
    /**
     * 如果序列旋转，序列去掉部分重复元素，会被分为两个序列，一个有序，一个无序，则最小值在无序序列。
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        //如果旋转了，最小值一定在无序序列
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] > nums[high]) {
                //说明旋转后右半段序列为无序，则最小值在右半段序列
                low = middle + 1;
            } else if (nums[middle] < nums[high]) {
                //若旋转说明左半段为无序，最小值在左半段;不旋转最小值也在左半段
                high = middle;
            } else {
                //如果相等，去除重复值
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 5}));
        System.out.println(findMin(new int[]{2, 2, 2, 0, 1}));
    }
}
