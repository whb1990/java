package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-768-最多能完成排序的块Ⅱ
 * @date： 2020-12-03 17:59
 * 难度：困难
 * 标签：数组、栈
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 *
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 * 示例 1:
 *
 * 输入: arr = [5,4,3,2,1]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 *
 * 示例 2:
 *
 * 输入: arr = [2,1,3,4,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
 * 然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
 * 注意:
 *
 * arr的长度在[1, 2000]之间。
 * arr[i]的大小在[0, 10**8]之间。
 */
public class MaxChunksToSorted {
    /**
     * 单调递增栈
     * 每个栈内的元素代表块中最大的值，栈底到栈顶是升序。如果当前元素arr[i]比栈顶（也就是前i-1个序列最近的那一块的最大值）要大，则当前元素可以自己成为一个新的块，加入到栈中。
     * 否则，就需要与之前的块进行合并，需要先保存最近一块（即栈顶）的最大值max，合并的方法就是不断的pop，直到满足arr[i]大于等于当前的栈顶时，即满足了合并，
     * 合并后的块的最大值即为保存的那个最大值max加入到栈顶。最后只需要返回栈的元素个数即可。
     * @param arr
     * @return
     */
    public static int maxChunksToSorted(int[] arr) {
        // 保存每个块内的最大值， 因此该栈结构栈底到栈顶为升序
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() > num) {
                int top = stack.pop();
                //合并的做法是判断是否大于栈顶，否则pop掉
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                //将之前保留的最大值放入栈顶
                stack.push(top);
            } else {
                //当前值大于栈顶，则可以添加到栈中
                stack.push(num);
            }
        }
        //栈内的元素个数就代表块数
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
        System.out.println(maxChunksToSorted(new int[]{1, 1, 0, 0, 1}));
    }
}
