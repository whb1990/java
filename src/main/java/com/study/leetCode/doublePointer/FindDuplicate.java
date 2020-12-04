package main.java.com.study.leetCode.doublePointer;

/**
 * @author: whb
 * @date: 2020/6/10 16:53
 * @description: LeetCode-287-寻找重复数
 * 难度：中等
 * 标签：数组、双指针、二分查找
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {
    /**
     * 利用快慢指针：指针的移动方法为 nextIndex = curValue.
     * 令快指针每次移动两个单位，慢指针移动一个单位。由于数组中存在重复元素，所以会构成一个环，
     * 所以快指针总会追上慢指针，追上之后需要找环的入口。假设数组重复元素为i，那么环的入口就是index = i的位置，找到环的入口就找到结果值。
     * 
     * 为什么说数组存在环，是因为数组长度为 n + 1，数组中的元素为1 ~ n，所以，你品，你细品。
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //设置快慢指针，快指针移动速度为慢指针的两倍，由于存在环，快指针会在环中追到慢指针
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                break;
            }
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    /**
     * 原地置换
     */
    public static int findDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    /**
     * 负号标记
     */
    public static int findDuplicate3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] *= -1;
            } else {
                return x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=========快慢指针=============");
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println("=========原地置换=============");
        System.out.println(findDuplicate2(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate2(new int[]{3, 1, 3, 4, 2}));
        System.out.println("=========负号标记=============");
        System.out.println(findDuplicate3(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate3(new int[]{3, 1, 3, 4, 2}));
    }
}
