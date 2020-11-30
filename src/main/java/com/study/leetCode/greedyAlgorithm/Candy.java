package main.java.com.study.leetCode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-135-分发糖果
 * @date： 2020-11-30 16:51
 * 难度：困难
 * 标签：贪心算法
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * <p>
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Candy {
    /**
     * 贪心算法，两次遍历：
     * 1、把所有孩子的糖果数初始化为 1；
     * 2、先从左往右遍历一遍，如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的
     * 糖果数加 1；
     * 3、再从右往左遍历一遍，如果左边孩子的评分比右边的高，且左边孩子当前的糖果数
     * 不大于右边孩子的糖果数，则左边孩子的糖果数更新为右边孩子的糖果数加 1。
     *
     * 这里的贪心策略为，在每次遍历中，只考虑并更新相邻一侧的大小关系。
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length < 2) {
            return ratings.length;
        }
        //记录每一位孩子得到的糖果数
        int[] candies = new int[ratings.length];
        //初始每个孩子一个糖果
        Arrays.fill(candies, 1);
        //先正序遍历，如果后一位比前一位高分，就给比前一位多1的糖果
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        //在倒叙遍历，如果前一位比后一位高分并且得到的糖果小于或等于后一位，就给前一位孩子比后一位孩子多一个糖果
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        //计算总的糖果数
        int res = 0;
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }

    public static void main(String[] args) {
        //5
        System.out.println(candy(new int[]{1, 0, 2}));
        //4
        System.out.println(candy(new int[]{1, 2, 2}));
        //7
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));
        //11
        System.out.println(candy(new int[]{1, 3, 4, 5, 2}));
    }
}
