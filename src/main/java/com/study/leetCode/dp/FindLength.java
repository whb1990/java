package main.java.com.study.leetCode.dp;

/**
 * @author: whb
 * @date: 2020/7/1 17:19
 * @description: LeetCode-718-最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class FindLength {
    /**
     * 思路：动态规划
     * <p>
     * 1.用dp(i,j)表示以A[i]和B[j]为结尾的,尾部后缀相同子串的最大长度；
     * 2.应该不难递推出dp[i, j]和dp[i+1,j+1]之间的关系，因为两者其实只差A[i+1]和B[j+1]这一对字符。
     * 3.若A[i+1]和B[j+1]不同，dp[i+1][j+1]自然应该是0，因为任何以它们为结尾的子串都不可能完全相同；
     * 4.而如果A[i+1]和B[j+1]相同，那么就只要在以A[i]和B[j]结尾的最长相同子串之后分别添上这两个字符即可，
     * 5.这样就可以让长度增加一位。
     *
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int result = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] != B[j]) {
                    dp[i + 1][j + 1] = 0;
                } else {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    result = Math.max(result, dp[i + 1][j + 1]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
