package main.java.com.study.designPatterns.chain.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/5 17:39
 * @description: 具体处理者--项目经理
 */
public class ProjectManager extends Handler {
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        //项目经理的权限比较小，只能在500以内
        if (fee < 500) {
            //为了测试，简单点，只同意小李的
            if ("小李".equals(user)) {
                str = "项目经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                //其它人一律不同意
                str = "项目经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }
            return str;
        } else {
            //超过500，继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handleFeeRequest(user, fee);
            }
        }
        return str;
    }

    @Override
    public boolean handlePreFeeRequest(String user, double requestFee) {
        //项目经理的权限比较小，只能在5000以内
        if (requestFee < 5000) {
            //工作需要嘛，统统同意
            System.out.println("项目经理同意" + user + "预支差旅费用" + requestFee + "元的请求");
            return true;
        } else {
            //超过5000，继续传递给级别更高的人处理
            if (this.successor != null) {
                return this.successor.handlePreFeeRequest(user, requestFee);
            }
        }
        return false;
    }
}
