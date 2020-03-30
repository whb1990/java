package main.java.com.study.leetCode.binarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/3/18 14:29
 * @description: LeetCode-540-有序数组中的单一元素
 */
public class SingleNonDuplicate {
    /**
     * 最容易想到的方法，HashMap统计
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 位运算（异或：相同为0，不同为1）
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    /**
     * 使用二分搜索，需要查看中间的元素来判断答案在中间，左边还是右边。数组个数始终是奇数，因为有一个元素出现一次，其余元素出现两次。
     * <p>
     * 当我们从中心移除一对元素时发生的情况。将剩下左子数组和右子数组。
     * <p>
     * 与原数组一样，包含单个元素的子数组元素个数必为奇数，不包含单个元素的子数组必为偶数。 因此，当原数组移除一对元素后，然后计算出哪一侧的子数组元素个数是奇数，这样就能够知道下一步应该在哪一侧进行搜索。
     * <p>
     * 算法思路：
     * <p>
     * 首先将 lo 和 hi 指向数组首尾两个元素。然后进行二分搜索将数组搜索空间减半，直到找到单一元素或者仅剩一个元素为止。当搜索空间只剩一个元素，则该元素就是单个元素。
     * 在每个循环迭代中，我们确定 mid，变量 halvesAreEven = (hi - mid) % 2 == 0。 通过查看中间元素同一元素为哪一个（左侧子数组中的最后一个元素或右侧子数组中的第一个元素），可以通过变量 halvesAreEven 确定现在哪一侧元素个数为奇数，并更新 lo 和 hi。
     * 最难的部分是根据 mid 和 halvesAreEven 的值正确更新 lo 和 hi。
     * 例子 1：中间元素的同一元素在右边，且被 mid 分成两半的数组为偶数。
     * <p>
     * 将右子数组的第一个元素移除后，则右子数组元素个数变成奇数，所以应该在右子数组寻找，所以应将 lo 设置为 mid + 2。
     * <p>
     * 例子 2：中间元素的同一元素在右边，且被 mid 分成两半的数组为奇数。
     * <p>
     * 将右子数组的第一个元素移除后，则右子数组的元素个数变为偶数，所以应该在左子数组中寻找，所以应将 hi 设置为 mid - 1。
     * <p>
     * 例子 3：中间元素的同一元素在左边，且被 mid 分成两半的数组为偶数。
     * <p>
     * 将左子数组的最后一个元素移除后，则左子数组的元素个数变为奇数，所以应该在左子数组中寻找，所以应将 hi 设置为 mid - 2。
     * <p>
     * 例子 4：中间元素的同一元素在左边，且被 mid 分成两半的数组为奇数。
     * <p>
     * 将左子数组的最后一个元素移除后，则左子数组的元素个数变为偶数，所以应该在右子数组中寻找，所以应将 lo 设置为 mid + 1。
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate3(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            boolean halvesAreEven = (high - middle) % 2 == 0;
            if (nums[middle + 1] == nums[middle]) {
                if (halvesAreEven) {
                    low = middle + 2;
                } else {
                    high = middle - 1;
                }
            } else if (nums[middle - 1] == nums[middle]) {
                if (halvesAreEven) {
                    high = middle - 2;
                } else {
                    low = middle + 1;
                }
            } else {
                return nums[middle];
            }
        }
        return nums[low];
    }

    /**
     * 二分搜索，只搜索偶数索引
     * 1、奇数长度的数组首尾元素索引都为偶数，因此我们可以将 lo 和 hi 设置为数组首尾。
     * 2、我们需要确保 mid 是偶数，如果为奇数，则将其减 1。
     * 3、然后，我们检查 mid 的元素是否与其后面的元素相同。
     * 4、如果相同，则我们知道 mid 不是单个元素。且单个元素在 mid 之后。则我们将 lo 设置为 mid + 2。
     * 5、如果不是，则我们知道单个元素位于 mid，或者在 mid 之前。我们将 hi 设置为 mid。
     * 6、一旦 lo == hi，则当前搜索空间为 1 个元素，那么该元素为单个元素，我们将返回它。
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate4(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (middle % 2 == 1) {
                middle--;
            }
            if (nums[middle + 1] == nums[middle]) {
                low = middle + 2;
            } else {
                high = middle;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate3(nums));
    }
}
