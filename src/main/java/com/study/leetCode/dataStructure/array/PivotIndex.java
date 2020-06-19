package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author: whb
 * @date: 2020/5/30 17:33
 * @description: LeetCode-724-寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * <p>
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2:
 * <p>
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 */
public class PivotIndex {
    /**
     * 三个sum存放三个和，先算出一个总sum来是为了下面计算方便，然后移动一个从左到右的cursor，注意cursor在第一个元素时需要单独考虑。分别算出cursor左边还有右边的值然后比对，返回cursor。
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int sum = 0, sumLeft = 0, sumRight = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            sumLeft += i == 0 ? 0 : nums[i - 1];
            sumRight = sum - sumLeft - nums[i];
            if (sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
    }
}
