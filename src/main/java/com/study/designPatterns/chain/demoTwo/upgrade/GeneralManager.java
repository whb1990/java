package main.java.com.study.designPatterns.chain.demoTwo.upgrade;

/**
 * @author: whb
 * @date: 2019/9/5 20:39
 * @description: 总经理
 */
public class GeneralManager extends Handler {
    @Override
    public Object handleRequest(RequestModel rm) {
        if (FeeRequestModel.FEE_TYPE.equals(rm.getType())) {
            //表示聚餐费用申请
            return handleFeeRequest(rm);
        } else {
            //其它的总经理暂时不想处理
            return super.handleRequest(rm);
        }
    }

    /**
     * 聚餐费用处理
     *
     * @param rm
     * @return
     */
    private Object handleFeeRequest(RequestModel rm) {
        //先把通用的对象造型回来
        FeeRequestModel frm = (FeeRequestModel) rm;
        String str = "";
        //总经理的权限很大，只要请求到了这里，他都可以处理
        if (frm.getFee() >= 1000) {
            //为了测试，简单点，只同意小李的
            if ("小李".equals(frm.getUser())) {
                str = "总经理同意" + frm.getUser() + "聚餐费用" + frm.getFee() + "元的请求";
            } else {
                //其它人一律不同意
                str = "总经理不同意" + frm.getUser() + "聚餐费用" + frm.getFee() + "元的请求";
            }
            return str;
        } else {
            //如果还有后继的处理对象，继续传递
            if (this.successor != null) {
                return successor.handleRequest(rm);
            }
        }
        return str;
    }
}
