package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-901-股票价格跨度
 * @date： 2020-10-30 11:21
 * 难度：中等
 * 标签：栈
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 *
 *
 * 示例：
 *
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 *
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *
 *
 * 提示：
 *
 * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 */
public class StockSpanner {
    /**
     * 单调栈解法
     * 用单调栈维护一个单调递减的价格序列，并且对于每个价格，存储一个 weight 表示它离上一个价格之间（即最近的一个大于它的价格之间）的天数。
     * 如果是栈底的价格，则存储它本身对应的天数。例如 [11, 3, 9, 5, 6, 4, 7] 对应的单调栈为 (11, weight=1), (9, weight=2), (7, weight=4)。
     * <p>
     * 当得到了新的一天的价格，例如 10，将所有栈中所有小于等于 10 的元素全部取出，将它们的 weight 进行累加，再加上 1 就得到了答案。
     * 在这之后，把 10 和它对应的 weight 放入栈中，得到 (11, weight=1), (10, weight=7)。
     * 时间复杂度：O(Q)，其中 Q 是调用 next() 函数的次数。
     * <p>
     * 空间复杂度：O(Q)。
     */
    private Stack<Integer> prices, weights;

    public StockSpanner() {
        this.prices = new Stack<>();
        this.weights = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && price >= prices.peek()) {
            /**
             *  其他情况， 首先prices存储股票价格， weights 存储对应的股票价格跨度
             *
             *  prices.peek() <= price 为true, 则当天价格比prices栈顶高。此时需要：
             *     1. prices.pop(); 弹出栈顶价格，即前一天，前2天，直到不满足 prices.peek() <= price
             *
             *     2. w += weights.pop() 即为 w = w + weights.pop()
             *        这里要注意的时，每次weights.pop()即弹出prices.pop()对应的 股票价格跨度。
             *
             *        当prices.peek() <= price 不满足时，prices.peek()这个值肯定是比当前price当，
             *        所以prices.peek() 对应的weights.peek() 不再加在 w上。
             */
            prices.pop();
            w += weights.pop();
        }
        /**
         *  3种情况：
         *  1.  情况1：
         *          prices.isEmpty()为true，是第一天，则prices.push(price);
         *          而且w=1表示算上今天;  weights.push(w);
         *
         *  2.  情况2：
         *          不是第一天，但是prices.peek() <= price 为false,即 当天价格 比 前一天 低，则prices.push(price);
         *          而且w=1表示算上今天;  weights.push(w);
         *
         *  3. 情况3：
         *          比之前prices.peek() 大的 price 入栈， 则 prices.push(price)
         *          w 看while循环中注释
         */
        prices.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
