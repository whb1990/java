package main.java.com.study.leetCode.binarySearch;

/**
 * @author: whb
 * @date: 2020/3/18 15:55
 * @description: LeetCode-153-寻找旋转数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMin {
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        if (nums[high] > nums[low]) {
            return nums[low];
        }
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] < nums[high]) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return nums[low];
    }

    /**
     * 这个方法就是上面的改进，上了很多判断
     *
     * @param nums
     * @return
     */
    public static int findMin2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] <= nums[high]) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(findMin2(nums));
    }
}
