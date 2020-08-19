package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/8/19 10:32
 * @description: LeetCode-647-回文子串
 * 难度：中等
 * 标签：字符串、动态规划
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * 示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 * <p>
 * 提示：
 * 输入的字符串长度不会超过 1000 。
 */
public class CountSubstrings {
    /**
     * 中心扩展法
     * 比如对一个字符串ababa，选择最中间的a作为中心点，往两边扩散，第一次扩散发现left指向的是b，right指向的也是b，所以是回文串，继续扩散，同理ababa也是回文串。
     * <p>
     * 这个是确定了一个中心点后的寻找的路径，然后我们只要寻找到所有的中心点，问题就解决了。
     * <p>
     * 中心点一共有多少个呢？看起来像是和字符串长度相等，但你会发现，如果是这样，上面的例子永远也搜不到abab，想象一下单个字符的哪个中心点扩展可以得到这个子串？似乎不可能。所以中心点不能只有单个字符构成，还要包括两个字符，比如上面这个子串abab，就可以有中心点ba扩展一次得到，所以最终的中心点由2 * len - 1个，分别是len个单字符和len - 1个双字符。
     * <p>
     * 如果上面看不太懂的话，还可以看看下面几个问题：
     * <p>
     * 为什么有 2 * len - 1 个中心点？
     * aba 有5个中心点，分别是 a、b、c、ab、ba
     * abba 有7个中心点，分别是 a、b、b、a、ab、bb、ba
     * 什么是中心点？
     * 中心点即left指针和right指针初始化指向的地方，可能是一个也可能是两个
     * 为什么不可能是三个或者更多？
     * 因为3个可以由1个扩展一次得到，4个可以由两个扩展一次得到
     * <p>
     * 时间复杂度是O(N^2)，空间复杂度是O(1)
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int result = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static int countSubstringsDP(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstringsDP("abc"));
        System.out.println(countSubstringsDP("aaa"));
    }
}
