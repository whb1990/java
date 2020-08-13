package main.java.com.study.leetCode.doublePointer;

/**
 * @author: whb
 * @date: 2020/8/13 20:37
 * @description: LeetCode-80-删除排序数组中的重复项Ⅱ
 * 难度：中等
 * 标签：数组、双指针
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesⅡ {
    /**
     * 最优解
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

    /**
     * 双指针解法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        //定义快慢指针
        int slow = 0, fast = 1, count = 0;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                //如果相邻的两个数相等，计数器+1
                count++;
            } else {
                //相邻的两个数不相等，计数器归零
                count = 0;
            }
            if (count < 2) {
                //如果计数器小于2， 则保留
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        //nums[0...slow]就是符合条件的数，nums[slow + 1...fast]保存的就是多余的数
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        System.out.println(removeDuplicates2(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates2(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
