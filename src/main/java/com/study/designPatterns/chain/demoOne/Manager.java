package main.java.com.study.designPatterns.chain.demoOne;

import java.util.Random;

/**
 * @author: whb
 * @date: 2019/9/5 17:23
 * @description: 具体处理者--经理
 */
public class Manager extends Handler {
    public Manager(String name) {
        super(name);
    }

    @Override
    public boolean process(LeaveRequest leaveRequest) {
        // 随机数大于3则为批准，否则不批准
        boolean result = (new Random().nextInt(10)) > 3;
        String log = "经理<%s> 审批 <%s> 的请假申请，请假天数： <%d> ，审批结果：<%s> ";
        System.out.println(String.format(log, this.name, leaveRequest.getName(), leaveRequest.getNumOfDays(), result == true ? "批准" : "不批准"));

        if (result == false) {
            // 不批准
            return false;
        } else if (leaveRequest.getNumOfDays() < 7) {
            // 批准且天数小于7
            return true;
        }
        // 批准且天数大于等于7，提交给下一个处理者处理
        return nextHandler.process(leaveRequest);
    }
}
