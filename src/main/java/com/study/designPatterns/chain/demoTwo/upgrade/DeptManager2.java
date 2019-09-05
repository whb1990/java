package main.java.com.study.designPatterns.chain.demoTwo.upgrade;

/**
 * @author: whb
 * @date: 2019/9/5 20:48
 * @description: 实现为部门经理增加预支差旅费用申请处理的功能的子对象，
 * 现在的部门经理既可以处理聚餐费用申请，又可以处理预支差旅费用申请
 */
public class DeptManager2 extends ProjectManager {
    @Override
    public Object handleRequest(RequestModel rm) {
        if (PreFeeRequestModel.FEE_TYPE.equals(rm.getType())) {
            //表示预支差旅费用申请
            return handlePreFeeRequest(rm);
        } else {
            //其它的让父类去处理
            return super.handleRequest(rm);
        }
    }

    /**
     * 预支差旅费用
     *
     * @param rm
     * @return
     */
    private Object handlePreFeeRequest(RequestModel rm) {
        //先把通用的对象造型回来
        PreFeeRequestModel frm = (PreFeeRequestModel) rm;
        //部门经理的权限在20000以内
        if (frm.getFee() < 20000) {
            //工作需要嘛，统统同意
            System.out.println("部门经理同意" + frm.getUser() + "预支差旅费用" + frm.getFee() + "元的请求");
            return true;
        } else {
            //超过20000，继续传递给级别更高的人处理
            if (this.successor != null) {
                return this.successor.handleRequest(rm);
            }
        }
        return false;
    }
}
