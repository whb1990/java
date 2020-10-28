package main.java.com.study.leetCode.dp;

import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-42-接雨水
 * @date： 2020-10-28 16:53
 * 难度：困难
 * 标签：栈、双指针、动态规划
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class Trap {
    /**
     * 动态规划
     * 1、定义二维dp数组 int[][] dp = new int[n][2],
     * 其中，dp[i][0] 表示下标i的柱子左边的最大值，
     * dp[i][1] 表示下标i的柱子右边的最大值。
     * <p>
     * 2、分别从两头遍历height数组，为 dp[i][0]和 dp[i][1] 赋值。
     * <p>
     * 3、遍历每个柱子，累加每个柱子可以储水的高度。
     * <p>
     * 时间O(N) 空间O(N)
     *
     * @param height
     * @return
     */
    public static int trapDp(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        // 定义二维dp数组
        // dp[i][0] 表示下标i的柱子左边的最大值
        // dp[i][1] 表示下标i的柱子右边的最大值
        int[][] dp = new int[len][2];
        dp[0][0] = height[0];
        dp[len - 1][1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i]);
        }
        int res = 0;
        // 遍历每个柱子，累加当前柱子顶部可以储水的高度，
        // 即 当前柱子左右两边最大高度的较小者 - 当前柱子的高度。
        for (int i = 0; i < len; i++) {
            res += Math.min(dp[i][0], dp[i][1]) - height[i];
        }
        return res;
    }

    /**
     * 双指针
     * 在上述的动态规划方法中，我们用二维数组来存储每个柱子左右两侧的最大高度，但递推累加每个柱子的储水高度时其实只用到了 dp[i][0]和 dp[i][1] 两个值，因此我们递推的时候只需要用 int leftMax 和 int rightMax 两个变量就行了。
     * <p>
     * 即将上述代码中的递推公式：
     * <p>
     * res += Math.min(dp[i][0], dp[i][1]) - height[i];
     * <p>
     * 优化成：
     * <p>
     * res += Math.min(leftMax, rightMax) - height[i];
     * <p>
     * 注意这里的 leftMax 是从左端开始递推得到的，而 rightMax 是从右端开始递推得到的。
     * <p>
     * 因此遍历每个柱子，累加每个柱子的储水高度时，也需要用 left 和 right 两个指针从两端开始遍历。
     * <p>
     * 时间O(N) 空间O(1)
     *
     * @param height
     * @return
     */
    public static int trapDoublePointer(int[] height) {
        int res = 0, left = 0, leftMax = 0, right = height.length - 1, rightMax = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right--];
            }
        }
        return res;
    }

    /**
     * 单调递减栈
     * 用栈来跟踪可能储水的最长的条形块。使用栈就可以在一次遍历内完成计算。
     * <p>
     * 在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。
     * 如果发现一个条形块长于栈顶，可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此可以弹出栈顶元素并且累加答案到 res 。
     * <p>
     * 算法
     * <p>
     * 使用栈来存储条形块的索引下标。
     * 遍历数组：
     * 当栈非空且 height[current]>height[st.top()]
     * 意味着栈中元素可以被弹出。弹出栈顶元素 top。
     * 计算当前元素和栈顶元素的距离，准备进行填充操作
     * distance=current−st.top()−1
     * 找出界定高度
     * bounded_height=min(height[current],height[st.top()])−height[top]
     * 往答案中累加积水量 res+=distance×bounded_height
     * 将当前索引下标入栈
     * 将 current 移动到下个位置
     *
     * @param height
     * @return
     */
    public static int trapStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // 遍历每个柱体
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottomIdx = stack.peek();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[bottomIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    // stack.peek()是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i。
                    // Math.min(height[stack.peek()], height[i]) 是左右柱子高度的min，减去height[bottomIdx]就是雨水的高度。
                    // i - stack.peek() - 1 是雨水的宽度。
                    res += (Math.min(height[stack.peek()], height[i]) - height[bottomIdx]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("===============动态规划===================");
        System.out.println(trapDp(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapDp(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("===============双指针===================");
        System.out.println(trapDoublePointer(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapDoublePointer(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("===============单调栈===================");
        System.out.println(trapStack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapStack(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
