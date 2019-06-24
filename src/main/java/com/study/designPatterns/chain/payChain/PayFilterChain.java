package main.java.com.study.designPatterns.chain.payChain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/6/13 16:07
 * @description: 支付链
 */
public class PayFilterChain implements PayFilter {

    //支付链
    private List<PayFilter> payFilterList = new ArrayList<>();
    //用于标记支付的引用顺序
    int index = 0;

    public PayFilterChain addPayFilter(PayFilter payFilter) {
        payFilterList.add(payFilter);
        return this;
    }

    @Override
    public void doPay(int payAmount, PayFilterChain chain) {
        if (index >= payFilterList.size()) {
            return;
        }
        PayFilter payFilter = chain.payFilterList.get(index);
        index++;
        payFilter.doPay(payAmount, chain);
    }

    public static void main(String[] args) {
        PayFilterChain chain = new PayFilterChain();
        chain.addPayFilter(new MiCoinFilter()).addPayFilter(new WeChatFilter()).addPayFilter(new AlipayFilter());
        chain.doPay(23, chain);
    }
}
