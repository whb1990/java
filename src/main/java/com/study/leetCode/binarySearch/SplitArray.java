package main.java.com.study.leetCode.binarySearch;

/**
 * @author: whb
 * @date: 2020/6/10 18:02
 * @description: LeetCode-410-分割数组的最大值
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class SplitArray {
    /**
     * 思路分析：首先需要两种特殊情况，如果m == nums.length，即将数组分割成数组元素个数个区间，则此时子区间和的最大值为数组最大元素值low；
     * 如果 m == 1，即将数组分割成一个子区间，则此时子区间的和的最大值为整个数组元素之和high。
     * 然后使用二分法，每次折中middle == low + (high - low) / 2;看在折中的情况下需要分多少个子区间，如果需要分的子区间个数大于m，说明我们给定的区间和值小了，
     * 然后取高端[middle + 1, high]继续二分，否则取低端[low, middle]继续二分。
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray(int[] nums, int m) {
        //在[low, high]的区间二分搜索，每个区间段的最大和
        int low = 0, high = 0;
        //low初始化为数组最大元素值，因为一个区间至少放一个元素，所以（区间段的最大和）最小值即为单个元素最大值；
        // high初始化为数组元素之和，因为最大的区间为初始的大区间，所以（区间段的最大和）为所有元素之和
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        //二分搜索
        while (low < high) {
            //middle为正在搜索的区间的和的期望值
            int middle = low + (high - low) / 2;
            //need为这种分割条件下子区间的个数，cur为当前正在划分的区间已经放入的值的和
            int need = 1, cur = 0;
            for (int num : nums) {
                //确定再每个区间和不超过middle的情况下，需要分割的子区间个数
                if (cur + num > middle) {
                    //超过了当前正在划分的区间的最大和的期望值，需要再开一个新区间
                    need++;
                    //新开子区间的元素和初始为0
                    cur = 0;
                }
                cur += num;
            }
            if (need > m) {
                //如果需要分割的子区间个数大于给定值，则说明区间和的期望值小了
                low = middle + 1;
            } else {
                //否则说明可能相等或大了
                high = middle;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
