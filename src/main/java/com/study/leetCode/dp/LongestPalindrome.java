package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/8/19 10:12
 * @description: LeetCode-5-最长回文子串
 * 难度：中等
 * 标签：字符串、动态规划
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    /**
     * 动态规划解法
     * 1、状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
     * 2、状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false
     * 3、这个状态转移方程是什么意思呢？
     * 3.1、当只有一个字符时，比如a自然是一个回文串。
     * 3.2、当有两个字符时，如果是相等的，比如aa，也是一个回文串。
     * 3，3、当有三个及以上字符时，比如ababa这个字符记作串1，把两边的a去掉，也就是bab记作串2，可以看出只要串2是一个回文串，那么左右各多了一个a的串1必定也是回文串。
     * 所以当s[i]==s[j]时，自然要看dp[i+1][j-1]是不是一个回文串。
     * 时间复杂度为O(N^2)，空间复杂度为O(N^2)。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = "";
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                /**
                 * 如果一个字符串的头尾两个字符都不相等，那么这个字符串一定不是回文串；
                 * 如果一个字符串的头尾两个字符相等，才有必要继续判断下去。
                 * 如果里面的子串是回文，整体就是回文串；
                 * 如果里面的子串不是回文串，整体就不是回文串。
                 * 即：在头尾字符相等的情况下，里面子串的回文性质据定了整个子串的回文性质，这就是状态转移。因此可以把「状态」定义为原字符串的一个子串是否为回文子串。
                 */
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    String tmp = s.substring(i, j + 1);
                    result = tmp.length() > result.length() ? tmp : result;
                }
            }
        }
        return result;
    }

    /**
     * 中心扩展法
     * 比如对一个字符串ababa，选择最中间的a作为中心点，往两边扩散，第一次扩散发现left指向的是b，right指向的也是b，所以是回文串，继续扩散，同理ababa也是回文串。
     * <p>
     * 这个是确定了一个中心点后的寻找的路径，然后我们只要寻找到所有的中心点，问题就解决了。
     * <p>
     * 中心点一共有多少个呢？看起来像是和字符串长度相等，但你会发现，如果是这样，上面的例子永远也搜不到abab，想象一下单个字符的哪个中心点扩展可以得到这个子串？
     * 似乎不可能。所以中心点不能只有单个字符构成，还要包括两个字符，比如上面这个子串abab，就可以有中心点ba扩展一次得到，所以最终的中心点由2 * len - 1个，分别是len个单字符和len - 1个双字符。
     * <p>
     * 如果上面看不太懂的话，还可以看看下面几个问题：
     * <p>
     * 1、为什么有 2 * len - 1 个中心点？
     * aba 有5个中心点，分别是 a、b、c、ab、ba
     * abba 有7个中心点，分别是 a、b、b、a、ab、bb、ba
     * 2、什么是中心点？
     * 中心点即left指针和right指针初始化指向的地方，可能是一个也可能是两个
     * 3、为什么不可能是三个或者更多？
     * 因为3个可以由1个扩展一次得到，4个可以由两个扩展一次得到
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        String result = "";
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                String tmp = s.substring(left, right + 1);
                result = tmp.length() > result.length() ? tmp : result;
                left--;
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbd"));
    }
}

