package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-477-汉明距离总和
 * @date： 2020-10-14 18:39
 * 难度：中等
 * 标签：数学、位运算
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 示例:
 * 输入: 4, 14, 2
 * <p>
 * 输出: 6
 * <p>
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 * <p>
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 */
public class TotalHammingDistance {
    /**
     * 将所有数转换成二进制，先看第0位，求任意两个数第0位的汉明距离的总和。
     * 从左往右遍历数组，当遍历到第i个数nums[i]时，nums[i]第0位能贡献的汉明距离等于i左边所有数的第0位与nums[i]的第0位不同的数个数，
     * 本来还需要加上右边的数，但为了避免重复计算，只看左边的数，所以可以一边遍历一边统计出现的0和1的个数。
     * 这样当遍历完数组，就可以得到所有数的第0位能贡献的汉明距离。而题目的答案就是求出所有位能贡献的汉明距离
     *
     * @param nums
     * @return
     */
    public static int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //0的个数
            int total_0 = 0;
            //1的个数
            int total_1 = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) == 0) {
                    //当前数的对应位为0，所以加上左边1的个数
                    res += total_1;
                    total_0++;
                } else {
                    //当前数的对应位为1，所以加上左边0的个数
                    res += total_0;
                    total_1++;
                }
                nums[j] >>>= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
    }
}
