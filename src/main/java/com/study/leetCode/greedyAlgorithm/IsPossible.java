package main.java.com.study.leetCode.greedyAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-659-分割数组为连续子序列
 * @date： 2020-12-04 15:54
 * 难度：中等
 * 标签：堆、贪心算法
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * 提示：
 * 输入的数组长度范围为 [1, 10000]
 */
public class IsPossible {
    /**
     * 贪心算法
     * 算法思路
     * 1、首先使用两个哈希 map countMap和tailMap：
     *    countMap：存储原数组中数字i出现的次数。
     *    tailMap：存储以数字i结尾的且符合题意的连续子序列个数。
     * 2、先去寻找一个长度为3的连续子序列 i, i+1, i+2，找到后就将 countMap.get(i), countMap.get(i + 1), countMap.get(i + 2) 中对应数字消耗1个（即-1），并将 tailMap.get(i + 2) 加 1，即以 i+2 结尾的子序列个数 +1。
     * 3、如果后续发现有能够接在这个连续子序列的数字 i+3，则延长以 i+2 为结尾的连续子序列到 i+3，此时消耗 countMap.get(i + 3) 一个，由于子序列已延长，因此tailMap.get(i + 2) 减 1，tailMap.get(i + 3) 加 1。
     * 4、在不满足上面的情况下：
     *   如果 countMap.get(i) 为 0，说明这个数字已经消耗完，可以不管了。
     *   如果 countMap.get(i) 不为 0，说明这个数字多出来了，且无法组成连续子序列，所以可以直接返回 false 了。
     * 5、因此，只有检查到某个数时，这个数未被消耗完，且既不能和前面组成连续子序列，也不能和后面组成连续子序列时，无法分割。
     *
     * 举例
     * 以 nums=[1,2,3,3,4,4,5] 为例
     * 1、初始化：countMap.get(1)=1、countMap.get(2)=1、countMap.get(3)=2、countMap.get(4)=2、countMap.get(5)=1，tailMap.get(i)都为0。
     * 2、检查数字 1, countMap.get(1)>0,并且 countMap.get(2)>0,countMap.get(3)>0，因此找到了一个长度为3的连续子序列 countMap.get(1)、countMap.get(3)、countMap.get(1) 各自减一，并 tailMap.get(3) 加 1，此时有：
     *   countMap.get(1)=0、countMap.get(2)=0、countMap.get(3)=1、countMap.get(4)=2、countMap.get(5)=1 tailMap.get(3)=1
     * 3、检查数字 2，发现 countMap.get(2) 为 0，跳过（已经被消耗完了）。
     * 4、检查数字 3，发现 countMap.get(3)>0,但是 tailMap.get(2)=0，因此不能接在前面，只能往后看(如果后面组不成，那就返回 false了),实际发现 countMap.get(4)>0,countMap.get(5)>0，因此找到了一个长度为3的连续子序列 countMap.get(3)、countMap.get(4)、countMap.get(5) 各自减一，并 tailMap.get(5) 加 1，此时有：
     *  countMap.get(1) = 0、countMap.get(2)=0、countMap.get(3)=0、countMap.get(4)=1、countMap.get(5)=0 tailMap.get(3)=1、tailMap.get(5)=1
     * 5、检查第二个数字 3，countMap.get(3)=0，跳过。
     * 6、检查数字 4，countMap.get(4)>0，又有 tailMap.get(3)>0，说明有一个以3结尾的连续子序列，因此可以将其延长，所以countMap.get(4)减1，tailMap.get(3)减1,tailMap.get(4)加1,此时有：
     *    countMap.get(1) = 0、countMap.get(2)=0、countMap.get(3)=0、countMap.get(4)=0、countMap.get(5)=0 tailMap.get(3)=0、tailMap.get(4)=1、tailMap.get(5)=1
     * 7、检查数字 5，countMap.get(5)=0，跳过。
     * 8、遍历完所有数字，返回 true。
     * @param nums
     * @return
     */
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(),
                tailMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (countMap.getOrDefault(num, 0) == 0) {
                continue;
            } else if (countMap.getOrDefault(num, 0) > 0 && tailMap.getOrDefault(num - 1, 0) > 0) {
                countMap.put(num, countMap.get(num) - 1);
                tailMap.put(num - 1, tailMap.get(num - 1) - 1);
                tailMap.put(num, tailMap.getOrDefault(num, 0) + 1);
            } else if (countMap.getOrDefault(num, 0) > 0 && countMap.getOrDefault(num + 1, 0) > 0 && countMap.getOrDefault(num + 2, 0) > 0) {
                countMap.put(num, countMap.get(num) - 1);
                countMap.put(num + 1, countMap.get(num + 1) - 1);
                countMap.put(num + 2, countMap.get(num + 2) - 1);
                tailMap.put(num + 2, tailMap.getOrDefault(num + 2, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
    }
}
