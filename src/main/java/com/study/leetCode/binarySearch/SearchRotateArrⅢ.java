package main.java.com.study.leetCode.binarySearch;

/**
 * @author： whb
 * @description： LeetCode-面试题10.03.搜索旋转数组
 * @date： 2020-11-25 15:12
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 示例1:
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * <p>
 * 示例2:
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * 提示:
 * <p>
 * arr 长度范围在[1, 1000000]之间
 */
public class SearchRotateArrⅢ {
    /**
     * 对于能判断升序区间的情况，根据目标值的大小移动边界。
     * 对于不能判断升序区间的情况，需要逐步清除重复值。
     *
     * 没有重复值的最优情况时间复杂度是O(log N)，全部或几乎全部是重复值的最差情况时间复杂度是O(N)。
     *
     *                                     nums[left] <= target
     *                               ┌─  && target <= nums[mid]   ──>  right = mid
     *                               │   （目标在左边的升序区间中）         （右边界移动到mid）
     *   ┌─  nums[left] < nums[mid] ─┼
     *   │     （左边区间升序）         │
     *   │                           └─    否则目标在右半边          ──>  left = mid + 1
     *   │                                                             （左边界移动到mid+1）
     *   │
     *   │                                 nums[left] <= target
     *   │                           ┌─  || target <= nums[mid]   ──>  right = mid
     *   │                           │    （目标在左半边）                （右边界移动到mid）
     *  ─┼─  nums[left] > nums[mid] ─┼
     *   │     （左边不是升序）         │
     *   │                           └─    否则目标在右半边          ──>  left = mid + 1
     *   │                                                              （左边界移动到mid+1）
     *   │
     *   │
     *   │                           ┌─   nums[left] != target    ──>  left++
     *   │                           │     （左值不等于目标               （需要逐一清理重复值）
     *   └─ nums[left] == nums[mid] ─┼         说明还没找到）
     *       （可能是已经找到了目标      │
     *         也可能是遇到了重复值）    └─   nums[left] == target    ──>  right = left
     *                                     （左值等于目标                 （将右边界移动到left，循环结束）
     *                                       已经找到最左边的目标值）
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (right == -1) {
            return -1;
        }
        //循环结束条件是left == right
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            //如果左值小于中值，说明左边区间升序
            if (nums[left] < nums[middle]) {
                // 如果目标在左边的升序区间中，右边界移动到middle
                if (nums[left] <= target && target <= nums[middle]) {
                    right = middle;
                } else {
                    // 否则目标在右半边，左边界移动到middle+1
                    left = middle + 1;
                }
            }
            // 如果左值大于中值，说明左边不是升序，右半边升序
            else if (nums[left] > nums[middle]) {
                // 如果目标在左边，右边界移动到middle
                if (nums[left] <= target || target <= nums[middle]) {
                    right = middle;
                } else {
                    // 否则目标在右半边，左边界移动到middle+1
                    left = middle + 1;
                }
            }
            // 如果左值等于中值，可能是已经找到了目标，也可能是遇到了重复值
            else if (nums[left] == nums[middle]) {
                // 如果左值不等于目标，说明还没找到，需要逐一清理重复值。
                if (nums[left] != target) {
                    left++;
                } else {
                    // 如果左值等于目标，说明已经找到最左边的目标值
                    return left;
                }
            }
        }
        // 未找到返回-1
        return -1;
    }

    public static void main(String[] args) {
        //8
        System.out.println(search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
        //-1
        System.out.println(search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 11));
        //0
        System.out.println(search(new int[]{5, 5, 5, 1, 2, 3, 4, 5}, 5));
        //0
        System.out.println(search(new int[]{2, 1, 2, 2}, 2));
    }
}
