package main.java.com.study.leetCode.stackQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/3/9 19:56
 * @description: LeetCode 739-每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    /**
     * 该解法太耗时耗内存
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 在遍历数组时用栈把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，说明栈顶元素的下一个比它大的数就是当前元素。
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < len; curIndex++) {
            while (!indexs.isEmpty() && T[curIndex] > T[indexs.peek()]) {
                int preIndex = indexs.pop();
                result[preIndex] = curIndex - preIndex;
            }
            indexs.push(curIndex);
        }
        return result;
    }

    /**
     * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若T[i] < T[i+1]，那么res[i]=1；
     * - 若T[i] > T[i+1]
     * - res[i+1]=0，那么res[i]=0;
     * - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
     */
    public static int[] dailyTemperatures3(int[] T) {
        int[] result = new int[T.length];
        result[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j += result[j]) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        long start = System.currentTimeMillis();
        int[] result = dailyTemperatures3(T);
        long end = System.currentTimeMillis();
        System.out.println("方法一耗时：" + (end - start) + "毫秒。" + Arrays.toString(result));
    }
}
