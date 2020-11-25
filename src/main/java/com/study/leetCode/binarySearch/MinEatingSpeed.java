package main.java.com.study.leetCode.binarySearch;

/**
 * @author： whb
 * @description： LeetCode-875-爱吃香蕉的珂珂
 * @date： 2020-11-25 18:08
 * 难度：中等
 * 标签：二分查找
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * 
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 
 * 示例 3：
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * 
 * 
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class MinEatingSpeed {
    /**
     * 思路分析：
     * 
     * 珂珂吃香蕉的速度越小，耗时越多。反之，速度越大，耗时越少，这是这个问题的单调性；
     * 搜索的是速度。因为题目限制了珂珂一个小时之内只能选择一堆香蕉吃，因此速度最大值就是这几堆香蕉中，数量最多的那一堆。速度的最小值是 11，其实还可以再分析一下下界是多少，由于二分搜索的时间复杂度很低，严格的分析不是很有必要；
     * 还是因为珂珂一个小时之内只能选择一堆香蕉吃，因此：每堆香蕉吃完的耗时 = 这堆香蕉的数量 / 珂珂一小时吃香蕉的数量，这里的 / 在不能整除的时候，需要 上取整。
     * 特别注意：
     * 
     * 当目前的速度恰好使得珂珂在规定的时间内吃完香蕉的时候，还应该去尝试更小的速度是不是还可以保证在规定的时间内吃完香蕉。
     *
     * @param piles
     * @param H
     * @return
     */
    public static int minEatingSpeed(int[] piles, int H) {
        //low：速度最小的时候，耗时最长
        // high：速度最大的时候，耗时最短
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while (low < high) {
            int middle = low + ((high - low) >> 1);
            int need = 0;
            for (int pile : piles) {
                need += pile / middle;
                if (pile % middle != 0) {
                    need++;
                }
            }
            if (need > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间在[middle + 1, high]
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
