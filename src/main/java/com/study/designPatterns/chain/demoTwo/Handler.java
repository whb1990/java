package main.java.com.study.designPatterns.chain.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 17:38
 * @description: 抽象处理者类，定义职责对象
 */
public abstract class Handler {
    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor = null;

    /**
     * 设置下一个处理请求的对象
     *
     * @param successor 下一个处理请求的对象
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理聚餐费用的申请
     *
     * @param user 申请人
     * @param fee  申请的钱数
     * @return 成功或失败的具体通知
     */
    public abstract String handleFeeRequest(String user, double fee);
}
