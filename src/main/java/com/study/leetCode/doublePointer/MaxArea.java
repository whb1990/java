package main.java.com.study.leetCode.doublePointer;

/**
 * @author: whb
 * @date: 2020/8/12 10:31
 * @description: LeetCode-11-盛最多水的容器
 * 难度：中等
 * 标签：数组、双指针
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class MaxArea {
    /**
     * 双指针解法
     * 思路：
     * 1、定义两个指针left和right
     * 2、计算面积
     * 3、移动对应值小的下标
     * 思路解释：
     * 1、假设两个下标所对应的值2=height[left]，6=height[right]
     * 2、若此时移动较大的right，则移动后的值a=height[right–]
     * 3、此时长度减小了1，而且a要么等于2，要么小于2(等a大于2时，但是计算面积还是按较小的2去就算，所以a>2没有作用)，从而计算的面积存在两种情况，等于或小于原面积
     * 4、若此时移动较大的left，则移动后b=height[left++]
     * 5、此时长度减小了1，而b存在三种情况，b=2，b<2，b>2，所以计算面积也可能存在三种情况，所以面积有可能会增加
     * 6、所以每次都移动对应值较小的那个下标
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        //定义两个指针left和right，起始位置为0和height.length-1
        int left = 0, right = height.length - 1;
        //用于保存结果
        int result = 0;
        while (left < right) {
            //取下标所对应值中较小的计算面积
            int maxArea = Math.min(height[left], height[right]) * (right - left);
            //保存计算结果
            result = Math.max(result, maxArea);
            //移动值较小的所对应下标
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
