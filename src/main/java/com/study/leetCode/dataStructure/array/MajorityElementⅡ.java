package main.java.com.study.leetCode.dataStructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-229-求众数Ⅱ
 * @date： 2020-11-30 11:09
 * 难度：中等
 * 标签：数组
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：[3]
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class MajorityElementⅡ {
    /**
     * 摩尔投票
     *多数投票升级版：
     *
     * 超过n/3的数最多只能有两个。先选出两个候选人A,B。 遍历数组，分三种情况：
     *
     * 1.如果投A（当前元素等于A），则A的票数++;
     *
     * 2.如果投B（当前元素等于B），B的票数++；
     *
     * 3.如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0：
     *
     * 3.1 如果为0,则当前元素成为新的候选人；
     *
     * 3.2 如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一；
     * 遍历结束后选出了两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数。
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        // 初始化两个候选人candidate，和他们的计票
        int count1 = 0, count2 = 0, m1 = nums[0], m2 = nums[0];
        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段：先计算出现次数前二的两个数
        for (int num : nums) {
            // 投票
            if (num == m1) {
                count1++;
            } else if (num == m2) {
                count2++;
            } else if (count1 == 0) {
                // 第1个候选人配对
                m1 = num;
                count1++;
            } else if (count2 == 0) {
                // 第2个候选人配对
                m2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // 计数阶段：找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == m1) {
                count1++;
            }
            if (num == m2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) {
            res.add(m1);
        }
        if (count2 > nums.length / 3) {
            res.add(m2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{1}));
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
