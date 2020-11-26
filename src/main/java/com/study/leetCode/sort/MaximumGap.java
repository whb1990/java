package main.java.com.study.leetCode.sort;

/**
 * @author： whb
 * @description： LeetCode-164-最大间距
 * @date： 2020-11-26 8:49
 * 难度：困难
 * 标签：排序
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class MaximumGap {
    /**
     * 桶排序也是计数排序的一种，普通的计数排序相当于极端情况下每个桶的区间大小是 1 ，而这里说的桶排序肯定不是这种极端情况，每个桶的区间大小相等，但依然是遍历元素对号入座(放入对应的区间里)。
     *
     * 桶排序的重点就在于，如何规划桶区间的大小和个数，使尽可能少的桶，去覆盖所有的元素。
     *
     * 规划桶大小和数量，必然要知道输入的区间，所以需要知道输入最大元素 max 、最小元素 min，从而知道输入区间总长度 max - min ，用 输入区间总长度/区间个数 得到桶的大小 bucketSize。（区间个数 = 元素个数 - 1）
     *
     * 有了桶的大小，就不难得到桶的数量 (max-min)/bucketSzie + 1 ，为什么要 +1 多一个桶呢？
     *
     * 因为桶内的区间都是前闭后开的，形如 [min,a)、[b,c)、[d,e)、[f,max)，所以如果不 +1 生成的桶将不包含边界值 max 。因此 +1 是为了方便编码，不需要单独去处理边界值 max 。
     *
     * 最后就是找最大间距了！最大间距一定 >= 输入区间大小/输入区间的数量！
     *
     * 最大间隔一定不会出现在同一个桶内，因此只需要比较桶之间的差值，每个桶内记录最大值、最小值即可！
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        //找到数组最小值、最大值
        int min = 0, max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        //计算桶大小，桶数量至少是一个
        int bucketSize = Math.max((max - min) / (nums.length - 1), 1);
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        //入桶，每个桶只关心桶内的最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - min) / bucketSize;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new Bucket();
            }
            buckets[bucketIndex].min = Math.min(nums[i], buckets[bucketIndex].min);
            buckets[bucketIndex].max = Math.max(nums[i], buckets[bucketIndex].max);
        }
        //前一个桶的max
        int preMax = -1;
        //最大间隔
        int maxGap = 0;
        for (int i = 0; i < buckets.length; i++) {
            //桶不为空，并且不是第一个桶
            if (buckets[i] != null && preMax != -1) {
                //桶之间的间隔
                maxGap = Math.max(maxGap, buckets[i].min - preMax);
            }
            //记录前一个桶的 max
            if (buckets[i] != null) {
                preMax = buckets[i].max;
            }
        }
        return maxGap;
    }

    //桶结构,桶内只关心最大值、最小值
    class Bucket {
        public int min = Integer.MIN_VALUE;
        public int max = Integer.MAX_VALUE;
    }
}
