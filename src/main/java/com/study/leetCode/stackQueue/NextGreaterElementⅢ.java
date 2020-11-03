package main.java.com.study.leetCode.stackQueue;

/**
 * @author： whb
 * @description： LeetCode-556-下一个更大元素Ⅲ
 * @date： 2020-10-28 15:19
 * 难度：中等
 * 标签：字符串
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 * 示例 1:
 * 输入: 12
 * 输出: 21
 *
 * 示例 2:
 * 输入: 21
 * 输出: -1
 */
public class NextGreaterElementⅢ {
    /**
     * 线性解法
     * 将给定数字 n 当做字符数组 ch，首先观察到任意降序的序列，不会有更大的排列出现。比方说，下面数列就没有下一排列：
     * [9, 5, 4, 3, 1]
     *
     * 我们需要从右往左找到第一对连续的数字 a[i] 和 a[i-1] 满足 a[i-1] < a[i]。到当前位置，a[i-1] 右边的数字没办法产生一个更大的排列，因为右边的数字是降序的。所以需要重新排布 a[i-1] 到最右边的数字来得到下一个排列。
     *
     * 那么怎样排布能得到下一个更大的数字呢？想得到恰好大于当前数字的下一个排列，所以需要用恰好大于 a[i-1] 的数字去替换掉 a[i-1]，比方说让这个数字为 a[j]。
     *
     * 将 a[i-1] 和 a[j] 交换，现在在下标为 i-1 的地方得到了正确的数字，但当前的结果还不是一个正确的排列。需要用从 i-1 开始到最右边数字剩下来的数字升序排列，来得到它们中的最小排列。
     *
     * 我们注意到在从右往左找到第一对 a[i-1] < a[i] 的连续数字前， a[i-1] 右边的数字都是降序排列的，所以交换 a[i-1] 和 a[j]不会改变下标从 i 开始到最后的顺序。所以我们在交换了 a[i-1] 和 a[j]以后，只需要反转下标从 i 开始到最后的数字，就可以得到下一个字典序最小的排列。
     *
     * 举个例子：比如  1  5  8  4  7  6  5  3  1
     * 首先从右往左找到 左边的4 比 右边的5小， 所以交换这两个位置上的数字，变成如下排列：
     *  1  5  8  5  7  6  4  3  1
     *  得到的上面的排列的数字并非最接近原数字的第一大的数字，所以还需要将交换位置后的数字右边5以后位置的数字重新升序排列（因为右边5之后的数字是降序的），排列后的数字如下：
     *  1  5  8  5  1  3  4  6  7
     *
     *  时间复杂度：O(n)。最坏情况下，只会扫描整个数组两遍，这里 n 是给定数字的位数。
     *
     * 空间复杂度：O(n)。使用了大小为 n 的数组 a ，其中 n 是给定数字的位数。
     * @param n
     * @return
     */
    public static int nextGreaterElement(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        int i = ch.length - 2, j = ch.length - 1;
        while (i >= 0 && ch[i + 1] <= ch[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        while (j >= 0 && ch[j] <= ch[i]) {
            j--;
        }
        swap(ch, i, j);
        reverse(ch, i + 1);
        try {
            return Integer.parseInt(new String(ch));
        } catch (Exception e) {

        }
        return -1;
    }

    private static void reverse(char[] ch, int i) {
        int j = ch.length - 1;
        while (i < j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(21));
    }
}
