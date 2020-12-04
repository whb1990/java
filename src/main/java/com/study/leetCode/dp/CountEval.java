package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-面试题08.14.布尔运算
 * @date： 2020-12-04 9:08
 * 难度：中等
 * 标签：分治算法、区间DP
 */
public class CountEval {
    /**
     * 分治算法
     *
     * @param s
     * @param result
     * @return
     */
    public static int countEval(String s, int result) {
        int len = s.length();
        char[] ch = s.toCharArray();
        //用于记忆化（缓存结果集）
        int[][][] cache = new int[len][len][];
        int[] res = backtrack(ch, 0, ch.length - 1, cache);
        return result == 0 ? res[0] : res[1];
    }

    private static int[] backtrack(char[] ch, int left, int right, int[][][] cache) {
        int[] res = new int[2];
        if (left >= right) {
            res[ch[left] - '0'] = 1;
            return res;
        }
        //缓存中存在就直接返回
        if (cache[left][right] != null) {
            return cache[left][right];
        }
        for (int i = left; i <= right; i++) {
            //遇到数字就跳过
            if (ch[i] == '0' || ch[i] == '1') {
                continue;
            }
            //如果遇到运算符号：分治，分别计算运算符左边和右边的结果
            int[] leftRes = backtrack(ch, left, i - 1, cache);
            int[] rightRes = backtrack(ch, i + 1, right, cache);
            switch (ch[i]) {
                case '&':
                    //结果为0 有三种情况： 0 0, 0 1, 1 0
                    //结果为1 有一种情况： 1 1
                    res[0] += leftRes[0] * rightRes[0] + leftRes[0] * rightRes[1] + leftRes[1] * rightRes[0];
                    res[1] += leftRes[1] * rightRes[1];
                    break;
                case '|':
                    //结果为0 有一种情况： 0 0
                    //结果为1 有三种情况： 0 1, 1 0, 1 1
                    res[0] += leftRes[0] * rightRes[0];
                    res[1] += leftRes[0] * rightRes[1] + leftRes[1] * rightRes[0] + leftRes[1] * rightRes[1];
                    break;
                case '^':
                    //结果为0 有两种情况： 0 0, 1 1
                    //结果为1 有两种情况： 0 1, 1 0
                    res[0] += leftRes[0] * rightRes[0] + leftRes[1] * rightRes[1];
                    res[1] += leftRes[0] * rightRes[1] + leftRes[1] * rightRes[0];
                    break;
                default:
                    break;
            }
        }
        //缓存结果集
        cache[left][right] = res;
        return res;
    }




    public static void main(String[] args) {
        System.out.println("==========分治算法=========");
        System.out.println(countEval("1^0|0|1", 0));
        System.out.println(countEval("0&0&0&1^1|0", 1));

    }
}
