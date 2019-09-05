package main.java.com.study.designPatterns.chain.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 17:40
 * @description: 具体处理者--总经理
 */
public class GeneralManager extends Handler {
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        //总经理的权限很大，只要请求到了这里，他都可以处理
        if (fee >= 1000) {
            //为了测试，简单点，只同意小李的
            if ("小李".equals(user)) {
                str = "总经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                //其它人一律不同意
                str = "总经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }
            return str;
        } else {
            //如果还有后继的处理对象，继续传递
            if (this.successor != null) {
                return successor.handleFeeRequest(user, fee);
            }
        }
        return str;
    }

    @Override
    public boolean handlePreFeeRequest(String user, double requestFee) {
        //总经理的权限很大，只要到他这里就能处理
        if (requestFee >= 20000) {
            //工作需要嘛，统统同意
            System.out.println("总经理同意" + user + "预支差旅费用" + requestFee + "元的请求");
            return true;
        } else {
            //如果还有后继的处理对象，继续传递
            if (this.successor != null) {
                return this.successor.handlePreFeeRequest(user, requestFee);
            }
        }
        return false;
    }
}
