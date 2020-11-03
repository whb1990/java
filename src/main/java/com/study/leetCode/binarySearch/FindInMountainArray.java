package main.java.com.study.leetCode.binarySearch;

/**
 * @author： whb
 * @description： LeetCode-1095-山脉数组中查找目标值
 * @date： 2020-11-03 9:45
 * 难度：困难
 * 标签：二分查找
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * <p>
 * 如果不存在这样的下标 index，就请返回 -1。
 * <p>
 * <p>
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * <p>
 * 首先，A.length >= 3
 * <p>
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * <p>
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * <p>
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * <p>
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 * <p>
 * 注意：
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 * <p>
 * 示例 1：
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * <p>
 * 示例 2：
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 * <p>
 * 提示：
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 */
public class FindInMountainArray {
    /**
     * 三次二分查找寻找目标值的最小下标
     */
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        //注意使用闭区间，如果使用开区间，在[size - 1, size)时mid取左中位数，mid + 1会溢出，所以用闭区间
        int left = 0, right = mountainArr.length() - 1;
        //第一次二分，寻找峰值
        //对于一个范围 [i, j]，可以先找到范围 [i, j] 中间连续的两个点 mid 与 mid + 1。
        // 如果 mountainArr.get(mid + 1) > mountainArr.get(mid)，那么可以知道峰值在范围 [mid + 1, j] 内；
        // 如果 mountainArr.get(mid + 1) < mountainArr.get(mid)，那么可以知道峰值在范围 [i, mid] 内。
        // 通过这样的方法，可以在 O(logn) 的时间内找到峰值所处的下标。
        while (left < right) {
            //取左中位数，因为进入循环，数组一定至少有2个元素
            //因此左中位数一定有右边元素，数组下标不会越界
            int mid = left + ((right - left) >> 1);
            //mid所指的值大于等于mid + 1，那么山峰在数组左边，应该向左靠近
            if (mountainArr.get(mid) >= mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                //mid所指的值小于mid + 1,那么山峰在数组的右边，应该向右靠近
                left = mid + 1;
            }
        }
        //根据题意山峰一定存在，所以不用特判
        int peak = left;
        //第二次二分查找，在左半部分升序数组中寻找target
        left = 0;
        right = peak;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //在左边找到target，直接返回下标，否则在右半部分查找
        if (mountainArr.get(left) == target) {
            return left;
        }
        //第三次二分查找，在右半部分降序数组中寻找target
        left = peak + 1;
        right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) <= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //在右半部分找到target后，直接返回下边，否则返回-1
        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }

    static class MountainArray {
        private int[] array;

        public MountainArray(int[] array) {
            this.array = array;
        }

        public int length() {
            return array.length;
        }

        public int get(int index) {
            if (index < 0 || index >= array.length) {
                throw new IllegalArgumentException("index is illegal.");
            }
            return array[index];
        }
    }

    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        System.out.println(findInMountainArray(3, mountainArray));
        mountainArray = new MountainArray(new int[]{0, 1, 2, 4, 2, 1});
        System.out.println(findInMountainArray(3, mountainArray));
    }
}
