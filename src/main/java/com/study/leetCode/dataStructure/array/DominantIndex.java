package main.java.com.study.leetCode.dataStructure.array;

/**
 * @author: whb
 * @date: 2020/5/30 17:48
 * @description: LeetCode-747-至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 */
public class DominantIndex {
    /**
     * 解法一：先求出最大值，再将最大值与每个值比较是否两倍以上
     *
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (max < 2 * nums[i] && i != maxIndex) {
                return -1;
            }
        }
        return maxIndex;
    }

    /**
     * 解法二：求出最大值和第二大值，判断最大值是否是第二大值的两倍以上就可以
     *
     * @param nums
     * @return
     */
    public static int dominantIndex2(int[] nums) {
        int max = 0, secondMax = 0, maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                //最大值小于当前值，则将最大值赋值给第二大值，当前值赋值给最大值，记录最大值的下标
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (secondMax < nums[i]) {
                //当前值比第二大值大，则更新第二大值
                secondMax = nums[i];
            }
        }
        return max < 2 * secondMax ? -1 : maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{0, 0, 1, 0}));
    }
}
