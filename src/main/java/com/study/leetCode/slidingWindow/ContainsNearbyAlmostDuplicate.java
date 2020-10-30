package main.java.com.study.leetCode.slidingWindow;

import java.util.TreeSet;

/**
 * @author： whb
 * @description： LeetCode-220-存在重复元素Ⅲ
 * @date： 2020-10-30 11:52
 * 难度：中等
 * 标签：排序、Ordered Map
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class ContainsNearbyAlmostDuplicate {
    /**
     * TreeSet+滑动窗口
     * TreeSet 中有一个方法 public E ceiling(E e) ，返回 treeSet 中大于等于 e 的元素中最小的元素，如果没有大于等于 e 的元素就返回 null。
     * <p>
     * 还有一个对应的方法，public E floor(E e)，返回 treeSet 中小于等于 e 的元素中最大的元素，如果没有小于等于 e 的元素就返回 null。
     * <p>
     * 并且两个方法的时间复杂度都是 O(log(n))。
     * <p>
     * 利用滑动窗口，举个例子。
     * <p>
     * k = 3,  t = 2, 窗口内 3 个数用 TreeSet 存储, 当前考虑 x
     * 2 6 3 x 5
     * ^   ^
     * 此时我们去寻找窗口中是否存在 x - t ~ x + t 的元素。
     * <p>
     * 如果我们调用 ceilling(x - t) 返回了 c，c 是窗口内大于等于 x - t 中最小的数。
     * 只要 c 不大于 x + t, 那么 c 一定是我们要找的了。否则的话，窗口就继续右移。
     * <p>
     * 整个算法的伪代码思路：
     * <p>
     * 1、初始化一颗空的二叉搜索树 set；
     * 2、对于每个元素x，遍历整个数组；
     * 3、在 set 上查找大于等于x的最小的数，如果s - x ≤t则返回 true；
     * 4、在 set 上查找小于等于x的最大的数，如果x - g ≤t则返回 true；
     * 5、在 set 中插入x；
     * 6、如果树的大小超过了k, 则移除最早加入树的那个数。
     * 7、返回 false
     * 我们把大于等于 x 的最小的数 s 当做 x 在 BST 中的后继节点。同样的，我们能把小于等于 x 最大的数 g 当做 x 在 BST 中的前继节点。
     * s 和 g 这两个数是距离 x 最近的数。因此只需要检查它们和 x 的距离就能知道条件二是否满足了。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer celling = set.ceiling(nums[i]);
            if (celling != null && nums[i] <= celling + t) {
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= floor + t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 1, 1}, 1, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));
    }
}
