package main.java.com.study.designPatterns.chain.demoTwo.upgrade;

/**
 * @author: whb
 * @date: 2019/9/5 20:45
 * @description: 预支差旅费用请求对象
 */
public class PreFeeRequestModel extends RequestModel {
    /**
     * 约定具体的业务类型
     */
    public final static String FEE_TYPE = "preFee";

    public PreFeeRequestModel() {
        super(FEE_TYPE);
    }

    /**
     * 申请人
     */
    private String user;
    /**
     * 申请金额
     */
    private double fee;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
