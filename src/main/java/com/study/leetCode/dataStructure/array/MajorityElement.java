package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author： whb
 * @description： LeetCode-169-多数元素
 * @date： 2020-11-30 10:50
 * 难度：简单
 * 标签：数组
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    /**
     * 摩尔投票
     * 初始化：
     * 1、众数majority:初始值设置为数组的第一个元素；
     * 2、票数count:表示当前众数mode所获得的票数，初始值设置为0；
     *
     * 遍历，对每个元素进行如下操作：
     * 1、判断票数count是否为0：为0则将当前遍历的元素设置为众数majority;
     * 2、判断是否为众数majority：
     *    是 ==> count + 1；
     *    否 ==> count - 1；
     * 3、返回最终选举的众数majority。
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 1, majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = nums[i + 1];
                }
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
